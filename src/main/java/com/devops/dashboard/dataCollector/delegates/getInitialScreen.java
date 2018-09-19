package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.NoConnectionPendingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.dataModels.implementation.DashBoardDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IDashBoardDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJenkinsServerToDashboadDM;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

@RestController
public class getInitialScreen {
	
	@Autowired
	private IMapJenkinsServerToDashboadDM mapJenkinsServerToDashboadDM;
	
	@RequestMapping(value = "/getInitialScreen", method = RequestMethod.GET)
	public @ResponseBody IDashBoardDM getDashboard() throws IOException {
		JenkinsServer jenkinsServer = null;
		try {
			 jenkinsServer = new JenkinsServer(new URI("http://ec2-52-36-106-204.us-west-2.compute.amazonaws.com:8080"),"meori20", "zqxwce321");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IDashBoardDM dashBoardDM = mapJenkinsServerToDashboadDM.map(jenkinsServer);
		
		return dashBoardDM;
	}
		
		

}
