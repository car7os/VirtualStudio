package funcionalidades.executar;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Comando {

	private ArrayList<String> comando;

	public void setComando(String comando) {
		this.comando = new ArrayList<String>();
		
		String[] linhaComando = comando.split(" ");
		
		for(int i = 0; i < linhaComando.length; i++) {
			this.comando.add(linhaComando[i]);
		}
		
		System.out.println(this.comando);

	}

	public String getComando() {
		return this.comando.toString();
	}

	public void start() {
		
		ProcessBuilder processo = new ProcessBuilder(this.comando);
		
		try {
		processo.start();
		}catch(IOException e) {
			JOptionPane.showInternalMessageDialog(null, e, "Erro ao executar comando", JOptionPane.WARNING_MESSAGE);
		}
	}

}
