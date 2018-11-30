package funcionalidades.hardware;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.lang.SystemUtils;

public class Shutdown {

	public void start() {

		ArrayList<String> comando;
		ProcessBuilder processo;

		comando = new ArrayList<String>();
		comando.add("shutdown"); // Comando principal

		// Parametros conforme o Sistema Operacional
		if (SystemUtils.IS_OS_WINDOWS) {
			comando.add("-s");
			comando.add("-f");
		} else {
			if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
				comando.add("-h");
				comando.add("now");
			} else {
				JOptionPane.showMessageDialog(null,
						"O seu Sistema Operacional não é compatível\nFunciona apenas em Windows, Linux e Mac.",
						"Erro ao Desligar", JOptionPane.WARNING_MESSAGE);
			}
		}

		// Incluir comando no Processo
		processo = new ProcessBuilder(comando);
		try {
			processo.start(); // Executar Processo
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e, "Erro ao Desligar", JOptionPane.WARNING_MESSAGE);
		}

	}

}
