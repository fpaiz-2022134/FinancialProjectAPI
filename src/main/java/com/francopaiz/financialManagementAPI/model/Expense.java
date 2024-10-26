package com.francopaiz.financialManagementAPI.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class Expense {

    private String id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Category category;

    private User user;


    public Expense() {
    }

    public Expense(String id, String description, BigDecimal amount, LocalDate date, Category category, User user) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.user = user;
    }

}
