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
