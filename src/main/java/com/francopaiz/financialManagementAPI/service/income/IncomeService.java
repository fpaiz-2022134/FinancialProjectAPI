package com.francopaiz.financialManagementAPI.service.income;

import com.francopaiz.financialManagementAPI.model.Income;
import com.francopaiz.financialManagementAPI.model.User;

import java.util.List;
import java.util.Optional;

public interface IncomeService {

    List<Income> findAll();
    Income findById(String id);
    Income save(Income income);
    Income update(String id, Income income);
    void deleteById(String id);
}
