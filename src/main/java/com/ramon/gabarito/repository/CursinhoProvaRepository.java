package com.ramon.gabarito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramon.gabarito.domain.CursinhoProva;
import com.ramon.gabarito.domain.Prova;

public interface CursinhoProvaRepository extends JpaRepository<CursinhoProva, Integer>{

	List<CursinhoProva> findByProva(Prova prova);

}
