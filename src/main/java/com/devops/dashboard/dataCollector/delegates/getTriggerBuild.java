package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.QueueReference;

@RestController
public class getTriggerBuild {
	
	
	@RequestMapping(value = "/getTriggerBuild/{jobName}", method = RequestMethod.GET)
	public @ResponseBody QueueReference getTriggerBuild(@PathVariable(value="jobName") String jobName, HttpServletResponse response) throws IOException {
		delegatesUtil.enableAccessControlForGetReq(response);
		JenkinsServer jenkinsServer = null;
		Configurations conf = Configurations.getConfigurations();
		try {
			 jenkinsServer = new JenkinsServer(new URI(conf.getJenkinsURL()),conf.getJenkinsUsername(), conf.getJenkinsPassword());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jenkinsServer.getJob(jobName).build(); 
		
	}
	
}
