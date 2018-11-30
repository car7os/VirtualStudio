package funcionalidades.hardware;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.lang.SystemUtils;

public class Shutdown {

	public void start() {

		String comando;
		ArrayList<String> parametros;
		ProcessBuilder processo;

		comando = "shutdown";
		parametros = new ArrayList<String>();

		if (SystemUtils.IS_OS_WINDOWS) {
			parametros.add("-s");
			parametros.add("-f");
		} else {
			if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC) {
				parametros.add("-h");
				parametros.add("now");
			} else {
				JOptionPane.showMessageDialog(null,
						"O seu Sistema Operacional não é compatível\nFunciona apenas em Windows, Linux e Mac.",
						"Erro ao Desligar", JOptionPane.WARNING_MESSAGE);
			}
		}

		processo = new ProcessBuilder("shutdown", "-s", "-f");
		try {
			processo.start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e, "Erro ao Desligar", JOptionPane.WARNING_MESSAGE);
		}

	}

}
