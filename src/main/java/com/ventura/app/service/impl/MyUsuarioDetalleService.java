package com.ventura.app.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Empleado;
import com.ventura.app.model.EmpleadoGrupo;
import com.ventura.app.repository.EmpleadoRepository;

import com.ventura.app.repository.EmpleadoGrupoRepository;

@Service
public class MyUsuarioDetalleService implements UserDetailsService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private EmpleadoGrupoRepository empleadoGrupoRepository;

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String usuarionombre) throws UsernameNotFoundException {

		Empleado empleado = empleadoRepository.findByEmpleadoNombre(usuarionombre);
		EmpleadoGrupo empleadoGrupo1 = empleadoGrupoRepository.findByGrupoEmpleado(usuarionombre);

		UserBuilder builder = null;

		if (empleado != null) {

			builder = org.springframework.security.core.userdetails.User.withUsername(empleado.getUsuarioNombre());
			builder.password(new BCryptPasswordEncoder().encode(empleado.getClave()));

			builder.roles(empleadoGrupo1.getGrupo().getNombre());
		// builder.authorities(getGrantedAuthorities((Collection<EmpleadoGrupo>)empleadoGrupo1.getGrupo()));

		} else {
			throw new UsernameNotFoundException("Nombre Usuario" + usuarionombre + " No encontrado ");
		}

		return builder.build();

	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(Collection<EmpleadoGrupo> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (EmpleadoGrupo role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getGrupo().getNombre()));
		}

		return authorities;

	}

}
