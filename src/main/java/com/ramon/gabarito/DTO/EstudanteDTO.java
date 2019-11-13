package com.ramon.gabarito.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ramon.gabarito.domain.Estudante;
import com.ramon.gabarito.domain.Idioma;
import com.ramon.gabarito.domain.Prova;

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
		estudante.setNome(nome);
		estudante.setIdioma(Idioma.toEnum(idioma));
		estudante.setDia1(Prova.builder().id(dia1).build());
		estudante.setDia2(Prova.builder().id(dia2).build());
		estudante.setRespostas(respostas.stream().map(x -> x.fromDTO(estudante)).collect(Collectors.toList()));
		return estudante;
	}


}
