package com.devops.dashboard.dataCollector.services.interfaces;

public interface ILoginService {
	public boolean login(String username, String password);
	public void register(String username, String password);
	public boolean logout();

}
