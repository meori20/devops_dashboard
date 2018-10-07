package com.devops.dashboard.dataCollector.mappers.impel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.devops.dashboard.dataCollector.dataModels.implementation.ProjectDM;
import com.devops.dashboard.dataCollector.dataModels.implementation.Git.GitDataDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IBuildDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapBuildToBuildsDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJobToIProjectDM;
import com.devops.dashboard.dataCollector.services.impel.GitService;
import com.devops.dashboard.dataCollector.services.interfaces.ISonarService;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.Job;

public class MapJobToIProjectDM implements IMapJobToIProjectDM{
	
	@Autowired
	private IMapBuildToBuildsDM mapBuildToBuildsDM;
	
	@Autowired
	private ISonarService sonarService;
	
	@Override
	public IProjectDM map(Job job) throws IOException {
		
		IProjectDM projectDM = new ProjectDM();
		
		
		//Optional - Performance issue.
		/*
		List<Build> builds = job.details().getAllBuilds();
		List<IBuildDM> mappedBuilds = new ArrayList();
		builds.forEach((b) -> {
			try {
				mappedBuilds.add(mapBuildToBuildsDM.map(b));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		projectDM.setBuildList(mappedBuilds);
		*/
		projectDM.setProjectName(job.getName());
		projectDM.setSonarQube(sonarService.getSonarQube(job.getName()));
		GitService git = new GitService();
		GitDataDM gitData = git.getTopGitData(job.getName());
		projectDM.setGitDataDM(gitData);
		
		return projectDM;
		
	}
	

}
