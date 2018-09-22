package com.devops.dashboard.dataCollector.dataModels.interfaces;

import java.util.List;

public interface IProjectDM {
	
	List<IBuildDM> getBuildList();	
	String getProjectName();
	
	void setBuildList(List<IBuildDM> buildList);
	void setProjectName(String projName);
	ISonarQube getSonarQube();
	void setSonarQube(ISonarQube sq);

}
