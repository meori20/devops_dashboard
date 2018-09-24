package com.devops.dashboard.dataCollector.delegates;

import javax.servlet.http.HttpServletResponse;

public class delegatesUtil {
	
	public static void enableAccessControlForGetReq(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Expose-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");	
	}
	
	public static void enableAccessControlForPostReq(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Expose-Headers", "content-type");
		response.setHeader("Access-Control-Allow-Headers", "content-type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
	}

}
