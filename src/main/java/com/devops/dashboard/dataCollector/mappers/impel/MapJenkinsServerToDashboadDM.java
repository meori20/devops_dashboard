package com.devops.dashboard.dataCollector.mappers.impel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.devops.dashboard.dataCollector.dataModels.implementation.DashBoardDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IDashBoardDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJenkinsServerToDashboadDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJobToIProjectDM;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

public class MapJenkinsServerToDashboadDM implements IMapJenkinsServerToDashboadDM {
	
	@Autowired
	private IMapJobToIProjectDM mapJobToIProjectDM;
	
	@Override
	public IDashBoardDM map(JenkinsServer serevrDetails) throws IOException {
		IDashBoardDM dashBoardDM = new DashBoardDM();
		Map<String, Job> allJobs = serevrDetails.getJobs();
		Map<String, IProjectDM> allProj = new HashMap<String, IProjectDM>();
		allJobs.forEach((jobName,job) -> {
			try {
				allProj.put(jobName, mapJobToIProjectDM.map(job));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		dashBoardDM.setProjectList(allProj);
		

		return dashBoardDM;
	}

}
