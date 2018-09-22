package com.devops.dashboard.dataCollector.dataModels.implementation.Configurations;

public class Configuration
{
    private JenkinsServer jenkinsServer;

    public JenkinsServer getJenkinsServer ()
    {
        return jenkinsServer;
    }

    public void setJenkinsServer (JenkinsServer jenkinsServer)
    {
        this.jenkinsServer = jenkinsServer;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [jenkinsServer = "+jenkinsServer+"]";
    }
}