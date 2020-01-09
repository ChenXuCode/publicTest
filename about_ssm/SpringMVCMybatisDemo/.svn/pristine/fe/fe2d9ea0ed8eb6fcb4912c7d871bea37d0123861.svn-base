package com.train.base.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

	public String getLoginUserName(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("USERNAME");
	}

	public Object getLoginUser(HttpServletRequest request) {
		return request.getSession().getAttribute("USER");
	}

	/**
	 * Get client network address
	 * 
	 * @param request
	 * @return
	 */
	public String getClientHostIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
