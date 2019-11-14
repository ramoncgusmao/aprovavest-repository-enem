package com.ramon.gabarito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.gabarito.domain.CursinhoProva;
import com.ramon.gabarito.domain.Prova;
import com.ramon.gabarito.repository.CursinhoProvaRepository;

@Service
public class CursinhoProvaService {

	@Autowired
	private CursinhoProvaRepository repository;
	
	public void salvar(CursinhoProva cursinhoProva) {
		cursinhoProva.getQuestoes().stream().forEach(x -> x.setCursinhoProva(cursinhoProva));
		
		repository.save(cursinhoProva);
	
	}

	public List<CursinhoProva> listarProvaCursinho(Prova prova1) {
	
		 return repository.findByProva(prova1);
	}
}
