package com.devops.dashboard.dataCollector.delegates;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.dashboard.dataCollector.services.interfaces.ILoginService;

@RestController
public class getLogin {

	@Autowired
	ILoginService loginServie;
	
	@RequestMapping(value = "/login", params = { "username", "password" }, method = RequestMethod.GET)
	@ResponseBody
	public String getBarBySimplePathWithExplicitRequestParams(@RequestParam("username") String username ,@RequestParam("password")String password, HttpServletResponse response) {
		delegatesUtil.enableAccessControlForGetReq(response);
		if(loginServie.login(username, password)) {
			return "{\"status\": \"ok\"}";
		}
		
		return "{\"status\": \"error\"}";
	}
}
