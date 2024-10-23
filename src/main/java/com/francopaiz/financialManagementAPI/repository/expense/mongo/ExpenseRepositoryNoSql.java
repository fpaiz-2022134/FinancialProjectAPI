package com.francopaiz.financialManagementAPI.repository.expense.mongo;

import com.francopaiz.financialManagementAPI.model.Expense;

import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.model.mongo.ExpenseMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepositoryNoSql extends MongoRepository<ExpenseMongo, String> {
    List<ExpenseMongo> findByUser(User user);
    List<ExpenseMongo> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);

}