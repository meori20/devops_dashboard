package com.devops.dashboard.dataCollector.delegates;

import com.devops.dashboard.dataCollector.dataModels.interfaces.ITestDM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testDelegate {
	
	@Autowired
	public ITestDM testDM;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String testMethod() {
		testDM.PrintHello();
		return "stam";
	}
	

}
