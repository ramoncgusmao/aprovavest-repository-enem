package com.ramon.gabarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramon.gabarito.domain.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Integer>{

}
