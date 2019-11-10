package com.ramon.gabarito.domain;

public enum Idioma {

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
}
