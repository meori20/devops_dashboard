package com.devops.dashboard.dataCollector.dataModels.implementation.Configurations;

public class Microservices
{
    private Microservice[] microservice;

    public Microservice[] getMicroservice ()
    {
        return microservice;
    }

    public void setMicroservice (Microservice[] microservice)
    {
        this.microservice = microservice;
    }

    @Override
    public String toString()
    {
        return "[microservice = "+microservice+"]";
    }
}
