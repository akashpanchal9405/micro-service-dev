
package com.inn.employee.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement

@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactory", basePackages = {
		"com.inn.employee.repository.SecondEmployeeRepository" }, transactionManagerRef = "secondTransactionManager")

@Configuration
public class OracleDataSource {

	@Autowired
	private Environment environment;

	@Primary
	@Bean("secondDatasource")
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("spring.oracle.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.oracle.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.oracle.datasource.password"));
		return dataSource;
	}

	@Primary
	@Bean(name = "secondEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.inn.employee.entity");

		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);

		Map<String, String> props = new HashMap<>();
		props.put("hibernate.show_sql", "true");
//		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		bean.setJpaPropertyMap(props);

		return bean;
	}

	@Primary
	@Bean(name = "secondTransactionManager")
	PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}

}
