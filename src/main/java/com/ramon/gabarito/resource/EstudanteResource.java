package com.ramon.gabarito.resource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.gabarito.DTO.EstudanteDTO;
import com.ramon.gabarito.domain.CursinhoProva;
import com.ramon.gabarito.domain.Estudante;
import com.ramon.gabarito.domain.Questao;
import com.ramon.gabarito.domain.Resposta;
import com.ramon.gabarito.service.CursinhoProvaService;
import com.ramon.gabarito.service.EstudanteService;

@RestController
@RequestMapping("/estudante")
public class EstudanteResource {

	
	@Autowired
	private EstudanteService estudanteService;
	
	private CursinhoProvaService cursinhoProvaService;
	
	public void receberEstudante(EstudanteDTO estudanteDto) {
		
		Estudante estudante = estudanteDto.fromDTO();
		List<CursinhoProva> cursinhoProvaDia1 = cursinhoProvaService.listarProvaCursinho(estudante.getDia1());
		List<CursinhoProva> cursinhoProvaDia2 = cursinhoProvaService.listarProvaCursinho(estudante.getDia2());
		List<Resposta> respostasDia1 = carregarRespostas(estudante, 1);
		List<Resposta> respostasDia2 = carregarRespostas(estudante, 2);
		questoesAcertadas(cursinhoProvaDia1, respostasDia1);
	}

	private List<Resposta> carregarRespostas(Estudante estudante, int dia) {
		
		int valor = dia == 1 ? 0 : 90;
		
		return estudante.getRespostas().stream().filter(x -> (x.getNumero() > (0 + valor) && x.getNumero() < (91 + valor)))
				.sorted(Comparator.comparingInt(Resposta::getNumero))
				.collect(Collectors.toList());
	}

	private void questoesAcertadas(List<CursinhoProva> cursinhoProvaDia1, List<Resposta> respostas) {
	
		respostas.size();
		int resp = 0;
		for (CursinhoProva cursinhoProva : cursinhoProvaDia1) {
	
			if(cursinhoProva.getQuestoes().size() == 90) {
				resp = 0;
				compararRespostas(respostas, resp, cursinhoProva);
			}

		}
	}

	private void compararRespostas(List<Resposta> respostas, int resp, CursinhoProva cursinhoProva) {
		for(Questao questao : cursinhoProva.getQuestoes()) {
			Resposta resposta = respostas.get(resp);
			if(resposta.getNumero() == questao.getNumero()) {
				
				if(resposta.getAltenativa() == questao.getLetra()) {
					
				}
				resp++;
			}
		}
	}
	
	
}
