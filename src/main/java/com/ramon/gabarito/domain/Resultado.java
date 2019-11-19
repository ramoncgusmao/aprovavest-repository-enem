package com.ramon.gabarito.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Resultado {

	private Cursinho cursinho;
	
	private Map<TipoProva, Integer> quantidade;
	

	public Resultado(Cursinho cursinho){
		cursinho = cursinho;
		quantidade = new HashMap<TipoProva, Integer>();
		quantidade.put(TipoProva.LINGUAGENS, 0);
		quantidade.put(TipoProva.CIENCIAHUMANA, 0);
		quantidade.put(TipoProva.MATEMATICA, 0);
		quantidade.put(TipoProva.CIENCIANATUREZA, 0);
		
	}
}
