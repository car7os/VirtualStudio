/*
 *  Copyright (C) 2018 Carlos Vilela
 *  Engenharia de Computa��o
 *  VirtualStudio
 *
 *  Esta � uma class que tem por finalidade executar a inicializa��o do projeto,
 *  ou seja, � uma class Principal, onde inicia as telas e os componentes b�sicos
 */

package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import funcionalidades.midia.PlayerAudio;

//+------------------------------------------+
//| Classe Principal                         |
//+------------------------------------------+

public class Main {

	public static void main(String[] args) {
		System.out.println(">> Inicializando");
		
		PlayerAudio player = new PlayerAudio();
		PlayerAudio playerY = new PlayerAudio();
		
		Runnable thread = () -> {
			try {
				player.play("C:\\Users\\root\\Desktop\\Unidade de USB\\A (6) Informativo.mp3");
				Thread.sleep(20000);
				player.teste();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable threadY = () -> {
			try {
				playerY.play("C:\\Users\\root\\Desktop\\Unidade de USB\\A (9).mp3");
				Thread.sleep(40000);
				playerY.teste();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};


Thread thread1 = new Thread(thread);

thread1.start();
		
Thread thread2 = new Thread(threadY);

thread2.start();



		
		

	}
}
//+------------------------------------------+
