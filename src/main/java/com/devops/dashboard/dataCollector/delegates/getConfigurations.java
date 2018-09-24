package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.ConfigurationsDM;

@RestController
public class getConfigurations {
	
	@RequestMapping(value = "/getConfigurations", method = RequestMethod.GET)
	public @ResponseBody ConfigurationsDM getConfigurations(HttpServletResponse response) throws IOException {
		delegatesUtil.enableAccessControlForGetReq(response);
		
		return Configurations.getConfigurations().getConfigurationsToClient();
		
	}
	

}
