/*
 *  Copyright (C) Carlos Vilela
 *  Engenharia de Computação
 *  VirtualStudio
 *  
 *  Esta classe destina-se a executar linhas de comandos do prompt
 */

package funcionalidades.executar;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//+--------------------------------+
//| Classe Comando                 |
//+--------------------------------+

public class Comando {

	private ArrayList<String> comando;

	public void setComando(String comando) {
		this.comando = new ArrayList<String>();
		
		String[] linhaComando = comando.split(" "); //pega a linha e separa conforme houver espaços
		
		// adiciona linha por linha na Array comando
		for(int i = 0; i < linhaComando.length; i++) {
			this.comando.add(linhaComando[i]);
		}

	}

	public String getComando() { // visualiza a linha de comando
		return this.comando.toString();
	}

	public void start() {
		
		// Cria um processo e executa a linha de comando no prompt
		
		ProcessBuilder processo = new ProcessBuilder(this.comando);
		
		try {
		processo.start();
		}catch(IOException e) {
			JOptionPane.showInternalMessageDialog(null, e, "Erro ao executar comando", JOptionPane.WARNING_MESSAGE);
		}
	}

}
//+--------------------------------+
