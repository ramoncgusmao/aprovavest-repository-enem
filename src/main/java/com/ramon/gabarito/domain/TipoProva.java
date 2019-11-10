package com.ramon.gabarito.domain;

public enum TipoProva {
	SEMTIPO(0, "sem tipo"),
	LINGUAGENS(1, "LINGUAGENS"), 
	CIENCIAHUMANA(2, "CIENCIAS HUMANAS"),
	MATEMATICA(3, "MATEMATICA"),
	CIENCIANATUREZA(4, "CIENCIAS DA NATUREZA");
	
	private final int id;
	private String descricao;
	TipoProva(int valorOpcao,String descricao){
        id = valorOpcao;
		this.descricao = descricao;
        
        
    }
    public int getId(){
        return id;
    }
	public String getDescricao() {
		return descricao;
	}

	public static TipoProva toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoProva x : TipoProva.values()) {
			if(cod.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("id invalido: " + cod);
	}

	
}
