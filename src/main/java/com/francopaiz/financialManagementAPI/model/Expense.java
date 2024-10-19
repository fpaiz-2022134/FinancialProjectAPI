package com.francopaiz.financialManagementAPI.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Category category;
    private User user;


    public Expense(String description, BigDecimal amount, LocalDate date, Category category, User user) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
