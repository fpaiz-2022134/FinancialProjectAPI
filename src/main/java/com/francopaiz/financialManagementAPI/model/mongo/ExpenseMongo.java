package com.francopaiz.financialManagementAPI.model.mongo;


import com.francopaiz.financialManagementAPI.model.Category;
import com.francopaiz.financialManagementAPI.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Document(collection = "expenses")
public class ExpenseMongo {

    @Id
    private String id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;

    private Category category;
    private User user;

    public ExpenseMongo() {
    }

    public ExpenseMongo(String id, String description, BigDecimal amount, LocalDate date, Category category, User user) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.user = user;
    }


}
