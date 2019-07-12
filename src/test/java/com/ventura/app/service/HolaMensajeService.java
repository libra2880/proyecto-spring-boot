package com.ventura.app.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class HolaMensajeService implements MensajeService {

	@Override
	public String getMensaje() {
		
		Authentication autentificacion=SecurityContextHolder.getContext().getAuthentication();
		
		return "Hola" +autentificacion;
	}

}
