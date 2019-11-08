package com.ramon.gabarito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.gabarito.domain.Prova;
import com.ramon.gabarito.repository.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository provaRepository;
	
	public void salvar(Prova prova) {
		
		prova = provaRepository.save(prova);
		
	}
	
	public List<Prova> listaProvas(){
		return provaRepository.findAll();
	}
}
