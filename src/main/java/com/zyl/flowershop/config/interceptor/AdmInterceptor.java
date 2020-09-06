package com.zyl.flowershop.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.util.SessionKey;

public class AdmInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Admin admin = (Admin) request.getSession().getAttribute(SessionKey.CURRENT_ADMIN);
		System.out.println(admin);
		if (admin == null) {
			// 未登录，重定向到登录页
			response.sendRedirect("/zyl/back");
			return false;
		}
		return true;
	}
}
