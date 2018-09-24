package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;

import javax.security.auth.login.Configuration;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.ConfigurationsDM;

@RestController
public class postConfigurationChanges {
	@CrossOrigin(origins="*", allowedHeaders="content-type", exposedHeaders="content-type", allowCredentials="true")
	@RequestMapping(value = "/updateConfigurations", method= RequestMethod.POST , consumes= {"application/json"} , produces = {"application/json"})
	ConfigurationsDM updateConfigurations(@RequestBody ConfigurationsDM config, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Expose-Headers", "content-type");
		response.setHeader("Access-Control-Allow-Headers", "content-type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		ConfigurationsDM configToReturn = null;
		try {
			Configurations.getConfigurations().updateConfigurations(config);
			configToReturn = Configurations.getConfigurations().getConfigurationsToClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return configToReturn;
		
	}
}
