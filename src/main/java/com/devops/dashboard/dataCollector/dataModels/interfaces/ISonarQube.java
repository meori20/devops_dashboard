package com.devops.dashboard.dataCollector.dataModels.interfaces;

public interface ISonarQube {

	double getM_CodeCoverage();

	void setM_CodeCoverage(double m_CodeCoverage);

	int getM_CodeSmells();

	void setM_CodeSmells(int m_CodeSmells);

	String getM_SonarRefURL();

	void setM_SonarRefURL(String m_SonarRefURL);

}
