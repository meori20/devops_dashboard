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
public class getCreateUser {

	@Autowired
	ILoginService loginServie;

	@RequestMapping(value = "/createUser", params = { "username", "password" }, method = RequestMethod.GET)

	public String getCreateUser(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletResponse response) {
		delegatesUtil.enableAccessControlForGetReq(response);
		loginServie.register(username, password);


		return String.format("{ \"status\": \"ok\", \"username\": \"%s\"}", username);
	}
}
