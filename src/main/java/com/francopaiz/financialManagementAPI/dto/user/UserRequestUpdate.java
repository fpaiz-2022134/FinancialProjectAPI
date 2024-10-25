package com.francopaiz.financialManagementAPI.dto.user;


import lombok.Data;

@Data
public class UserRequestUpdate {

    /**
     * Nombre del usuario.
     * Este campo se utiliza para almacenar el nuevo nombre del usuario que se actualizará en el sistema.
     */
    private String name;


    /**
     * Correo electrónico.
     * Este campo se utiliza para almacenar el nuevo correo electrónico del usuario que se actualizará en el sistema.
     */
    private String email;

    /**
     * Teléfono.
     * Este campo se utiliza para almacenar el nuevo teléfono del usuario que se actualizará en el sistema.
     */
    private String phone;


}
