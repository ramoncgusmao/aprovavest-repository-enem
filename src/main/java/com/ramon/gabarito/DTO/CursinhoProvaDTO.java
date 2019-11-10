package com.ramon.gabarito.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import com.ramon.gabarito.domain.Cursinho;
import com.ramon.gabarito.domain.CursinhoProva;
import com.ramon.gabarito.domain.Prova;

import lombok.Data;

@Data
public class CursinhoProvaDTO {

	private int id;

	private int cursinho;
	private int prova;
	@NotEmpty
	private List<QuestaoDTO> questoes = new ArrayList<>();
	
	
	public CursinhoProva fromDto() {
		return CursinhoProva
				.builder()
				.cursinho(Cursinho.builder().id(cursinho).build())
				.prova(Prova.builder().id(prova).build())
				.questoes(questoes.stream().map(QuestaoDTO::fromDto).collect(Collectors.toList()))
				.build();
	}



}
