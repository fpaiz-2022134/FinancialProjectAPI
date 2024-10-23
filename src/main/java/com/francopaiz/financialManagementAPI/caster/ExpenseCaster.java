package com.francopaiz.financialManagementAPI.caster;

import com.francopaiz.financialManagementAPI.model.Expense;
import com.francopaiz.financialManagementAPI.model.mongo.ExpenseMongo;
import com.francopaiz.financialManagementAPI.model.postgres.ExpensePostgres;
import org.springframework.stereotype.Component;

/**
 * Clase utilitaria para realizar conversiones entre diferentes representaciones
 * de un gasto, específicamente entre Expense, ExpensePostgres y ExpenseMongo.
 */
@Component
public class ExpenseCaster {

    /**
     * Convierte un objeto Expense a un objeto ExpensePostgres.
     *
     * @param expense El objeto Expense que se va a convertir.
     * @return Un objeto ExpensePostgres que representa el gasto.
     */
    public ExpensePostgres expenseToExpensePostgres(Expense expense) {
        ExpensePostgres expensePostgres = new ExpensePostgres();
        expensePostgres.setId((expense.getId() != null && !expense.getId().isEmpty())
                ? Long.parseLong(expense.getId()) : null);
        expensePostgres.setDescription(expense.getDescription());
        expensePostgres.setAmount(expense.getAmount());
        expensePostgres.setDate(expense.getDate());
        expensePostgres.setCategory(expense.getCategory());
        expensePostgres.setUser(expense.getUser());
        return expensePostgres;
    }

    /**
     * Convierte un objeto ExpensePostgres a un objeto Expense.
     *
     * @param expensePostgres El objeto ExpensePostgres que se va a convertir.
     * @return Un objeto Expense que representa el gasto.
     */
    public Expense expensePostgresToExpense(ExpensePostgres expensePostgres) {
        Expense expense = new Expense();
        expense.setId(String.valueOf(expensePostgres.getId()));
        expense.setDescription(expensePostgres.getDescription());
        expense.setAmount(expensePostgres.getAmount());
        expense.setDate(expensePostgres.getDate());
        expense.setCategory(expensePostgres.getCategory());
        expense.setUser(expensePostgres.getUser());
        return expense;
    }

    /**
     * Convierte un objeto Expense a un objeto ExpenseMongo.
     *
     * @param expense El objeto Expense que se va a convertir.
     * @return Un objeto ExpenseMongo que representa el gasto.
     */
    public ExpenseMongo expenseToExpenseMongo(Expense expense) {
        ExpenseMongo expenseMongo = new ExpenseMongo();
        expenseMongo.setId(expense.getId());
        expenseMongo.setDescription(expense.getDescription());
        expenseMongo.setAmount(expense.getAmount());
        expenseMongo.setDate(expense.getDate());
        expenseMongo.setCategory(expense.getCategory());
        expenseMongo.setUser(expense.getUser());
        return expenseMongo;
    }

    /**
     * Convierte un objeto ExpenseMongo a un objeto Expense.
     *
     * @param expenseMongo El objeto ExpenseMongo que se va a convertir.
     * @return Un objeto Expense que representa el gasto.
     */
    public Expense expenseMongoToExpense(ExpenseMongo expenseMongo) {
        Expense expense = new Expense();
        expense.setId(expenseMongo.getId());
        expense.setDescription(expenseMongo.getDescription());
        expense.setAmount(expenseMongo.getAmount());
        expense.setDate(expenseMongo.getDate());
        expense.setCategory(expenseMongo.getCategory());
        expense.setUser(expenseMongo.getUser());
        return expense;
    }
}

