package com.ramon.gabarito.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursinhoProva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_cursinho")
	private Cursinho cursinho;
	
	@ManyToOne
	@JoinColumn(name = "id_prova")
	private Prova prova;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cursinhoProva")
    @OrderBy("numero ASC")
	private List<Questao> questoes;
	
}
