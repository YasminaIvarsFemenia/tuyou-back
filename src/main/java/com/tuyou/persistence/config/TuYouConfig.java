package com.tuyou.persistence.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate-cfg.properties")
@ComponentScan("com.tuyou.persistence.*")
@EnableJpaRepositories(basePackages = {"com.tuyou.persistence.repository"}, entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class TuYouConfig {

	@Resource
	private Environment env;

	private static final String PROPERTY_JPA_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_JPA_SHOW_SQL = "hibernate.show_sql";

	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));

		return dataSource;
	}

	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(getDataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("com.tuyou.persistence.*");

		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_JPA_DIALECT, env.getRequiredProperty(PROPERTY_JPA_DIALECT));
		properties.put(PROPERTY_JPA_SHOW_SQL, env.getRequiredProperty(PROPERTY_JPA_SHOW_SQL));
		//properties.put("hibernate.default_schema", env.getRequiredProperty("spring.datasource.schema"));
		return properties;
	}

	@Bean(name = "transactionManager")
	public JpaTransactionManager getTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
		return transactionManager;
	}

}