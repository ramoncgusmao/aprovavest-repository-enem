package com.ramon.gabarito.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	private Idioma idioma;
	
	@ManyToOne
	@JoinColumn(name = "dia1")
	private Prova dia1;
	
	@ManyToOne
	@JoinColumn(name = "dia2")
	private Prova dia2;
	
	@OneToMany(mappedBy = "estudante")
	private List<Resposta> respostas;
}
