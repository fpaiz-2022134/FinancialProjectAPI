package com.francopaiz.financialManagementAPI.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

/*@Document(collection = "incomes")*/

@Data
public class Income {
    @Id
    private String id;
    private String source;
    private BigDecimal amount;
    private LocalDate date;
    private User user;



}

