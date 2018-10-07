package com.devops.dashboard.dataCollector.dataModels.implementation;

import java.util.List;

public class DomainDM {
	
	private String domainName;
	private List<String> toDomainCommiters;
	private double domainCoverage;
	private int totalDomainCodeSmells;
	private int MicroserviceCount;
	
	public int getTotalDomainCodeSmells() {
		return totalDomainCodeSmells;
	}
	public void setTotalDomainCodeSmells(int totalDomainCodeSmells) {
		this.totalDomainCodeSmells = totalDomainCodeSmells;
	}
	public double getDomainCoverage() {
		return domainCoverage;
	}
	public void setDomainCoverage(double domainCoverage) {
		this.domainCoverage = domainCoverage;
	}
	public List<String> getToDomainCommiters() {
		return toDomainCommiters;
	}
	public void setToDomainCommiters(List<String> toDomainCommiters) {
		this.toDomainCommiters = toDomainCommiters;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public int getMicroserviceCount() {
		return MicroserviceCount;
	}
	public void setMicroserviceCount(int microserviceCount) {
		MicroserviceCount = microserviceCount;
	}

}
