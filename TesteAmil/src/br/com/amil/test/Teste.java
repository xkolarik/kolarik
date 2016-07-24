package br.com.amil.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amil.controller.Match;
import br.com.amil.util.Constants;

public class Teste {
	
	@Test
	public void testStart() {
		Match score = new Match();
		String partida = score.retornaPartida("23/04/2013 15:34:22 - New match 11348965 has started", Constants.START);
		assertEquals(partida, "11348965");
	}
	
	@Test
	public void testEnd() {
		Match score = new Match();
		String partida = score.retornaPartida("23/04/2013 15:39:22 - Match 11348965 has ended", Constants.END);
		assertEquals(partida, "11348965");
	}
	
	@Test
	public void testKilled() {
		Match score = new Match();
		String jogador = score.retornaJogador("23/04/2013 15:36:04 - Roman killed Nick using M16", Constants.KILLED);
		assertEquals(jogador, "Nick");
	}

}
