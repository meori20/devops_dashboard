package com.devops.dashboard.dataCollector.delegates;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.implementation.DomainsDM;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.Microservice;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IDashBoardDM;
import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;
import com.devops.dashboard.dataCollector.services.interfaces.IInitialScreenService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class getDomainScreen {
	
	@Autowired
	IInitialScreenService initialScreenService;
	
	@RequestMapping(value = "/getDomainScreen", method = RequestMethod.GET)
	public @ResponseBody DomainsDM getDomainDashboard(HttpServletResponse response) throws IOException {
		delegatesUtil.enableAccessControlForGetReq(response);
		IDashBoardDM dashboard = initialScreenService.getDashboard();
		
		DomainsDM domainDM = createDomainDMFromDashboardDM(dashboard);

		return domainDM;
	}

	private DomainsDM createDomainDMFromDashboardDM(IDashBoardDM dashboard) {
		
		DomainsDM domainsDm = new DomainsDM();
		
		for(Entry<String ,IProjectDM> microservice : dashboard.getProjectList().entrySet()) {
			String domainName = findDomainforMS(microservice.getValue().getProjectName());
			domainsDm.addMicroserviceToDomain(domainName, microservice.getValue());
			
		}
		
		return domainsDm;
	}

	private String findDomainforMS(String projectName) {
		String domainName = null;
		try {
			Microservice[] microservices = Configurations.getConfigurations().getMicroservices().getMicroservice();
			for(Microservice ms : microservices) {
				if(ms.getName().equals(projectName)) {
					domainName = ms.getDomain();
					break;
				}
			}
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		return domainName;
	}

}
