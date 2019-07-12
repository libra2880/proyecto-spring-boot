package com.ventura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventura.app.model.Negocio;

public interface NegocioRepository extends JpaRepository<Negocio, Long> {

}
