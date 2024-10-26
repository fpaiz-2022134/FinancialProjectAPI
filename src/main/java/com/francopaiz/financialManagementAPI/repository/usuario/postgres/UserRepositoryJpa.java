package com.francopaiz.financialManagementAPI.repository.usuario.postgres;

import com.francopaiz.financialManagementAPI.model.mongo.UserMongo;
import com.francopaiz.financialManagementAPI.model.postgres.UserPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserPostgres, Long> {
    /**
     * Busca un usuario por su email.
     *
     * @param email El email del usuario a buscar.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<UserPostgres> findByEmail(String email);
}
