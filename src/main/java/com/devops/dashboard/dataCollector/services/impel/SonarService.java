package com.devops.dashboard.dataCollector.services.impel;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.implementation.SonarQube;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.Microservice;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.Microservices;
import com.devops.dashboard.dataCollector.dataModels.implementation.Sonar.SonarResponse;
import com.devops.dashboard.dataCollector.dataModels.interfaces.ISonarQube;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapSonarResponsesToSonarDM;
import com.devops.dashboard.dataCollector.services.interfaces.ISonarService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class SonarService implements ISonarService {
	
	@Autowired
	IMapSonarResponsesToSonarDM mapSonarResponsesToSonarDM;
	
	@Override
	public ISonarQube getSonarQube(String jobName) throws JsonParseException, JsonMappingException, IOException{
		String sonarKey = getSonarKey(jobName);
		
		if(sonarKey != null && !sonarKey.isEmpty()) {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<SonarResponse> SonarResponse = restTemplate.getForEntity("https://sonarcloud.io/api/measures/component?metricKeys=code_smells,coverage&component="+ sonarKey,SonarResponse.class);
		
			return mapSonarResponsesToSonarDM.map(SonarResponse,sonarKey);
		}
		return new SonarQube();
	}

	private String getSonarKey(String jobName) throws JsonParseException, JsonMappingException, IOException {
		Configurations conf = Configurations.getConfigurations();
		Microservices microservices = conf.getMicroservices();
		
		for(Microservice m : microservices.getMicroservice()) {
			if(m.getName().equals(jobName)) {
				return m.getSonarKey();
			}
		}
		return null;
	}

}
