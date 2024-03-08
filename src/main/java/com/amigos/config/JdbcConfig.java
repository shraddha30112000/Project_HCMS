package com.amigos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.EmployeesDAOImpl;

import jakarta.activation.DataSource;

public class JdbcConfig {
	@Bean(name = {"dataSourceObj"})
	public DataSource getDataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/hcms");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("Shraddha@3983");
		return (DataSource) driverManagerDataSource;
	}
	
	@Bean(name = {"jdbcTemplate"})
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource((javax.sql.DataSource) getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name = {"employeesDAO"})
	public EmployeesDAO getEmployeesDAO()
	{
		EmployeesDAOImpl employeesDAO = new EmployeesDAOImpl();
		employeesDAO.setJdbcTemplate(getJdbcTemplate());
		return employeesDAO;
	}
}