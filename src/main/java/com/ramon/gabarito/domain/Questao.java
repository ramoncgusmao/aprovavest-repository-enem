package com.ramon.gabarito.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_cursinho_prova")
	private CursinhoProva cursinhoProva;

	private int numero;
	@ManyToOne
	@JoinColumn(name = "id_tipo_prova")
	private TipoProva tipoProva;

	private char letra;
	
	@Enumerated(value = EnumType.ORDINAL)
	private Idioma idioma;
}
