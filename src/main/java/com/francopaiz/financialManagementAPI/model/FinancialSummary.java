package com.francopaiz.financialManagementAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Map;


@Document(collection = "summary")
public class FinancialSummary {

    private BigDecimal totalExpenses;
    private BigDecimal totalIncome;
    private BigDecimal balance; //Incomes - expenses
    private Map<Category, BigDecimal> expensesByCategory;



}
