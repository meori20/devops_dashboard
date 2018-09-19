package com.devops.dashboard.dataCollector.mappers.interfaces;

import java.io.IOException;

import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;
import com.offbytwo.jenkins.model.Job;

public interface IMapJobToIProjectDM {

	IProjectDM map(Job job) throws IOException;

}
