package com.example.demo;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.demo.routing.MyRoutingDataSource;

@SpringBootApplication
/**
 * Vì Springboot auto config cho JPA trong trường hợp có 1 database để config
 * (hay 1 FactorySession) Trường hợp nhiều database thì ta phải config bằng tay
 * => vì thế phải bỏ tính năng auto config
 * 
 * https://o7planning.org/en/10869/using-multiple-datasources-with-spring-boot-and-routingdatasource
 */

@EnableAutoConfiguration(exclude = { //
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class })

public class SpringbootJDBCRoutingDatasourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJDBCRoutingDatasourcesApplication.class, args);
	}


}
