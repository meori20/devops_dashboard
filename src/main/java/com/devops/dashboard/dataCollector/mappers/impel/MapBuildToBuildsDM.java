package com.devops.dashboard.dataCollector.mappers.impel;

import java.io.IOException;

import com.devops.dashboard.dataCollector.dataModels.implementation.BuildDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IBuildDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapBuildToBuildsDM;
import com.offbytwo.jenkins.model.Build;

public class MapBuildToBuildsDM implements IMapBuildToBuildsDM {
	
	@Override
	public IBuildDM map(Build build) throws IOException {
		IBuildDM res = new BuildDM();
		res.setBuildNumber(build.getNumber());
		res.setBuildStatus(build.details().getResult().toString());
		return res;
		
	}

}
