package com.francopaiz.financialManagementAPI.repository.income;

import com.francopaiz.financialManagementAPI.model.Expense;
import com.francopaiz.financialManagementAPI.model.Income;
import com.francopaiz.financialManagementAPI.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends MongoRepository <Income, String> {
    List<Income> findByUser(User user);

    List<Income> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);
}
