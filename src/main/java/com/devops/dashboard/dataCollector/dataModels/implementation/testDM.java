package com.devops.dashboard.dataCollector.dataModels.implementation;

import com.devops.dashboard.dataCollector.dataModels.interfaces.ITestDM;

public class testDM implements ITestDM {
	
	@Override
	public void PrintHello() {
		System.out.println("Hello");
		
	}
}
