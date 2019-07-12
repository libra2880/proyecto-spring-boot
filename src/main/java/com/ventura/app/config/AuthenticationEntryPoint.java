package com.ventura.app.config;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		
		
		response.setHeader("WWW-Authenticate", "Basic realm= " + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		//response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		
		PrintWriter writer=response.getWriter();
		
		writer.println("Http Status 401 " + authException.getMessage());
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("Proyecto");
		
		super.afterPropertiesSet();
	}
	
}
