package com.ramon.gabarito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.gabarito.domain.CursinhoProva;
import com.ramon.gabarito.repository.CursinhoProvaRepository;

@Service
public class CursinhoProvaService {

	@Autowired
	private CursinhoProvaRepository repository;
	
	public void salvar(CursinhoProva cursinhoProva) {
		cursinhoProva.getQuestoes().stream().forEach(x -> x.setCursinhoProva(cursinhoProva));
		
		repository.save(cursinhoProva);
	
	}

}
