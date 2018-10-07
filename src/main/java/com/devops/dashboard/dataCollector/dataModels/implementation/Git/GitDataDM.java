package com.devops.dashboard.dataCollector.dataModels.implementation.Git;

import java.util.List;

public class GitDataDM {
	
	private List<String> topCommiters;
	
	private String lastCommitString;

	public List<String> getTopCommiters() {
		return topCommiters;
	}

	public void setTopCommiters(List<String> topCommiters) {
		this.topCommiters = topCommiters;
	}

	public String getLastCommitString() {
		return lastCommitString;
	}

	public void setLastCommitString(String lastCommitString) {
		this.lastCommitString = lastCommitString;
	}

}
