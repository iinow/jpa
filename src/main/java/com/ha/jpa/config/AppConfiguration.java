package com.ha.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
@Setter
@Getter
public class AppConfiguration {
	private AppEmailConfiguration email;
	
	@Setter
	@Getter
	public static class AppEmailConfiguration {
		private AppEmailServerConfiguration naver;
		private AppEmailServerConfiguration gmail;
	}
	
	@Setter
	@Getter
	public static class AppEmailServerConfiguration {
		private String host;
		private int port;
	}
}
