package com.francopaiz.financialManagementAPI.model.postgres;


// Importa las anotaciones de JPA.

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "category")
public class CategoryPostgres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
