package com.udemy.backendninja.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.udemy.backendninja.repository.LogRepository;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	//primero
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis()); 
		return true;
	}
	
	//Segundo
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTiem = (long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();
		
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		String username = "";
		if(auth!= null && auth.isAuthenticated()) {
			username = auth.getName();
		}
		logRepository.save(new com.udemy.backendninja.entity.Log(new Date(), auth.getDetails().toString(), username, url));
		LOG.info("Url to: '" + request.getRequestURL().toString() + "' in: '" + (System.currentTimeMillis() - startTiem) + "ms'");
	}
	
}
