package com.devops.dashboard.dataCollector.dataModels.implementation.Sonar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"key",
"name",
"qualifier",
"measures"
})
public class Component {

@JsonProperty("id")
private String id;
@JsonProperty("key")
private String key;
@JsonProperty("name")
private String name;
@JsonProperty("qualifier")
private String qualifier;
@JsonProperty("measures")
private List<Measure> measures = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("key")
public String getKey() {
return key;
}

@JsonProperty("key")
public void setKey(String key) {
this.key = key;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("qualifier")
public String getQualifier() {
return qualifier;
}

@JsonProperty("qualifier")
public void setQualifier(String qualifier) {
this.qualifier = qualifier;
}

@JsonProperty("measures")
public List<Measure> getMeasures() {
return measures;
}

@JsonProperty("measures")
public void setMeasures(List<Measure> measures) {
this.measures = measures;
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