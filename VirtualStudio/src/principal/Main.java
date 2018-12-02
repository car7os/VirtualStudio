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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.SystemUtils;

import funcionalidades.midia.*;

//+------------------------------------------+
//| Classe Principal                         |
//+------------------------------------------+

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(">> Inicializando");

		AudioPlayer p1 = new AudioPlayer();
		AudioPlayer p2 = new AudioPlayer();
		
		p1.play("C:\\Users\\root\\Desktop\\Unidade de USB\\A (6) Informativo.mp3");
        Thread.currentThread().sleep(5000);
        p1.start();
		p1.fade();

		p2.play("C:\\Users\\root\\Desktop\\Unidade de USB\\A (9).mp3");
	     Thread.currentThread().sleep(15000);
	     p2.start();
	     p2.fade();

	     p1.play("C:\\Users\\root\\Desktop\\Unidade de USB\\A (6) Informativo.mp3");
	     p1.start();
	     p1.fade();

		/*   
		p2.play("C:\\Users\\root\\Desktop\\Unidade de USB\\A (9).mp3");
        Thread.currentThread().sleep(5000);
		p1.play("C:\\Users\\root\\Desktop\\Unidade de USB\\A (6) Informativo.mp3");
       */ 
        
		/*
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(p);
		*/


	}

}
//+------------------------------------------+
