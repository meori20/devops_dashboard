package com.devops.dashboard.dataCollector.mappers.impel;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.devops.dashboard.dataCollector.dataModels.implementation.SonarQube;
import com.devops.dashboard.dataCollector.dataModels.implementation.Sonar.Measure;
import com.devops.dashboard.dataCollector.dataModels.implementation.Sonar.SonarResponse;
import com.devops.dashboard.dataCollector.dataModels.interfaces.ISonarQube;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapSonarResponsesToSonarDM;

public class MapSonarResponsesToSonarDM implements IMapSonarResponsesToSonarDM {
	
	@Override
	public ISonarQube map(ResponseEntity<SonarResponse> sonarResponse, String sonarKey) {
		
		ISonarQube sonarQube = new SonarQube();
		
		SonarResponse sonarRes = sonarResponse.getBody();
		List<Measure> measureList = sonarRes.getComponent().getMeasures();
		for(Measure m : measureList) {
			if(m.getMetric().equals("coverage")) {
				sonarQube.setM_CodeCoverage(Double.parseDouble(m.getValue()));
			}
			else if(m.getMetric().equals("code_smells")) {
				sonarQube.setM_CodeSmells(Integer.parseInt(m.getValue()));
			}
		}
		sonarQube.setM_SonarRefURL("https://sonarcloud.io/dashboard?id="+ sonarKey);
		
		
		return sonarQube;
		
	}
}
