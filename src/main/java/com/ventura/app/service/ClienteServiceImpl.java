package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Cliente;
import com.ventura.app.repository.ClienteRepository;
import com.ventura.app.repository.TipoClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;
	private TipoClienteRepository tipoCRepository;
	
	
	
	

	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository, TipoClienteRepository tipoCRepository) {
	
		this.clienteRepository = clienteRepository;
		this.tipoCRepository = tipoCRepository;
	}

	@Override
	public List<Cliente> listaCliente() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> getCliente(Long idCliente) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(idCliente);
	}

	@Override
	public Cliente agregarCliente(Cliente cliente) {
		cliente.setTipocliente(tipoCRepository.getOne(cliente.getTipocliente().getIdtipocliente()));
		return clienteRepository.save(cliente);
	}

	@Override
	public String eliminarCliente(Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizarCliente(Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
