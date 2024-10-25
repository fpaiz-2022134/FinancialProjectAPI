package com.francopaiz.financialManagementAPI.dto.user;

public class UserRequestLogin {

    /**
     * Email de usuario.
     * Este campo se utiliza para almacenar el email de usuario que el usuario ingresará para iniciar sesión.
     */
    private String email;

    /**
     * Contraseña del usuario.
     * Este campo se utiliza para almacenar la contraseña que el usuario ingresará para autenticar su cuenta.
     */
    private String password;
}