package com.devops.dashboard.dataCollector.mappers.interfaces;

import java.io.IOException;

import com.devops.dashboard.dataCollector.dataModels.interfaces.IDashBoardDM;
import com.offbytwo.jenkins.JenkinsServer;

public interface IMapJenkinsServerToDashboadDM {
	
	public IDashBoardDM map(JenkinsServer serevrDetails) throws IOException;

}
