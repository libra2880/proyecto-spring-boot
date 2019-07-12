package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Cliente;

public interface ClienteService {

	List<Cliente> listaCliente();
	Optional<Cliente> getCliente(Long idCliente);
	Cliente agregarCliente(Cliente cliente);
	String eliminarCliente(Long idCliente);
	String actualizarCliente(Long idCliente);
	
}
