package com.devops.dashboard.dataCollector.dataModels.implementation.Sonar;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"metric",
"value",
"bestValue"
})
public class Measure {

@JsonProperty("metric")
private String metric;
@JsonProperty("value")
private String value;
@JsonProperty("bestValue")
private Boolean bestValue;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("metric")
public String getMetric() {
return metric;
}

@JsonProperty("metric")
public void setMetric(String metric) {
this.metric = metric;
}

@JsonProperty("value")
public String getValue() {
return value;
}

@JsonProperty("value")
public void setValue(String value) {
this.value = value;
}

@JsonProperty("bestValue")
public Boolean getBestValue() {
return bestValue;
}

@JsonProperty("bestValue")
public void setBestValue(Boolean bestValue) {
this.bestValue = bestValue;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}