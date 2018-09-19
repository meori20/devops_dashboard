package com.devops.dashboard.dataCollector.dataModels.implementation;

import com.devops.dashboard.dataCollector.dataModels.interfaces.IBuildDM;

public class BuildDM implements IBuildDM {

	private int buildNumber;
	private String buildStatus;
	
	
	@Override
	public int getBuildNumber() {
		return buildNumber;
	}

	@Override
	public void setBuildNumber(int i) {
		this.buildNumber = i;
		
	}
	
	@Override
	public String getBuildStatus() {
		return this.buildStatus;
	}


	@Override
	public void setBuildStatus(String string) {
		this.buildStatus = string;
		
	}

}
