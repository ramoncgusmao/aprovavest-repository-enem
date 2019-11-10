package com.ramon.gabarito.DTO;

import com.ramon.gabarito.domain.Idioma;
import com.ramon.gabarito.domain.Questao;
import com.ramon.gabarito.domain.TipoProva;

import lombok.Data;

@Data
public class QuestaoDTO {

	private int id;
	private int numero;
	private int tipoProva;
	private char letra;
	private int idioma;
	
	
	public Questao fromDto() {
		return Questao
				.builder()
				.numero(numero)
				.tipoProva(TipoProva.toEnum(this.tipoProva))
				.letra(letra)
				.idioma(Idioma.toEnum(this.idioma))
				.build();
	}
}
