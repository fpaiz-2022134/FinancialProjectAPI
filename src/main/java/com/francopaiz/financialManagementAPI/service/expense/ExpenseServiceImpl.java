package com.francopaiz.financialManagementAPI.service.expense;

import com.francopaiz.financialManagementAPI.model.Expense;
import com.francopaiz.financialManagementAPI.repository.expense.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense findById(String id) {
        return expenseRepository.findById(id).orElse(null);
    }

    @Override
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense update(String id, Expense expense) {

        Expense existingExpense = expenseRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Gasto no encontrado"));

        if(expense.getDescription()!= null){
            existingExpense.setDescription(expense.getDescription());
        }

        if(expense.getAmount()!= null){
            existingExpense.setAmount(expense.getAmount());
        }

        if (expense.getDate()!= null){
            existingExpense.setDate(expense.getDate());
        }

        if (expense.getUser()!= null){
            existingExpense.setUser(expense.getUser());
        }

        if(expense.getCategory()!= null){
            existingExpense.setCategory(expense.getCategory());
        }


        return expenseRepository.save(existingExpense);
    }

    @Override
    public void deleteById(String id) {

    }
}
