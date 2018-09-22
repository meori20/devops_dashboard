package com.devops.dashboard.dataCollector.dataModels.implementation.Configurations;

public class Microservice
{
    private String sonarKey;

    private String jiraFilter;

    private String name;

    public String getSonarKey ()
    {
        return sonarKey;
    }

    public void setSonarKey (String sonarKey)
    {
        this.sonarKey = sonarKey;
    }

    public String getJiraFilter ()
    {
        return jiraFilter;
    }

    public void setJiraFilter (String jiraFilter)
    {
        this.jiraFilter = jiraFilter;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "[sonarKey = "+sonarKey+", jiraFilter = "+jiraFilter+", name = "+name+"]";
    }
}