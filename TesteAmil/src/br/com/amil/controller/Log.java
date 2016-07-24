package br.com.amil.controller;

import java.util.HashMap;

import br.com.amil.model.Ranking;;

//dao generico
public interface Log {
	
	public StringBuilder load(String file);
	
	public void print(HashMap<String, Ranking> saida);

}
