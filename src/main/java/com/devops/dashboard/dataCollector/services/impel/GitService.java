package com.devops.dashboard.dataCollector.services.impel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.devops.dashboard.dataCollector.config.Configurations;
import com.devops.dashboard.dataCollector.dataModels.implementation.Configurations.Microservice;
import com.devops.dashboard.dataCollector.dataModels.implementation.Git.GitDM;
import com.devops.dashboard.dataCollector.dataModels.implementation.Git.GitDataDM;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class GitService {

	
	
	
	public GitDataDM getTopGitData(String microserviceName) {

		GitDataDM gitData = new GitDataDM();
		Microservice[] microservicesList = null;
		try {
			microservicesList = Configurations.getConfigurations().getMicroservices().getMicroservice();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String gitKey = null;
		GitDM gitDM[] = null;
		for (Microservice m : microservicesList) {
			if (m.getName().equals(microserviceName)) {
				gitKey = m.getGitRepoApi();
			}
		}

		if (gitKey != null && !gitKey.isEmpty()) {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<GitDM[]> gitDMResponse = restTemplate.getForEntity(gitKey + "/commits", GitDM[].class);
			if (gitDMResponse != null) {
				gitDM = gitDMResponse.getBody();
				gitData.setLastCommitString(gitDM[0].getUrl());
			}
		}else {
			return gitData;
		}

		gitData.setTopCommiters(getTopCommiters(gitDM));
		
		return gitData;
	}

	private List<String> getTopCommiters(GitDM[] gitDMList) {
		HashMap<String, Integer> commitersMap = new HashMap<String, Integer>();
		List<String> commitersLists = new ArrayList<>();
		for (GitDM git : gitDMList) {
			if (git.getAuthor() != null) {
				String authorName = git.getAuthor().getLogin();
				if (commitersMap.containsKey(authorName)) {
					commitersMap.put(authorName, commitersMap.get(authorName) + 1);
				} else {
					commitersMap.put(authorName, 1);
				}
			}
		}
		List<Integer> commitersListsValues = new ArrayList<>(commitersMap.values());
		Collections.sort(commitersListsValues);

		for (Integer numOfApperance : commitersListsValues) {
			for (Entry<String, Integer> entry : commitersMap.entrySet()) {
				if (entry.getValue() == numOfApperance) {
					commitersLists.add(entry.getKey());
				}
			}
		}
		Collections.reverse(commitersLists);

		return commitersLists;
	}
}
