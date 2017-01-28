package com.starwars.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.starwars.schema1",
        entityManagerFactoryRef = "schema1EntityManagerFactory",
        transactionManagerRef = "schema1TransactionManager")
public class Schema1Configuration {

    @Bean
    @ConfigurationProperties(prefix = "schema1.datasource")
    @Primary
    public DataSource schema1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean schema1EntityManagerFactory(
            final EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(schema1DataSource())
                .packages("com.starwars.schema1")
                .persistenceUnit("schema1PersistenceUnit")
                .build();
    }

    @Bean
    @Primary
    public JpaTransactionManager schema1TransactionManager
            (@Qualifier("schema1EntityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
