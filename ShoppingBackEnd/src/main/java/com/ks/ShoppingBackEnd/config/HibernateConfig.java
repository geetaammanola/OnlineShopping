package com.ks.ShoppingBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.spi.SessionFactoryBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.ks.ShoppingBackEnd.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//change as per choosen DBMS
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	
	//dataSource BEAN WILL BE AVaILABLE
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource= new BasicDataSource();
		
		//providing database connection information
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		
		return dataSource;
	}
	
	//sessionFactory BEAN WILL BE AVaILABLE
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		
		builder.addProperties(getHibernateProperties());
		
		builder.scanPackages("com.ks.ShoppingBackEnd.dto");
		return builder.buildSessionFactory();
		
 
	
	
	
	
	}
	//all the hibernate properties will be returned in this method 

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	
	// Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory ){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
