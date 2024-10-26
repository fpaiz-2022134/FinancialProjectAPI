package com.francopaiz.financialManagementAPI.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Setter
@Data
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor  // Genera el constructor sin argumentos
public class FinancialSummary {

    @Getter
    private BigDecimal totalExpenses;
    @Getter
    private BigDecimal totalIncome;
    @Getter
    private BigDecimal balance;
    //Incomes - expenses

    @Getter
    private Map<Category, BigDecimal> expensesByCategory;

}

