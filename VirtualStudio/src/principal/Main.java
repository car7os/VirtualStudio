/*
 *  Copyright (C) 2018 Carlos Vilela
 *  Engenharia de Computação
 *  VirtualStudio
 *
 *  Esta é uma class que tem por finalidade executar a inicialização do projeto,
 *  ou seja, é uma class Principal, onde inicia as telas e os componentes básicos
 */

package principal;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang.SystemUtils;

import funcionalidades.hardware.Shutdown;

//+------------------------------------------+
//| Classe Principal                         |
//+------------------------------------------+

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println(">> Inicializando");
		
		
		

		
		Shutdown t = new Shutdown();
		
		t.start();
		
	}

}
//+------------------------------------------+
