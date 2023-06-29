package com.dz.app;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dz.app.employee.dao.EmployeeDao;
import com.dz.app.employee.dao.Impl.EmployeeDaoImpl;

@Configuration
public class JavaBaseConfig {

	@Bean("ds")
	public DataSource getDataSource(){
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dz");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean("employeeDao")
	public EmployeeDao getEmployeeDao(){
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employeeDaoImpl.setTemplate(getJdbcTemplate());
		return employeeDaoImpl;
	}
}
