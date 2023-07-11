package com.smart24x7.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class ReadDbConfig {

	private String url;
	private String username;
	private String password;
	private String driverClassName;

}
