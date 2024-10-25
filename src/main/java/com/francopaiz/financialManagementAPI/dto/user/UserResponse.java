package com.francopaiz.financialManagementAPI.dto.user;


import lombok.Data;

@Data
public class UserResponse {

    private String id;

    /**
     * Nombre del usuario.
     * Este campo almacena el nombre completo del usuario.
     */
    private String name;

    /**
     * Correo electrónico.
     * Este campo almacena la dirección de correo electrónico del usuario.
     */
    private String email;

    /**
     * Contraseña del usuario.
     * Este campo almacena la contraseña del usuario.
     */
    private String password;

    /**
     * Teléfono del usuario.
     * Este campo almacena el número de teléfono del usuario.
     */
    private String phone;
}