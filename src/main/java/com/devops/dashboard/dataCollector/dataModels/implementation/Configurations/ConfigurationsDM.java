package com.devops.dashboard.dataCollector.dataModels.implementation.Configurations;

public class ConfigurationsDM
{
    private Configuration configuration;

    public Configuration getConfiguration ()
    {
        return configuration;
    }

    public void setConfiguration (Configuration configuration)
    {
        this.configuration = configuration;
    }

    @Override
    public String toString()
    {
        return "[configuration = "+configuration+"]";
    }
}