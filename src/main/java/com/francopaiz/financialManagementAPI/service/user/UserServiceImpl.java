package com.francopaiz.financialManagementAPI.service.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.repository.usuario.UserRepository;
import com.francopaiz.financialManagementAPI.dto.user.UserRequest;
import com.francopaiz.financialManagementAPI.dto.user.UserResponse;
import com.francopaiz.financialManagementAPI.dto.user.UserRequestUpdate;
import com.francopaiz.financialManagementAPI.caster.UserCaster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de la interfaz UserService que proporciona métodos para manejar
 * las operaciones relacionadas con los usuarios en la biblioteca.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCaster userCaster;

    private static final String USER_NOT_FOUND = "User not found with ID: ";

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public UserResponse saveUser(User user) {
        User savedUser = userRepository.createUser(user);
        return userCaster.userToUserResponse(savedUser);
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.getUsers();
        return users.stream().map(userCaster::userToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(String idUser) {
        validateIdFormat(idUser); // Verifica el formato del ID
        User user = userRepository.findUserById(idUser)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + idUser));
        return userCaster.userToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(String idUser, UserRequestUpdate userRequestUpdate) {
        validateIdFormat(idUser); // Verifica el formato del ID
        User user = userRepository.findUserById(idUser)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + idUser));
        user.setName(userRequestUpdate.getName());
        user.setEmail(userRequestUpdate.getEmail());
        User update = userRepository.updateUser(user);
        return userCaster.userToUserResponse(update);
    }

    @Override
    public void deleteUser(String idUser) {
        validateIdFormat(idUser); // Verifica el formato del ID
        userRepository.findUserById(idUser)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + idUser));
        userRepository.deleteUser(idUser);
    }

    private void validateIdFormat(String idUser) {
        if (profile.equals("postgres")) {
            try {
                Long.parseLong(idUser);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid idUser format for Postgres: " + idUser);
            }
        }
    }
}
