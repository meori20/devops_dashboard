package com.devops.dashboard.dataCollector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devops.dashboard.dataCollector.dataModels.implementation.testDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.ITestDM;
import com.devops.dashboard.dataCollector.mappers.impel.MapBuildToBuildsDM;
import com.devops.dashboard.dataCollector.mappers.impel.MapJenkinsServerToDashboadDM;
import com.devops.dashboard.dataCollector.mappers.impel.MapJobToIProjectDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapBuildToBuildsDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJenkinsServerToDashboadDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJobToIProjectDM;

@Configuration
public class delegateConfig {
	
	@Bean
	public ITestDM testDMInstance() {
		return new testDM();
	}
	
	@Bean
	public IMapBuildToBuildsDM mapBuildToBuildsDM() {
		return new MapBuildToBuildsDM();
	}
	
	@Bean
	public IMapJenkinsServerToDashboadDM mapJenkinsServerToDashboadDM() {
		return new MapJenkinsServerToDashboadDM();
	}
	
	@Bean
	public IMapJobToIProjectDM mapJobToIProjectDM() {
		return new MapJobToIProjectDM();
	}
	
	

}
