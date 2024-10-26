package com.francopaiz.financialManagementAPI.caster;

import com.francopaiz.financialManagementAPI.model.Income;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.model.mongo.IncomeMongo;
import com.francopaiz.financialManagementAPI.model.postgres.IncomePostgres;
import com.francopaiz.financialManagementAPI.model.postgres.UserPostgres; // Asegúrate de importar UserPostgres
import org.springframework.stereotype.Component;

/**
 * Clase utilitaria para realizar conversiones entre diferentes representaciones
 * de ingresos financieros, específicamente entre Income, IncomeMongo y IncomePostgres.
 */
@Component
public class IncomeCaster {

    /**
     * Convierte un objeto Income a un objeto IncomeMongo.
     *
     * @param income El objeto Income que se va a convertir.
     * @return Un objeto IncomeMongo que representa el ingreso.
     */
    public IncomeMongo incomeToIncomeMongo(Income income) {
        IncomeMongo incomeMongo = new IncomeMongo();
        incomeMongo.setId(income.getId());
        incomeMongo.setSource(income.getSource());
        incomeMongo.setAmount(income.getAmount());
        incomeMongo.setDate(income.getDate());
        incomeMongo.setUser(income.getUser());
        return incomeMongo;
    }

    /**
     * Convierte un objeto IncomeMongo a un objeto Income.
     *
     * @param incomeMongo El objeto IncomeMongo que se va a convertir.
     * @return Un objeto Income que representa el ingreso.
     */
    public Income incomeMongoToIncome(IncomeMongo incomeMongo) {
        Income income = new Income();
        income.setId(incomeMongo.getId());
        income.setSource(incomeMongo.getSource());
        income.setAmount(incomeMongo.getAmount());
        income.setDate(incomeMongo.getDate());
        income.setUser(incomeMongo.getUser());
        return income;
    }

    /**
     * Convierte un objeto Income a un objeto IncomePostgres.
     *
     * @param income El objeto Income que se va a convertir.
     * @return Un objeto IncomePostgres que representa el ingreso.
     */
    public IncomePostgres incomeToIncomePostgres(Income income) {
        IncomePostgres incomePostgres = new IncomePostgres();
        incomePostgres.setId(Long.valueOf(income.getId())); // Asegúrate de manejar la conversión del ID correctamente
        incomePostgres.setSource(income.getSource());
        incomePostgres.setAmount(income.getAmount());
        incomePostgres.setDate(income.getDate());

        // Convertir User a UserPostgres
        if (income.getUser() != null) {
            UserCaster userCaster = new UserCaster();
            UserPostgres userPostgres = userCaster.userToUserPostgres(income.getUser());
            incomePostgres.setUser(userPostgres);
        }

        return incomePostgres;
    }

    /**
     * Convierte un objeto IncomePostgres a un objeto Income.
     *
     * @param incomePostgres El objeto IncomePostgres que se va a convertir.
     * @return Un objeto Income que representa el ingreso.
     */
    public Income incomePostgresToIncome(IncomePostgres incomePostgres) {
        Income income = new Income();
        income.setId(String.valueOf(incomePostgres.getId())); // Asegúrate de manejar la conversión del ID correctamente
        income.setSource(incomePostgres.getSource());
        income.setAmount(incomePostgres.getAmount());
        income.setDate(incomePostgres.getDate());

        // Convertir UserPostgres a User
        if (incomePostgres.getUser() != null) {
            UserCaster userCaster = new UserCaster();
            User user = userCaster.userPostgresToUser(incomePostgres.getUser());
            income.setUser(user);
        }

        return income;
    }

    /**
     * Convierte un objeto IncomeMongo a un objeto IncomePostgres.
     *
     * @param incomeMongo El objeto IncomeMongo que se va a convertir.
     * @return Un objeto IncomePostgres que representa el ingreso.
     */
    public IncomePostgres incomeMongoToIncomePostgres(IncomeMongo incomeMongo) {
        IncomePostgres incomePostgres = new IncomePostgres();
        incomePostgres.setId(Long.valueOf(incomeMongo.getId())); // Asegúrate de manejar la conversión del ID correctamente
        incomePostgres.setSource(incomeMongo.getSource());
        incomePostgres.setAmount(incomeMongo.getAmount());
        incomePostgres.setDate(incomeMongo.getDate());

        // Convertir User a UserPostgres
        if (incomeMongo.getUser() != null) {
            UserCaster userCaster = new UserCaster();
            UserPostgres userPostgres = userCaster.userToUserPostgres(incomeMongo.getUser());
            incomePostgres.setUser(userPostgres);
        }

        return incomePostgres;
    }

    /**
     * Convierte un objeto IncomePostgres a un objeto IncomeMongo.
     *
     * @param incomePostgres El objeto IncomePostgres que se va a convertir.
     * @return Un objeto IncomeMongo que representa el ingreso.
     */
    public IncomeMongo incomePostgresToIncomeMongo(IncomePostgres incomePostgres) {
        IncomeMongo incomeMongo = new IncomeMongo();
        incomeMongo.setId(String.valueOf(incomePostgres.getId())); // Asegúrate de manejar la conversión del ID correctamente
        incomeMongo.setSource(incomePostgres.getSource());
        incomeMongo.setAmount(incomePostgres.getAmount());
        incomeMongo.setDate(incomePostgres.getDate());

        // Convertir UserPostgres a User
        if (incomePostgres.getUser() != null) {
            UserCaster userCaster = new UserCaster();
            User user = userCaster.userPostgresToUser(incomePostgres.getUser());
            incomeMongo.setUser(user);
        }

        return incomeMongo;
    }
}
