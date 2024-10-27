/*
package com.francopaiz.financialManagementAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

@Configuration
public class HibernateConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.francopaiz.financialManagementAPI.model.postgres");
        // Configura otras propiedades del sessionFactory según sea necesario
        return sessionFactory;
    }
}
*/
