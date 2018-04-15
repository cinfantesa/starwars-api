//package com.starwars.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaAuditing
//@EnableJpaRepositories(basePackages = "com.starwars.schema2",
//        entityManagerFactoryRef = "schema2EntityManagerFactory",
//        transactionManagerRef = "schema2TransactionManager")
//public class Schema2Configuration {
//
//    @Bean
//    @ConfigurationProperties(prefix = "schema2.datasource")
//    public DataSource schema2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean schema2EntityManagerFactory(
//            final EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(schema2DataSource())
//                .packages("com.starwars.schema2")
//                .persistenceUnit("schema2PersistenceUnit")
//                .build();
//    }
//
//    @Bean
//    public JpaTransactionManager schema2TransactionManager(
//            @Qualifier("schema2EntityManagerFactory") final EntityManagerFactory factory) {
//        return new JpaTransactionManager(factory);
//    }
//}
