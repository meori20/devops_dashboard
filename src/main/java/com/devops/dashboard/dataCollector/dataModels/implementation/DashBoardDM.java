package com.devops.dashboard.dataCollector.dataModels.implementation;

import java.util.Map;

import com.devops.dashboard.dataCollector.dataModels.interfaces.IDashBoardDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;

public class DashBoardDM implements IDashBoardDM {
	
	private Map<String, IProjectDM> projectList;
	
	@Override
	public Map<String, IProjectDM> getProjectList() {
		
		return projectList;
	}

	@Override
	public void setProjectList(Map<String ,IProjectDM> projMap) {
		this.projectList = projMap;
	}

}
