package com.francopaiz.financialManagementAPI.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Expense {

    private String id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Category category;
    private User user;

}
