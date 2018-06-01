package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * đây là Http interceptor (Ko phải Database interceptor).
 *
 */
public class DataSourceHttpIntercetor extends HandlerInterceptorAdapter {

	// Request:

	// /publisher/list
	// /advertiser/list
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String contextPath = request.getServletContext().getContextPath();

		// /SomeContextPath/publisher
		String prefixPublisher = contextPath + "/publisher";

		// /SomeContextPath/advertiser
		String prefixAdvertiser = contextPath + "/advertiser";

		// /SomeContextPath/publisher/dashboard
		// /SomeContextPath/advertiser/dashboard

		String uri = request.getRequestURI();
		System.out.println("URI:"+ uri);

		if(uri.startsWith(prefixPublisher)) {
			request.setAttribute("keyDS", "PUBLISHER_DS");    //sẽ lấy giá trị này ở Controller
		}

		else if(uri.startsWith(prefixAdvertiser)) {
			request.setAttribute("keyDS", "ADVERTISER_DS");    //sẽ lấy giá trị này ở Controller
		}

		return true;
	}

}