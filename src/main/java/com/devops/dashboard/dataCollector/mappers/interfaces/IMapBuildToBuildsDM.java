package com.devops.dashboard.dataCollector.mappers.interfaces;

import java.io.IOException;

import com.devops.dashboard.dataCollector.dataModels.interfaces.IBuildDM;
import com.offbytwo.jenkins.model.Build;

public interface IMapBuildToBuildsDM {

	IBuildDM map(Build build) throws IOException;

}
