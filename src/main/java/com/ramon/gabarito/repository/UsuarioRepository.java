package com.ramon.gabarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramon.gabarito.domain.TipoProva;

public interface UsuarioRepository extends JpaRepository<TipoProva, Integer>{

}
