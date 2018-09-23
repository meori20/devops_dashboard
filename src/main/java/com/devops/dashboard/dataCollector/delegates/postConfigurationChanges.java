package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.ConfigurationsDM;

@RestController
public class postConfigurationChanges {
	
	@RequestMapping(value = "/updateConfigurations", method= RequestMethod.POST , consumes= {"application/json"} , produces = {"application/json"})
	ConfigurationsDM updateConfigurations(@RequestBody ConfigurationsDM config, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Expose-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		try {
			Configurations.getConfigurations().updateConfigurations(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
		
	}
}
