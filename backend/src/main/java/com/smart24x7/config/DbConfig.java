package com.smart24x7.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@AllArgsConstructor
public class DbConfig {

	private ReadDbConfig readDbConfig;

	Environment env;

	@Bean
	@Profile("stg")
	public DataSource getStgDataSource() {
		log.info("STG - ENV Database initialing...");
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(readDbConfig.getUrl());
		dataSourceBuilder.username(readDbConfig.getUsername());
		dataSourceBuilder.password(readDbConfig.getPassword());
		dataSourceBuilder.driverClassName(readDbConfig.getDriverClassName());
		return dataSourceBuilder.build();
	}

	@Bean
	@Profile("prod")
	public DataSource getProdDataSource() {
		log.info("PROD - ENV Database initialing...");
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(readDbConfig.getUrl());
		dataSourceBuilder.username(readDbConfig.getUsername());
		dataSourceBuilder.password(readDbConfig.getPassword());
		dataSourceBuilder.driverClassName(readDbConfig.getDriverClassName());
		return dataSourceBuilder.build();
	}

	public Connection getDbConnection() throws SQLException {
		String profile = env.getProperty("spring.profiles.active");
		if ("stg".equals(profile))
			return getStgDataSource().getConnection();
		else if ("prod".equals(profile))
			return getProdDataSource().getConnection();
		return null;
	}
}
