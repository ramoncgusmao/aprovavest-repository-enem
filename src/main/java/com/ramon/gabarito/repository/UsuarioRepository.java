package com.ramon.gabarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramon.gabarito.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
