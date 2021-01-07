package com.vwits.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public EmployeeDAOImpl getEmployee() {
		return new EmployeeDAOImpl();
	}
	
	
}
