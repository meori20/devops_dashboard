package com.devops.dashboard.dataCollector.dataModels.implementation.Configurations;

public class JenkinsServer
{
    private String jenkinsUrl;

    private String userName;

    private Microservices microservices;

    private String password;
    
    public String getJenkinsUrl ()
    {
        return jenkinsUrl;
    }

    public void setJenkinsUrl (String jenkinsUrl)
    {
        this.jenkinsUrl = jenkinsUrl;
    }

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public Microservices getMicroservices ()
    {
        return microservices;
    }

    public void setMicroservices (Microservices microservices)
    {
        this.microservices = microservices;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "[jenkinsUrl = "+jenkinsUrl+", userName = "+userName+", microservices = "+microservices+", password = "+password+"]";
    }
}