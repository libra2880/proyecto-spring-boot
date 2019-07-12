package com.ventura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventura.app.model.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {

}
