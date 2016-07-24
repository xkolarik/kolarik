package br.com.amil.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.amil.controller.Log;
import br.com.amil.model.Ranking;

public class LogImpl implements Log {

	@Override
	public StringBuilder load(String file) {

		File arquivo = new File(file);
		StringBuilder conteudo = new StringBuilder();
		BufferedReader reader;

		try {

			reader = new BufferedReader(new FileReader(arquivo));
			String text;

			while ((text = reader.readLine()) != null) {
				conteudo.append(text).append(System.getProperty("line.separator"));
			}

			reader.close();

		} catch (FileNotFoundException e) {
			e.getMessage();
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			System.out.println("Falha ao tentar ler arquivo! " + e.getMessage());
		}

		return conteudo;
	}
		
	@Override
	public void print(HashMap<String, Ranking> saida) {
		
		for (Map.Entry<String,Ranking> pair : saida.entrySet()) {
		    System.out.println("Partida :" + pair.getKey());
		    System.out.println("Kills :" + pair.getValue().getQtdeKills());
		    
		    for (Map.Entry<String,Integer> jogadores : pair.getValue().getKill().entrySet()) {
		    	System.out.println("Jogador :" + jogadores.getKey());
		    	System.out.println("No Mortes :" + jogadores.getValue());
		    	
		    }
   
		}
		
	}

}
