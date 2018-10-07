package com.devops.dashboard.dataCollector.dataModels.implementation;

import java.util.List;

import com.devops.dashboard.dataCollector.dataModels.implementation.Git.GitDataDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IBuildDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.ISonarQube;

public class ProjectDM implements IProjectDM {

	private List<IBuildDM> buildList;
	private String projectName;
	private ISonarQube sonarQube;
	private GitDataDM gitDataDM;
	
	@Override
	public List<IBuildDM> getBuildList() {
		return buildList;
	}

	@Override
	public void setBuildList(List<IBuildDM> buildList) {
		this.buildList = buildList;
	}

	@Override
	public String getProjectName() {
		return this.projectName;
	}

	@Override
	public void setProjectName(String projName) {
		this.projectName = projName;
	}
	
	@Override
	public ISonarQube getSonarQube() {
		return this.sonarQube;
	}
	
	@Override
	public void setSonarQube(ISonarQube sq) {
		this.sonarQube = sq;
	}

	@Override
	public GitDataDM getGitDataDM() {
		return gitDataDM;
	}

	@Override
	public void setGitDataDM(GitDataDM gitDataDM) {
		this.gitDataDM = gitDataDM;
	}
	
	


}
