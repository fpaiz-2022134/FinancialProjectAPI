package com.francopaiz.financialManagementAPI.service.income;

import com.francopaiz.financialManagementAPI.model.Income;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.repository.income.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    private  IncomeRepository incomeRepository;

    @Override
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    @Override
    public Income findById(String id) {
        return incomeRepository.findById(id).orElse(null);
    }

    @Override
    public Income save(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income update(String id, Income income) {
        Income existingIncome = incomeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ingreso no encontrado"));

        if(income.getAmount()!= null){
            existingIncome.setAmount(income.getAmount());
        }

        if (income.getDate()!= null){
            existingIncome.setDate(income.getDate());
        }

        if(income.getSource()!= null){
            existingIncome.setSource(income.getSource());
        }

        if (income.getAmount()!= null){
            existingIncome.setAmount(income.getAmount());
        }

        if (income.getUser()!= null){
            existingIncome.setUser(income.getUser());
        }

        return incomeRepository.save(existingIncome);
    }

    @Override
    public void deleteById(String id) {
        incomeRepository.deleteById(id);
    }

}
