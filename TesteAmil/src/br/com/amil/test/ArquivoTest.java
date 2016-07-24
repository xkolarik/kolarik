package br.com.amil.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amil.controller.Log;
import br.com.amil.imp.LogImpl;
import br.com.amil.service.LogService;

public class ArquivoTest {
	
	@Test
	public void testLeitura() {
		Log dao = new LogImpl();
		StringBuilder st = dao.load("C:\\Users\\kolarik\\Desktop\\exemplo.txt");
		boolean n = false;
		if (st == null) n= true;
		assertEquals(n, false);
	}
	
	public static void main(String[] args){
		
		LogService.logService("C:\\Users\\kolarik\\Desktop\\exemplo.txt");
	}

}
