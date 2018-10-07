package com.devops.dashboard.dataCollector.dataModels.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.devops.dashboard.dataCollector.dataModels.interfaces.IProjectDM;

public class DomainsDM {

	public DomainsDM() {
		domains = new HashMap<>();
		setDomainsDataList(new ArrayList<>());
	}

	private List<DomainDM> domainsDataList;

	private HashMap<String, List<IProjectDM>> domains;

	public HashMap<String, List<IProjectDM>> getDomains() {
		return domains;
	}

	public void setDomains(HashMap<String, List<IProjectDM>> domains) {
		this.domains = domains;
	}
	

	public void addMicroserviceToDomain(String domainName, IProjectDM microservice) {

		if (domainName == null || domainName.isEmpty()) {
			domainName = "noDomain";
		}
		if (!domains.containsKey(domainName)) {
			List<IProjectDM> domainMicroservicesList = new ArrayList<>();
			domainMicroservicesList.add(microservice);
			domains.put(domainName, domainMicroservicesList);
			DomainDM newDomain = createNewDomain(domainName, microservice);
			getDomainsDataList().add(newDomain);

		} else {
			List<IProjectDM> domainMicroservicesList = domains.get(domainName);
			domainMicroservicesList.add(microservice);
			domains.put(domainName, domainMicroservicesList);
			addMSDataToDomain(microservice, domainName);
		}

	}

	private void addMSDataToDomain(IProjectDM microservice, String domainName) {
		for (DomainDM d : getDomainsDataList()) {
			if (d.getDomainName().equals(domainName)) {
				d.setMicroserviceCount(d.getMicroserviceCount() + 1);
				d.setDomainCoverage((d.getDomainCoverage() + microservice.getSonarQube().getM_CodeCoverage())
						/ d.getMicroserviceCount());
				d.setTotalDomainCodeSmells(
						d.getTotalDomainCodeSmells() + microservice.getSonarQube().getM_CodeSmells());
				if (microservice.getGitDataDM().getLastCommitString() != null) {
					d.getToDomainCommiters().addAll(microservice.getGitDataDM().getTopCommiters());
				}
			}
		}

	}

	private DomainDM createNewDomain(String domainName, IProjectDM microservice) {
		DomainDM newDomain = new DomainDM();
		newDomain.setDomainName(domainName);
		newDomain.setMicroserviceCount(1);
		newDomain.setTotalDomainCodeSmells(microservice.getSonarQube().getM_CodeSmells());
		newDomain.setDomainCoverage(microservice.getSonarQube().getM_CodeCoverage());
		if (microservice.getGitDataDM().getTopCommiters() != null) {
			newDomain.setToDomainCommiters(microservice.getGitDataDM().getTopCommiters());
		} else {
			newDomain.setToDomainCommiters(new ArrayList<String>());
		}

		return newDomain;
	}

	public List<DomainDM> getDomainsDataList() {
		return domainsDataList;
	}

	public void setDomainsDataList(List<DomainDM> domainsDataList) {
		this.domainsDataList = domainsDataList;
	}

}
