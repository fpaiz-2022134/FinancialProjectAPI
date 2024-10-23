package com.francopaiz.financialManagementAPI.caster;

import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.model.mongo.UserMongo;
import com.francopaiz.financialManagementAPI.model.postgres.UserPostgres;
import org.springframework.stereotype.Component;

/**
 * Clase utilitaria para realizar conversiones entre diferentes representaciones
 * de usuarios, específicamente entre User, UserMongo y UserPostgres.
 */
@Component
public class UserCaster {

    /**
     * Convierte un objeto User a un objeto UserMongo.
     *
     * @param user El objeto User que se va a convertir.
     * @return Un objeto UserMongo que representa el usuario.
     */
    public UserMongo userToUserMongo(User user) {
        UserMongo userMongo = new UserMongo();
        userMongo.setId(user.getId());
        userMongo.setName(user.getName());
        userMongo.setEmail(user.getEmail());
        userMongo.setPassword(user.getPassword()); // Se codificará en el setter
        userMongo.setPhone(user.getPhone());
        return userMongo;
    }

    /**
     * Convierte un objeto UserMongo a un objeto User.
     *
     * @param userMongo El objeto UserMongo que se va a convertir.
     * @return Un objeto User que representa el usuario.
     */
    public User userMongoToUser(UserMongo userMongo) {
        User user = new User();
        user.setId(userMongo.getId());
        user.setName(userMongo.getName());
        user.setEmail(userMongo.getEmail());
        user.setPassword(userMongo.getPassword()); // Se mantendrá codificada
        user.setPhone(userMongo.getPhone());
        return user;
    }

    /**
     * Convierte un objeto User a un objeto UserPostgres.
     *
     * @param user El objeto User que se va a convertir.
     * @return Un objeto UserPostgres que representa el usuario.
     */
    public UserPostgres userToUserPostgres(User user) {
        UserPostgres userPostgres = new UserPostgres();
        userPostgres.setId(Long.valueOf(user.getId())); // Asegúrate de manejar la conversión del ID correctamente
        userPostgres.setName(user.getName());
        userPostgres.setEmail(user.getEmail());
        userPostgres.setPassword(user.getPassword()); // Se codificará en el setter
        userPostgres.setPhone(user.getPhone());
        return userPostgres;
    }

    /**
     * Convierte un objeto UserPostgres a un objeto User.
     *
     * @param userPostgres El objeto UserPostgres que se va a convertir.
     * @return Un objeto User que representa el usuario.
     */
    public User userPostgresToUser(UserPostgres userPostgres) {
        User user = new User();
        user.setId(String.valueOf(userPostgres.getId())); // Asegúrate de manejar la conversión del ID correctamente
        user.setName(userPostgres.getName());
        user.setEmail(userPostgres.getEmail());
        user.setPassword(userPostgres.getPassword()); // Se mantendrá codificada
        user.setPhone(userPostgres.getPhone());
        return user;
    }

    /**
     * Convierte un objeto UserMongo a un objeto UserPostgres.
     *
     * @param userMongo El objeto UserMongo que se va a convertir.
     * @return Un objeto UserPostgres que representa el usuario.
     */
    public UserPostgres userMongoToUserPostgres(UserMongo userMongo) {
        UserPostgres userPostgres = new UserPostgres();
        userPostgres.setId(Long.valueOf(userMongo.getId())); // Asegúrate de manejar la conversión del ID correctamente
        userPostgres.setName(userMongo.getName());
        userPostgres.setEmail(userMongo.getEmail());
        userPostgres.setPassword(userMongo.getPassword()); // Se mantendrá codificada
        userPostgres.setPhone(userMongo.getPhone());
        return userPostgres;
    }

    /**
     * Convierte un objeto UserPostgres a un objeto UserMongo.
     *
     * @param userPostgres El objeto UserPostgres que se va a convertir.
     * @return Un objeto UserMongo que representa el usuario.
     */
    public UserMongo userPostgresToUserMongo(UserPostgres userPostgres) {
        UserMongo userMongo = new UserMongo();
        userMongo.setId(String.valueOf(userPostgres.getId())); // Asegúrate de manejar la conversión del ID correctamente
        userMongo.setName(userPostgres.getName());
        userMongo.setEmail(userPostgres.getEmail());
        userMongo.setPassword(userPostgres.getPassword()); // Se mantendrá codificada
        userMongo.setPhone(userPostgres.getPhone());
        return userMongo;
    }
}
