package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.devops.dashboard.dataCollector.Constants.ServicesConstants;
import com.devops.dashboard.dataCollector.config.Configurations;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class getJobPipelines {
	
	@RequestMapping(value = "/getJobPipelines/{jobName}", method = RequestMethod.GET)
	public @ResponseBody String getAllJobPipelines(@PathVariable(value="jobName")String jobName, HttpServletResponse response) {
		
		delegatesUtil.enableAccessControlForGetReq(response);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseString = null;
		try {
			responseString = restTemplate.getForEntity(Configurations.getConfigurations().getJenkinsURL()+ ServicesConstants.JENKINS_PIPELINE_API_PATH_JOB + jobName + ServicesConstants.JENKINS_PIPELINE_API_PATH_WFAPI,String.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if(responseString != null) {
			return responseString.getBody();
		}
		else {
			return ServicesConstants.NO_PIPELINE_ERROR + "\n" + jobName;
		}
	}

}
