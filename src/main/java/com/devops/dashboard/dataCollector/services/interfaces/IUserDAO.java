package com.devops.dashboard.dataCollector.services.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.devops.dashboard.dataCollector.services.impel.sqlLogin.UserDM;

public interface IUserDAO {

	void create(String username, String password);

	void setDatasource(DataSource ds);

	List<UserDM> getUser(String username, String password);

}
