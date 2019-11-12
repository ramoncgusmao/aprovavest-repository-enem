package com.ramon.gabarito.DTO;

import java.util.ArrayList;
import java.util.List;

import com.ramon.gabarito.domain.Estudante;

import lombok.Data;

@Data
public class EstudanteDTO {

	private Integer id;

	private String nome;

	private Integer idioma;

	private Integer dia1;

	private Integer dia2;

	private List<RespostaDTO> respostas = new ArrayList<>();

	public Estudante fromDTO() {
		
		Estudante estudante = new Estudante();
		
		return estudante;
	}
}
