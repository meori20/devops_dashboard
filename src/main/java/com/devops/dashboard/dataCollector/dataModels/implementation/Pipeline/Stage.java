package com.devops.dashboard.dataCollector.dataModels.implementation.Pipeline;

public class Stage {

	private Links_ links;
	private String id;
	private String name;
	private String execNode;
	private String status;
	private Long startTimeMillis;
	private Long durationMillis;
	private Long pauseDurationMillis;
	private Error error;

	public Links_ getLinks() {
		return links;
	}

	public void setLinks(Links_ links) {
		this.links = links;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExecNode() {
		return execNode;
	}

	public void setExecNode(String execNode) {
		this.execNode = execNode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getStartTimeMillis() {
		return startTimeMillis;
	}

	public void setStartTimeMillis(Long startTimeMillis) {
		this.startTimeMillis = startTimeMillis;
	}

	public Long getDurationMillis() {
		return durationMillis;
	}

	public void setDurationMillis(Long durationMillis) {
		this.durationMillis = durationMillis;
	}

	public Long getPauseDurationMillis() {
		return pauseDurationMillis;
	}

	public void setPauseDurationMillis(Long pauseDurationMillis) {
		this.pauseDurationMillis = pauseDurationMillis;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}