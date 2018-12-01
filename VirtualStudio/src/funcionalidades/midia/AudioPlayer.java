package funcionalidades.midia;

import java.io.File;

import javax.net.ssl.SSLEngineResult.Status;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer {

	private File arquivo;

	private Media midia;
	private MediaPlayer player;

	public AudioPlayer(String arquivo) {
		this.arquivo = null;
		this.midia = null;
		this.player = null;

		PlatformImpl.startup(() -> {
		});

		this.arquivo = new File(arquivo);
		this.midia = new Media(this.arquivo.toURI().toASCIIString());
		this.player = new MediaPlayer(midia);
		this.player.setVolume(1.00);
	}

	public void finalize() {
		PlatformImpl.exit();
	}

	public void setTempo(float tempo) {
	}

	public float getTempo() {
		return 0;
	}

	public float duracao() {
		return 0;
	}

	public void play() {
		this.player.play();
	}

	public void stop() throws InterruptedException {
		
		while(this.player.getVolume()>0) {
			
			System.out.println(this.player.getVolume());
			Thread.currentThread();
			Thread.sleep(6*10);
			
			this.player.setVolume(this.player.getVolume()-0.01);
		}
		
		this.player.stop();
	}

	public void pause() {
		this.player.pause();
	}

}
