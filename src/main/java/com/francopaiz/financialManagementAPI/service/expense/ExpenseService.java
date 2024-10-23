package com.francopaiz.financialManagementAPI.service.expense;

import com.francopaiz.financialManagementAPI.model.Expense;
import com.francopaiz.financialManagementAPI.model.Income;
import com.francopaiz.financialManagementAPI.model.User;

import java.util.List;

public interface ExpenseService {
    List<Expense> findAll();
    Expense findById(String id);
    Expense save(Expense expense);
    Expense update(String id, Expense expense);
    void deleteById(String id);
    List<Expense> findByUser(User user);
    List<Expense> findIncomesForAuthenticatedUser();
}
