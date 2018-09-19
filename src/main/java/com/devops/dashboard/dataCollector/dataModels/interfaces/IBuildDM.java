package com.devops.dashboard.dataCollector.dataModels.interfaces;

public interface IBuildDM {
	
	int getBuildNumber();
	
	String getBuildStatus();

	void setBuildNumber(int i);

	void setBuildStatus(String string);
	

}
