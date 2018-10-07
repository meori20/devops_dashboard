package com.devops.dashboard.dataCollector.services.impel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IDashBoardDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJenkinsServerToDashboadDM;
import com.devops.dashboard.dataCollector.services.interfaces.IInitialScreenService;
import com.offbytwo.jenkins.JenkinsServer;

public class InitialScreenService implements IInitialScreenService{
	
	@Autowired
	private IMapJenkinsServerToDashboadDM mapJenkinsServerToDashboadDM;
	
	@Override
	public IDashBoardDM getDashboard() {
		
		JenkinsServer jenkinsServer = null;
		IDashBoardDM dashBoardDM = null;
		
		try {
			 Configurations conf = Configurations.getConfigurations();
			 jenkinsServer = new JenkinsServer(new URI(conf.getJenkinsURL()),conf.getJenkinsUsername(), conf.getJenkinsPassword());
			 dashBoardDM = mapJenkinsServerToDashboadDM.map(jenkinsServer);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		 
		
		return dashBoardDM;
		
	}

}
