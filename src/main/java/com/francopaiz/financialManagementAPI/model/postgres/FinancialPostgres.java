package com.francopaiz.financialManagementAPI.model.postgres;

import com.francopaiz.financialManagementAPI.model.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name = "summary")
public class FinancialPostgres {
    

    @Column(name = "total_expenses", nullable = false)
    private BigDecimal totalExpenses;

    @Column(name = "total_income", nullable = false)
    private BigDecimal totalIncome;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance; // Incomes - expenses

    // Map cannot be directly persisted, so we'll use @ElementCollection for a map of basic or embeddable types
    @ElementCollection
    @CollectionTable(name = "expenses_by_category", joinColumns = @JoinColumn(name = "summary_id"))
    @MapKeyJoinColumn(name = "category_id") // Assuming Category is an entity
    @Column(name = "expense_amount")
    private Map<Category, BigDecimal> expensesByCategory;


    public FinancialPostgres() {
    }

    public FinancialPostgres(BigDecimal totalExpenses, BigDecimal totalIncome, BigDecimal balance, Map<Category, BigDecimal> expensesByCategory) {
        this.totalExpenses = totalExpenses;
        this.totalIncome = totalIncome;
        this.balance = balance;
        this.expensesByCategory = expensesByCategory;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Map<Category, BigDecimal> getExpensesByCategory() {
        return expensesByCategory;
    }

    public void setExpensesByCategory(Map<Category, BigDecimal> expensesByCategory) {
        this.expensesByCategory = expensesByCategory;
    }
}
