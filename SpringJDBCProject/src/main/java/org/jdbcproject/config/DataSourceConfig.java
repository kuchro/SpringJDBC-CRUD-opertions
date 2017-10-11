package org.jdbcproject.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"org.jdbcproject"}, excludeFilters = {
		@Filter(type=FilterType.ANNOTATION,value=Configuration.class)
})
public class DataSourceConfig {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/jdbc");
		dataSource.setUsername("postgres");
		dataSource.setPassword("password");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate returnTemplate(DataSource getDataSource) {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());

		return template;
	}

}
