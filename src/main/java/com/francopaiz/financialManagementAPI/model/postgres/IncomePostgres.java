package com.francopaiz.financialManagementAPI.model.postgres;

import com.francopaiz.financialManagementAPI.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "incomes")
public class IncomePostgres {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "source", nullable = false)
    private String source;

    @Setter
    @Getter
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Setter
    @Getter
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserPostgres user;

    public IncomePostgres() {
    }

    public IncomePostgres(Long id, String source, BigDecimal amount, LocalDate date, UserPostgres user) {
        this.id = id;
        this.source = source;
        this.amount = amount;
        this.date = date;
        this.user = user;
    }


}