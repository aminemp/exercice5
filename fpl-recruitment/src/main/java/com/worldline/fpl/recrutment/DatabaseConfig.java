//package com.worldline.fpl.recrutment;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class DatabaseConfig {
//
//  /**
//   * DataSource definition for database connection. Settings are read from
//   * the application.properties file (using the env object).
//   */
//  @Bean
//  public DataSource dataSource() {
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("org.hibernate.dialect.HSQLDialect");
//    dataSource.setUrl("jdbc:hsqldb:mem:testdb");
//    dataSource.setUsername("sa");
//    dataSource.setPassword("");
//    return dataSource;
//  }
//
//  /**
//   * Declare the JPA entity manager factory.
//   */
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//    LocalContainerEntityManagerFactoryBean entityManagerFactory =
//        new LocalContainerEntityManagerFactoryBean();
//    
//    entityManagerFactory.setDataSource(dataSource);
//    
//    // Classpath scanning of @Component, @Service, etc annotated class
//    entityManagerFactory.setPackagesToScan(
//        "com.worldline.fpl.recruitment.entity");
//    
//    // Vendor adapter
//    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//    
//    // Hibernate properties
//    Properties additionalProperties = new Properties();
//    additionalProperties.put(
//        "hibernate.dialect", 
//        "org.hibernate.dialect.HSQLDialect");
//    additionalProperties.put(
//        "hibernate.show_sql",true);
//    additionalProperties.put(
//        "hibernate.hbm2ddl.auto", 
//        "create");
//    entityManagerFactory.setJpaProperties(additionalProperties);
//    
//    return entityManagerFactory;
//  }
//
//  /**
//   * Declare the transaction manager.
//   */
//  @Bean
//  public JpaTransactionManager transactionManager() {
//    JpaTransactionManager transactionManager = 
//        new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(
//        entityManagerFactory.getObject());
//    return transactionManager;
//  }
//  
//  /**
//   * PersistenceExceptionTranslationPostProcessor is a bean post processor
//   * which adds an advisor to any bean annotated with Repository so that any
//   * platform-specific exceptions are caught and then rethrown as one
//   * Spring's unchecked data access exceptions (i.e. a subclass of 
//   * DataAccessException).
//   */
//  @Bean
//  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//    return new PersistenceExceptionTranslationPostProcessor();
//  }
//
//  // Private fields
//  
//  @Autowired
//  private Environment env;
//
//  @Autowired
//  private DataSource dataSource;
//
//  @Autowired
//  private LocalContainerEntityManagerFactoryBean entityManagerFactory;
//
//}