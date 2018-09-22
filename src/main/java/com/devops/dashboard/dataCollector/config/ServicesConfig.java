package com.devops.dashboard.dataCollector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devops.dashboard.dataCollector.mappers.impel.MapSonarResponsesToSonarDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapSonarResponsesToSonarDM;
import com.devops.dashboard.dataCollector.services.impel.SonarService;
import com.devops.dashboard.dataCollector.services.interfaces.ISonarService;

@Configuration
public class ServicesConfig {
	
	@Bean
	public ISonarService sonarService() {
		return new SonarService();
	}
	
	@Bean
	public IMapSonarResponsesToSonarDM mapSonarResponsesToSonarDM() {
		return new MapSonarResponsesToSonarDM();
	}
	
}
