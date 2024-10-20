package com.francopaiz.financialManagementAPI.service.expense;

import com.francopaiz.financialManagementAPI.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> findAll();
    Expense findById(String id);
    Expense save(Expense expense);
    Expense update(String id, Expense expense);
    void deleteById(String id);

}
