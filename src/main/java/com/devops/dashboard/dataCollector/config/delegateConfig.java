package com.devops.dashboard.dataCollector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devops.dashboard.dataCollector.dataModels.implementation.testDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.ITestDM;

@Configuration
public class delegateConfig {
	
	@Bean
	public ITestDM testDMInstance() {
		return new testDM();
	}

}
