package com.devops.dashboard.dataCollector.mappers.interfaces;

import org.springframework.http.ResponseEntity;

import com.devops.dashboard.dataCollector.dataModels.implementation.Sonar.SonarResponse;
import com.devops.dashboard.dataCollector.dataModels.interfaces.ISonarQube;

public interface IMapSonarResponsesToSonarDM {

	ISonarQube map(ResponseEntity<SonarResponse> sonarResponse, String sonarKey);

}