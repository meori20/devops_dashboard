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

@RestController
public class getAbortBuild {
	
	@RequestMapping(value = "/getAbortBuild/{jobName}", method = RequestMethod.GET)
	public @ResponseBody String getAbortBuild(@PathVariable(value="jobName") String jobName, HttpServletResponse response) throws IOException {
		delegatesUtil.enableAccessControlForGetReq(response);
		JenkinsServer jenkinsServer = null;
		Configurations conf = Configurations.getConfigurations();
		try {
			 jenkinsServer = new JenkinsServer(new URI(conf.getJenkinsURL()),conf.getJenkinsUsername(), conf.getJenkinsPassword());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return jenkinsServer.getJob(jobName).getLastBuild().Stop(); 
		
	}

}
