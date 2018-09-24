package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.NoConnectionPendingException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.devops.dashboard.dataCollector.dataModels.interfaces.ITestDM;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

@Controller
public class getLastBuild {
	
	@Autowired
	public ITestDM testDM;
	
	
	@RequestMapping(value = "/getLastBuild/{jobName}", method = RequestMethod.GET)
	public @ResponseBody String testMethod(@PathVariable(value="jobName") String jobName, HttpServletResponse response) throws IOException {
		delegatesUtil.enableAccessControlForGetReq(response);
		
		testDM.PrintHello();
		JenkinsServer jenkinsServer = null;
		try {
			 jenkinsServer = new JenkinsServer(new URI("http://ec2-52-36-106-204.us-west-2.compute.amazonaws.com:8080"),"meori20", "zqxwce321");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Job > jobs = jenkinsServer.getJobs();
		if(!jobs.containsKey(jobName)) {
			throw new NoConnectionPendingException();
		}
		JobWithDetails dasbhoradJob = jobs.get(jobName).details();
		BuildWithDetails lastBuild = dasbhoradJob.getLastBuild().details();
		
		
		if(lastBuild != null) {
			if(lastBuild.getResult() != null) {
				return "Build number " + lastBuild.getNumber() + " result is " + lastBuild.getResult().name();
			}
			else {
				return "Build number " + lastBuild.getNumber();
			}
		}
		return "";
		
		
		
		
	}
	

}
