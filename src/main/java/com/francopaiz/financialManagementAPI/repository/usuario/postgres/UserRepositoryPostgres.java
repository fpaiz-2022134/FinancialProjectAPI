package com.francopaiz.financialManagementAPI.repository.usuario.postgres;

import com.francopaiz.financialManagementAPI.caster.UserCaster;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.model.postgres.UserPostgres;
import com.francopaiz.financialManagementAPI.repository.usuario.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementación del repositorio de usuarios para PostgreSQL.
 * Esta clase implementa las operaciones definidas en la interfaz UserRepository
 * y utiliza un repositorio JPA para acceder a los datos de los usuarios.
 */
@Profile("postgres")

@RequiredArgsConstructor

@Repository
public class UserRepositoryPostgres implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa; // Repositorio JPA para operaciones CRUD
    private final UserCaster userCaster; // Utilidad para convertir entre User y UserPostgres



    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param user El usuario a crear.
     * @return El usuario creado.
     */
    @Override
    public User createUser(User user) {
        UserPostgres userPostgres = userCaster.userToUserPostgres(user); // Conversión a formato PostgreSQL
        UserPostgres newUser = userRepositoryJpa.save(userPostgres); // Guardar en la base de datos
        return userCaster.userPostgresToUser(newUser); // Convertir de nuevo a User
    }

    /**
     * Obtiene una lista de todos los usuarios.
     *
     * @return Una lista de usuarios.
     */
    @Override
    public List<User> getUsers() {
        return userRepositoryJpa.findAll().stream() // Obtener todos los usuarios en formato PostgreSQL
                .map(userCaster::userPostgresToUser) // Convertir a formato User
                .collect(Collectors.toList());
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return Un Optional que puede contener el usuario si se encuentra, o vacío si no.
     */
    @Override
    public Optional<User> findUserById(String id) {
        Optional<UserPostgres> userPostgres = userRepositoryJpa.findById(Long.parseLong(id)); // Buscar en la base de datos
        return userPostgres.map(userCaster::userPostgresToUser); // Convertir si se encuentra
    }

    /**
     * Actualiza un usuario existente en la base de datos.
     *
     * @param user El usuario con los datos actualizados.
     * @return El usuario actualizado.
     */
    @Override
    public User updateUser(User user) {
        UserPostgres userPostgres = userCaster.userToUserPostgres(user); // Conversión a formato PostgreSQL
        UserPostgres updatedUser = userRepositoryJpa.save(userPostgres); // Guardar en la base de datos
        return userCaster.userPostgresToUser(updatedUser); // Convertir de nuevo a User
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id El ID del usuario a eliminar.
     */
    @Override
    public void deleteUser(String id) {
        userRepositoryJpa.deleteById(Long.parseLong(id)); // Eliminar de la base de datos
    }

    /**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return Un Optional que puede contener el usuario si se encuentra, o vacío si no.
     */
    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserPostgres> userPostgres = userRepositoryJpa.findByEmail(email); // Buscar en la base de datos
        return userPostgres.map(userCaster::userPostgresToUser); // Convertir si se encuentra
    }
}
