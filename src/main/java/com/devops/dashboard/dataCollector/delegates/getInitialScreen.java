package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IDashBoardDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapJenkinsServerToDashboadDM;
import com.devops.dashboard.dataCollector.services.impel.GitService;
import com.devops.dashboard.dataCollector.services.interfaces.IInitialScreenService;
import com.offbytwo.jenkins.JenkinsServer;

@RestController
public class getInitialScreen {
	
	@Autowired
	IInitialScreenService initialScreenService;
	
	@RequestMapping(value = "/getInitialScreen", method = RequestMethod.GET)
	public @ResponseBody IDashBoardDM getDashboard(HttpServletResponse response) throws IOException {
		delegatesUtil.enableAccessControlForGetReq(response);
		
		return initialScreenService.getDashboard();
	}
		
		

}
