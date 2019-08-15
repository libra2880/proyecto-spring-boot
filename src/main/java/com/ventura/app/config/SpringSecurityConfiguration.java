package com.ventura.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.ventura.app.filter.CustomFilter;
import com.ventura.app.filter.SimpleAuthenticationFilter;
import com.ventura.app.model.Usuario;
import com.ventura.app.service.MyUsuarioDetalleService;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
/*	@Autowired
	private AuthenticationEntryPoint entryPoint;
	
	
	private MyUsuarioDetalleService usuarioDetalleService;
	private Usuario usuario;*/
	

	 @Bean
	 @Autowired
	  public UserDetailsService userDetailsService() {
	    return new MyUsuarioDetalleService();
	  };
	

	  
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		
		
		
		/*auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder())
		.withUser(usuario.getUsuarioNombre())
		.password(passwordEncoder().encode(usuario.getClave()))
		.roles(usuario.getRol().getNombre())
		;*/
		
	
	}
	
	  /* public SimpleAuthenticationFilter authenticationFilter() throws Exception {
	        SimpleAuthenticationFilter filter = new SimpleAuthenticationFilter();
	        filter.setAuthenticationManager(authenticationManagerBean());
	        filter.setAuthenticationFailureHandler(failureHandler());
	        return filter;
	    }
	*/
	
	  
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		final CustomFilter tokenFilter = new CustomFilter();
        http.addFilterBefore(tokenFilter, BasicAuthenticationFilter.class);

        
        http			
		.authorizeRequests()		
		.antMatchers("/resources/**", "/static/**", "/css/**", "/fonts/**", "/js/**", "/images/**")
	
		.permitAll()
		 .anyRequest()
		.authenticated()		
		.and()
		.formLogin()
		.loginPage("/empleado/login")
		.permitAll()
		.and()
		.logout().deleteCookies("rememberme")
		.permitAll()
		.and()
		.rememberMe()
		.tokenValiditySeconds(120);
		
		
		http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
		
	}
	
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	
}
