package br.com.amil.service;

import br.com.amil.controller.Log;
import br.com.amil.controller.Match;
import br.com.amil.imp.LogImpl;

public class LogService {
	
	static Log dao = new LogImpl();
	
	public static void logService(String file){
		Match score = new Match();
		dao.print(score.analisaLog(dao.load(file)));
	}
	
	public static void main(String[] args){
		
		logService("C:\\Users\\kolarik\\Desktop\\exemplo.txt");
	}
}
