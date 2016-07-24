package br.com.amil.controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.model.Ranking;
import br.com.amil.util.Constants;

public class Match {
	
HashMap<String, Ranking> partida = new HashMap<String, Ranking>();
	
	String partidaIniciada = "";
	
	public HashMap<String, Ranking> analisaLog (StringBuilder log)
	{
				
		// verifica linhas do log
		Scanner scan = new Scanner(log.toString()); 
		while (scan.hasNextLine() ){
		 String oneLine = scan.nextLine();
		 analisaLinha(oneLine);
		}
		
		return partida;
	}
	
	private void analisaLinha(String linha)
	{
		// vrifica inicio de partida
		if (retornaPartida(linha,Constants.START) != null)
		{
			partidaIniciada = retornaPartida(linha,Constants.START);
			partida.put(partidaIniciada, new Ranking());
		}
		
		// verifica kills
		if (retornaJogador(linha,Constants.KILLED) != null && !linha.contains(Constants.World))
		{
			String jogador = retornaJogador(linha,Constants.KILLED);
			Ranking rel = partida.get(partidaIniciada);
			if (rel.getKill().containsKey(jogador))
			{
				int mortes = rel.getKill().get(jogador);
				rel.getKill().put(jogador, mortes+1);
			}
			else
			{
				rel.getKill().put(jogador, 1);
			}
			
			rel.setQtdeKills
		
			(rel.getQtdeKills()+1);
			
			partida.put(partidaIniciada, rel);
		}
		
		// verifica fim de partida
		if (retornaPartida(linha,Constants.END) != null)
		{
			partidaIniciada = "";
		}
		
		
	}
	
	// metodo que retorna a partida de acordo com o pattern
		public String retornaPartida(String texto, Pattern pattern) {
			Matcher matcher = pattern.matcher(texto);
			if (matcher.matches() && matcher.groupCount() == 1) {
				return matcher.group(1);
			} else {
				return null;
			}
		}
		
		// metodo que retorna o jogador de acordo com o pattern
		public String retornaJogador(String texto, Pattern pattern) {
			Matcher matcher = pattern.matcher(texto);
			if (matcher.matches() && matcher.groupCount() == 2) {
				return matcher.group(2);
			} else {
				return null;
			}
		}

}
