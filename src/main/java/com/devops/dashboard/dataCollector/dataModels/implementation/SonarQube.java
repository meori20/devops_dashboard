package com.devops.dashboard.dataCollector.dataModels.implementation;

import com.devops.dashboard.dataCollector.dataModels.interfaces.ISonarQube;

public class SonarQube implements ISonarQube{
	
	private double m_CodeCoverage;
	private int m_CodeSmells;
	private String m_SonarRefURL;
	
	@Override
	public double getM_CodeCoverage() {
		return m_CodeCoverage;
	}
	
	@Override
	public void setM_CodeCoverage(double m_CodeCoverage) {
		this.m_CodeCoverage = m_CodeCoverage;
	}
	
	@Override
	public int getM_CodeSmells() {
		return m_CodeSmells;
	}
	
	@Override
	public void setM_CodeSmells(int m_CodeSmells) {
		this.m_CodeSmells = m_CodeSmells;
	}
	
	@Override
	public String getM_SonarRefURL() {
		return m_SonarRefURL;
	}
	
	@Override
	public void setM_SonarRefURL(String m_SonarRefURL) {
		this.m_SonarRefURL = m_SonarRefURL;
	}
	
	
	
}
