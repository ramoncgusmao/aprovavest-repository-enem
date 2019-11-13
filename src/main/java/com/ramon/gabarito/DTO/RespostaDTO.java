package com.ramon.gabarito.DTO;

import com.ramon.gabarito.domain.Estudante;
import com.ramon.gabarito.domain.Prova;
import com.ramon.gabarito.domain.Resposta;

import lombok.Data;

@Data
public class RespostaDTO {

	private int numero;
	
	private char letra;
	
	
	public Resposta fromDTO(Estudante estudante) {
		return Resposta
				.builder()
				.numero(numero)
				.altenativa(letra)
				.estudante(estudante)
				.prova(carregarProva(estudante,numero))
				.build();
	}


	private Prova carregarProva(Estudante estudante, int numero) {
		
		return (numero <= 90) ? estudante.getDia1() : estudante.getDia2();
	}
	

	
	
}
