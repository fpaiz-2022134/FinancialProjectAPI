package com.francopaiz.financialManagementAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;


@Document(collection = "incomes")
public class Income {
    private Long id;
    private String source;
    private BigDecimal amount;
    private LocalDate date;
    private User user;

    public Income( String source, BigDecimal amount, LocalDate date, User user) {

        this.source = source;
        this.amount = amount;
        this.date = date;
        this.user = user;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

