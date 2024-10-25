package com.francopaiz.financialManagementAPI.dto.user;

public class UserRequest {

    /**
     * Nombre del usuario.
     * Este campo se utiliza para almacenar el nombre completo del usuario.
     */
    private String name;

    /**
     * Correo electrónico del usuario.
     * Este campo se utiliza para almacenar la dirección de correo electrónico del usuario, que se utilizará para la comunicación y recuperación de cuentas.
     */
    private String email;

    /**
     * Contraseña del usuario.
     * Este campo se utiliza para almacenar la contraseña del usuario, que se cifrará antes de almacenarse en la base de datos.
     */
    private String password;

    /**
     * Teléfono del usuario.
     * Este campo se utiliza para almacenar el teléfono del usuario.
     */
    private String phone;
}