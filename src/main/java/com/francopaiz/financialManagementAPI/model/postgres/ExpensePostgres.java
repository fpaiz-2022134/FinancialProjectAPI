package com.francopaiz.financialManagementAPI.model.postgres;

import com.francopaiz.financialManagementAPI.model.Category;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.repository.category.CategoryRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
@Entity
@Table(name = "expense")
public class ExpensePostgres{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String description;
    private BigDecimal amount;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryPostgres category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPostgres user;


    public ExpensePostgres() {
    }

    public ExpensePostgres(Long id, String description, BigDecimal amount, LocalDate date, CategoryPostgres category, UserPostgres user) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.user = user;
    }

    /*public Category getCategory(CategoryRepository categoryRepository) {
        return categoryRepository.findCategoryById(idCategory)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + idCategory));
    }*/

}