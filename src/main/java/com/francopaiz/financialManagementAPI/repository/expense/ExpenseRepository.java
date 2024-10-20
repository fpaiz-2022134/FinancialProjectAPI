package com.francopaiz.financialManagementAPI.repository.expense;

import com.francopaiz.financialManagementAPI.model.Expense;

import com.francopaiz.financialManagementAPI.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    List<Expense> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);

}
