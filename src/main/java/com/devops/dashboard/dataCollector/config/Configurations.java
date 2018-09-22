package com.devops.dashboard.dataCollector.config;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.ConfigurationsDM;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.Microservices;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Configurations {

	private static Configurations conf = null;
	private ConfigurationsDM confDM;

	private Configurations() throws JsonParseException, JsonMappingException, IOException {
		File f = new File("src\\main\\java\\com\\devops\\dashboard\\dataCollector\\config\\configurations.json");
		if (!f.exists()) {
		    throw new FileNotFoundException("Failed to find file: " + 
		        f.getAbsolutePath());
		}
		ObjectMapper mapper = new ObjectMapper();
		confDM = mapper.readValue(f, ConfigurationsDM.class);
	}

	public static Configurations getConfigurations() throws JsonParseException, JsonMappingException, IOException {
		if (conf == null) {
			conf = new Configurations();
		}

		return conf;

	}

	public String getJenkinsURL() {
		if(confDM != null)
			return confDM.getConfiguration().getJenkinsServer().getJenkinsUrl();
		return null;
	}
	
	public String getJenkinsUsername() {
		if(confDM != null)
			return confDM.getConfiguration().getJenkinsServer().getUserName();
		return null;
	}
	
	public String getJenkinsPassword() {
		if(confDM != null)
			return confDM.getConfiguration().getJenkinsServer().getPassword();
		return null;
	}
	
	public Microservices getMicroservices() {
		if(confDM != null)
			return confDM.getConfiguration().getJenkinsServer().getMicroservices();
		return null;
	}

}
