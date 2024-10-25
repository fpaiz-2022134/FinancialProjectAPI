package com.francopaiz.financialManagementAPI.service.income;

import com.francopaiz.financialManagementAPI.model.Income;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.repository.income.IncomeRepository;
import com.francopaiz.financialManagementAPI.repository.usuario.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    private  IncomeRepository incomeRepository;

    @Autowired
    private  UserRepository userRepository;

    @Override
    public List<Income> getIncomes() {
        return incomeRepository.getIncomes();
    }

    @Override
    public Income findIncomeById(String id) {
        return incomeRepository.findIncomeById(id).orElse(null);
    }

    @Override
    public Income createIncome(Income income) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedId = (String) authentication.getPrincipal();

        System.out.println(authenticatedId);
        User authenticatedUser = userRepository.findUserById(authenticatedId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Asignar el usuario autenticado al ingreso
        income.setUser(authenticatedUser);

        if (income.getDate() == null) {
            income.setDate(LocalDate.now());
        }

        return incomeRepository.createIncome(income);
    }

    @Override
    public Income updateIncome(String id, Income income) {
        Income existingIncome = incomeRepository.findIncomeById(id).orElseThrow(()-> new IllegalArgumentException("Ingreso no encontrado"));

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

        return incomeRepository.updateIncome(existingIncome);
    }

    @Override
    public void deleteIncome(String id) {
        incomeRepository.deleteIncome(id);
    }


    @Override
    public List<Income> findByUser(User user) {
        return incomeRepository.findByUser(user);
    }

    @Override
    public List<Income> findIncomesForAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedId = (String) authentication.getPrincipal();

        // Buscar el usuario autenticado
        User authenticatedUser = userRepository.findUserById(authenticatedId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Buscar todos los ingresos de este usuario
        return incomeRepository.findByUser(authenticatedUser);
    }
}
