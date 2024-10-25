package com.francopaiz.financialManagementAPI.service.expense;

import com.francopaiz.financialManagementAPI.model.Expense;
import com.francopaiz.financialManagementAPI.model.Income;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.repository.expense.ExpenseRepository;
import com.francopaiz.financialManagementAPI.repository.usuario.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Expense> getExpenses() {
        return expenseRepository.getExpenses();
    }

    @Override
    public Expense findExpenseById(String id) {
        return expenseRepository.findExpenseById(id).orElse(null);
    }

    @Override
    public Expense createExpense(Expense expense) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedId = (String) authentication.getPrincipal();

        System.out.println("Id del autenticado: " + authenticatedId);
        User authenticatedUser = userRepository.findUserById(authenticatedId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Asignar el usuario autenticado al ingreso
        expense.setUser(authenticatedUser);

        if (expense.getDate() == null) {
            expense.setDate(LocalDate.now());
        }

        return expenseRepository.createExpense(expense);
    }

    @Override
    public Expense updateExpense(String id, Expense expense) {

        Expense existingExpense = expenseRepository.findExpenseById(id).orElseThrow(()-> new IllegalArgumentException("Gasto no encontrado"));

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


        return expenseRepository.updateExpense(existingExpense);
    }

    @Override
    public void deleteExpense(String id) {
         expenseRepository.deleteExpense(id);
    }

    @Override
    public List<Expense> findByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    @Override
    public List<Expense> findExpensesForAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedId = (String) authentication.getPrincipal();

        // Buscar el usuario autenticado
        User authenticatedUser = userRepository.findUserById(authenticatedId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Buscar todos los ingresos de este usuario
        return expenseRepository.findByUser(authenticatedUser);
    }

}
