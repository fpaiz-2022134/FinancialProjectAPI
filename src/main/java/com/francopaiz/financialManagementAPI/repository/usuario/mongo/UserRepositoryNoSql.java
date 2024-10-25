package com.francopaiz.financialManagementAPI.repository.usuario.mongo;

import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.model.mongo.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryNoSql extends MongoRepository<UserMongo, String> {

    /**
     * Busca un usuario por su email.
     *
     * @param email El email del usuario a buscar.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<UserMongo> findByEmail(String email);
}