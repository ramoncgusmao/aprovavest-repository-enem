package com.ramon.gabarito.domain;

public enum Idioma {
	
	SEMIDIOMA(0),
	INGLES(1), 
	ESPANHOL(2),
	NENHUM(3);
	
	private final int id;
	Idioma(int valorOpcao){
        id = valorOpcao;
    }
    public int getId(){
        return id;
    }
    
    public static Idioma toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Idioma x : Idioma.values()) {
			if(cod.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("id invalido: " + cod);
	}

}
