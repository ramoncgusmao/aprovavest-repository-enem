package com.ramon.gabarito.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.gabarito.domain.CursinhoProva;
import com.ramon.gabarito.domain.Estudante;
import com.ramon.gabarito.domain.Questao;
import com.ramon.gabarito.domain.Resposta;
import com.ramon.gabarito.domain.Resultado;

@Service
public class EstudanteService {

	@Autowired
	private CursinhoProvaService cursinhoProvaService;

	public List<Resultado> calcularResultado(Estudante estudante) {

		List<CursinhoProva> cursinhoProvaDia1 = cursinhoProvaService.listarProvaCursinho(estudante.getDia1());
		List<CursinhoProva> cursinhoProvaDia2 = cursinhoProvaService.listarProvaCursinho(estudante.getDia2());
		List<Resposta> respostasDia1 = carregarRespostas(estudante, 1);
		List<Resposta> respostasDia2 = carregarRespostas(estudante, 2);
		List<Resultado> resultados = iniciarResultados(cursinhoProvaDia1);
		questoesAcertadas(cursinhoProvaDia1, respostasDia1, resultados);
		questoesAcertadas(cursinhoProvaDia2, respostasDia2, resultados);
		
		return resultados;
		
	}

	private List<Resultado> iniciarResultados(List<CursinhoProva> cursinhoProvaDia1) {
		List<Resultado> resultados = new ArrayList<Resultado>();
		for (CursinhoProva cursinhoProva : cursinhoProvaDia1) {
			resultados.add(new Resultado(cursinhoProva.getCursinho()));
		}
		return resultados;
	}

	private List<Resposta> carregarRespostas(Estudante estudante, int dia) {

		int valor = dia == 1 ? 0 : 90;

		return estudante.getRespostas().stream()
				.filter(x -> (x.getNumero() > (0 + valor) && x.getNumero() < (91 + valor)))
				.sorted(Comparator.comparingInt(Resposta::getNumero)).collect(Collectors.toList());
	}

	private void questoesAcertadas(List<CursinhoProva> cursinhoProvaDia1, List<Resposta> respostas, List<Resultado> resultados) {

		respostas.size();
		int resp = 0;
		for (CursinhoProva cursinhoProva : cursinhoProvaDia1) {

			if (cursinhoProva.getQuestoes().size() == 90) {
				resp = 0;
				compararRespostas(respostas, resp, cursinhoProva, resultados);
			}

		}
	}

	private void compararRespostas(List<Resposta> respostas, int resp, CursinhoProva cursinhoProva, List<Resultado> resultados) {
		Resultado resultado = resultados.get(0);
		
		for (Questao questao : cursinhoProva.getQuestoes()) {
			Resposta resposta = respostas.get(resp);
			if(resultado.getCursinho() != cursinhoProva.getCursinho()) {
				resultado = buscarResultadoCursinho(cursinhoProva, resultados);
			}
			if (resposta.getNumero() == questao.getNumero()) {

				if (resposta.getAltenativa() == questao.getLetra()) {
					int valor = resultado.getQuantidade().get(questao.getTipoProva()) + 1;
					resultado.getQuantidade().put(questao.getTipoProva(), valor);
				}
				resp++;
			}
		}
	}

	private Resultado buscarResultadoCursinho(CursinhoProva cursinhoProva, List<Resultado> resultados) {
		Resultado resultado = null;
		for (Resultado resultadoTemp : resultados) {
			if(resultadoTemp.getCursinho() == cursinhoProva.getCursinho() )
				resultado = resultadoTemp;
		}
		return resultado;
	}
}
