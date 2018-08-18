package com.devops.dashboard.dataCollector.dataModels.interfaces;

import java.util.Map;

public interface IDashBoardDM {
	
	Map<String ,IProjectDM> getProjectList();
	void setProjectList(Map<String, IProjectDM> projMap);
	
	

}
