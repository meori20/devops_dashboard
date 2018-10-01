package com.devops.dashboard.dataCollector.services.impel.sqlLogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.devops.dashboard.dataCollector.services.interfaces.ILoginService;
import com.devops.dashboard.dataCollector.services.interfaces.IUserDAO;

public class SqlLogin implements ILoginService{
	
	@Autowired
	private IUserDAO userDao;
	
	@Override
	public boolean login(String username, String password) {
		List<UserDM> user = userDao.getUser(username,password);
		if(user.size() > 0)
			return true;
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void register(String username, String password) {
		userDao.create(username,password);
	}
	

}
