package com.devops.dashboard.dataCollector.dataModels.implementation.Pipeline;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"links", "id", "name", "status", "startTimeMillis", "endTimeMillis", "durationMillis",
		"queueDurationMillis", "pauseDurationMillis" })
public class PipelineDM {

	
	@JsonIgnore
	private Links _links;
	@JsonProperty("id")
	private Links links;
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("status")
	private String status;
	@JsonProperty("startTimeMillis")
	private Long startTimeMillis;
	@JsonProperty("endTimeMillis")
	private Long endTimeMillis;
	@JsonProperty("durationMillis")
	private Long durationMillis;
	@JsonProperty("queueDurationMillis")
	private Long queueDurationMillis;
	@JsonProperty("pauseDurationMillis")
	private Long pauseDurationMillis;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("startTimeMillis")
	public Long getStartTimeMillis() {
		return startTimeMillis;
	}

	@JsonProperty("startTimeMillis")
	public void setStartTimeMillis(Long startTimeMillis) {
		this.startTimeMillis = startTimeMillis;
	}

	@JsonProperty("endTimeMillis")
	public Long getEndTimeMillis() {
		return endTimeMillis;
	}

	@JsonProperty("endTimeMillis")
	public void setEndTimeMillis(Long endTimeMillis) {
		this.endTimeMillis = endTimeMillis;
	}

	@JsonProperty("durationMillis")
	public Long getDurationMillis() {
		return durationMillis;
	}

	@JsonProperty("durationMillis")
	public void setDurationMillis(Long durationMillis) {
		this.durationMillis = durationMillis;
	}

	@JsonProperty("queueDurationMillis")
	public Long getQueueDurationMillis() {
		return queueDurationMillis;
	}

	@JsonProperty("queueDurationMillis")
	public void setQueueDurationMillis(Long queueDurationMillis) {
		this.queueDurationMillis = queueDurationMillis;
	}

	@JsonProperty("pauseDurationMillis")
	public Long getPauseDurationMillis() {
		return pauseDurationMillis;
	}

	@JsonProperty("pauseDurationMillis")
	public void setPauseDurationMillis(Long pauseDurationMillis) {
		this.pauseDurationMillis = pauseDurationMillis;
	}

}