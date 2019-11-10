package com.ramon.gabarito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.gabarito.domain.Cursinho;
import com.ramon.gabarito.repository.CursinhoRepository;

@Service
public class CursinhoService {

	@Autowired
	private CursinhoRepository repository;
	
	public void salvar(Cursinho cursinho) {
		
		repository.save(cursinho);
	}

	public List<Cursinho> listar(){
		return repository.findAll();
	}
	
}
