package com.ventura.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ventura.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

			@Query("From Usuario WHERE usuarioNombre=:usuarionombre")
			Usuario findByUsuarionombre(@Param("usuarionombre") String usuarionombre);
}
