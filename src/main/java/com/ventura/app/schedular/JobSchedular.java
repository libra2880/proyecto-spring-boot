package com.ventura.app.schedular;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ventura.app.aspect.LoggerAspect;
import com.ventura.app.service.UsuarioService;

@Component
public class JobSchedular {
	
	private static Logger logger= Logger.getLogger(LoggerAspect.class);
		private UsuarioService usuarioService;
		
		
	@Autowired
	public JobSchedular(UsuarioService usuarioService) {
		
			this.usuarioService = usuarioService;
		}


	//@Scheduled(cron="*/5 * * * * *")
	public void scheduleUsingCron(){
		logger.info(usuarioService.usuarioLista());
	}
	

	//@Scheduled(fixedDelay=1000,initialDelay=1000)
	public void scheduleUsingFixedDelayWithInitialDelay(){
		
	}
	
	//@Scheduled(fixedDelay=1000)
	public void scheduleUsingDelay(){
		
	}
	//@Scheduled(fixedRate=5000)
	public void scheduleUsingRate(){
		
	}
}
