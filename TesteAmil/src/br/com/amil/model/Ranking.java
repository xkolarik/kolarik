package br.com.amil.model;

import java.util.HashMap;

public class Ranking {
	
	// quantidade de kills na partida
		private int qtdeKills;
		
		// hash de jogador e suas kills na partida
		private HashMap<String, Integer> kill = new HashMap<String, Integer>();
		
		
		public int getQtdeKills() {
			return qtdeKills;
		}

		public void setQtdeKills(int qtdeKills) {
			this.qtdeKills = qtdeKills;
		}

		public HashMap<String, Integer> getKill() {
			return kill;
		}

		public void setKill(HashMap<String, Integer> kill) {
			this.kill = kill;
		}

}
