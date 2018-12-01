/*
 *  Copyright (C) 2018 Carlos Vilela
 *  Engenharia de Computa��o
 *  VirtualStudio
 *
 *  Esta � uma class que tem por finalidade executar a inicializa��o do projeto,
 *  ou seja, � uma class Principal, onde inicia as telas e os componentes b�sicos
 */

package principal;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang.SystemUtils;

import funcionalidades.midia.*;

//+------------------------------------------+
//| Classe Principal                         |
//+------------------------------------------+

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(">> Inicializando");
		
		AudioPlayer p1,p2;
		
		p1= new AudioPlayer("C:\\Users\\root\\Desktop\\Unidade de USB\\A (2).mp3");
		p1.play();
		Thread.currentThread();
		Thread.sleep(7000);
		p1.stop();
		p2= new AudioPlayer("C:\\Users\\root\\Desktop\\Unidade de USB\\A (1).mp3");
		p2.play();
	
		
		
	}

}
//+------------------------------------------+
