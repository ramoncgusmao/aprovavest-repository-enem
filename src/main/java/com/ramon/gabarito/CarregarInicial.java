package com.ramon.gabarito;

import org.springframework.beans.factory.annotation.Autowired;

import com.ramon.gabarito.domain.Prova;
import com.ramon.gabarito.service.ProvaService;

public class CarregarInicial {

	@Autowired
	private ProvaService provaService;
	
	private void carregar() {
		
		Prova amarelo = Prova.builder().cor("amarelo").dia(1).build();
		Prova azul = Prova.builder().cor("azul").dia(1).build();
		Prova branco = Prova.builder().cor("branco").dia(1).build();
		Prova rosa = Prova.builder().cor("rosa").dia(1).build();
		
		provaService.salvar(amarelo);
		provaService.salvar(azul);
		provaService.salvar(branco);
		provaService.salvar(rosa);
		
	}
}
