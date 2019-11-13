package com.ramon.gabarito.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.gabarito.DTO.EstudanteDTO;
import com.ramon.gabarito.domain.Estudante;
import com.ramon.gabarito.service.EstudanteService;

@RestController
@RequestMapping("/estudante")
public class EstudanteResource {

	
	@Autowired
	private EstudanteService estudanteService;
	
	public void receberEstudante(EstudanteDTO estudanteDto) {
		
		Estudante estudante = estudanteDto.fromDTO();
		
		
	}
	
	
}
