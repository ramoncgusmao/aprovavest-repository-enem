package com.ramon.gabarito.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.gabarito.DTO.CursinhoProvaDTO;
import com.ramon.gabarito.domain.CursinhoProva;
import com.ramon.gabarito.service.CursinhoProvaService;
@RestController
@RequestMapping("/cursinhoProva")
public class CursinhoProvaResource {

	@Autowired
	private CursinhoProvaService service;
	
	@PostMapping
	public void salvar(@RequestBody CursinhoProvaDTO cursinhoProvaDto) {
		
		CursinhoProva cursinhoProva = cursinhoProvaDto.fromDto();
		
		service.salvar(cursinhoProva);
		
		
	}
}
