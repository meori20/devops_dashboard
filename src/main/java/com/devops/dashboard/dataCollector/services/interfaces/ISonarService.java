package com.devops.dashboard.dataCollector.services.interfaces;

import java.io.IOException;

import com.devops.dashboard.dataCollector.dataModels.interfaces.ISonarQube;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ISonarService {

	ISonarQube getSonarQube(String jobName) throws JsonParseException, JsonMappingException, IOException;

}