package com.devops.dashboard.dataCollector.services.impel.sqlLogin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserDM>{

	@Override
	public UserDM mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDM user = new UserDM();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		return user;
	}
	
}
