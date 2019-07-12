package com.ventura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventura.app.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
