package com.devops.dashboard.dataCollector.services.impel.sqlLogin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.devops.dashboard.dataCollector.services.interfaces.IUserDAO;

public class UserDAO implements IUserDAO {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String username, String password) {
		String SQLQuery = "insert into dashboardTable (username, password) values (\"" + username + "\", \"" + password
				+ "\")";
		jdbcTemplate.update(SQLQuery);
	}

	@Override
	public List<UserDM> getUser(String username, String password) {
		List<UserDM> user = null;
		String SQLQuery = "SELECT * FROM dashboardTable WHERE username = ? AND password = ?";
		user = jdbcTemplate.query(SQLQuery, new Object[] {username, password},new UserMapper());

		return user;
	}
}
