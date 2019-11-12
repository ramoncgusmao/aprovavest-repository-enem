package com.ramon.gabarito.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.gabarito.DTO.EstudanteDTO;
import com.ramon.gabarito.domain.Estudante;

@RestController
@RequestMapping("/estudante")
public class EstudanteResource {

	
	
	
	public void receberEstudante(EstudanteDTO estudanteDto) {
		
		Estudante estudante = estudanteDto.fromDTO();
	}
	
	
}
