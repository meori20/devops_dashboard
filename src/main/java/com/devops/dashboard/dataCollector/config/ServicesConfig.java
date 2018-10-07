package com.devops.dashboard.dataCollector.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.devops.dashboard.dataCollector.mappers.impel.MapSonarResponsesToSonarDM;
import com.devops.dashboard.dataCollector.mappers.interfaces.IMapSonarResponsesToSonarDM;
import com.devops.dashboard.dataCollector.services.impel.InitialScreenService;
import com.devops.dashboard.dataCollector.services.impel.SonarService;
import com.devops.dashboard.dataCollector.services.impel.sqlLogin.SqlLogin;
import com.devops.dashboard.dataCollector.services.impel.sqlLogin.UserDAO;
import com.devops.dashboard.dataCollector.services.interfaces.IInitialScreenService;
import com.devops.dashboard.dataCollector.services.interfaces.ILoginService;
import com.devops.dashboard.dataCollector.services.interfaces.ISonarService;
import com.devops.dashboard.dataCollector.services.interfaces.IUserDAO;

@Configuration
@PropertySource(value = { "classpath:application.properties"})
public class ServicesConfig {
	
	@Autowired
    private Environment env;
	
	@Bean
	public ISonarService sonarService() {
		return new SonarService();
	}
	
	@Bean
	public IMapSonarResponsesToSonarDM mapSonarResponsesToSonarDM() {
		return new MapSonarResponsesToSonarDM();
	}
	
	@Bean
	public IInitialScreenService getInitialScreenService() {
		return new InitialScreenService();
	}
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
    
    @Bean
    public ILoginService loginService() {
    	return new SqlLogin();
    }
    
    @Bean
    public IUserDAO userDao()
    {
    	return new UserDAO();
    }
}