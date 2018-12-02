package funcionalidades.midia;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import com.sun.javafx.application.PlatformImpl;

public class PlayerAudio {

	private File arquivo;
	private Media midia;
	private MediaPlayer player;

	public void play(String audio) throws InterruptedException {
		PlatformImpl.startup(() -> {
		});

		this.arquivo = new File(audio);
		this.midia = new Media(this.arquivo.toURI().toASCIIString());
		this.player = new MediaPlayer(midia);
		this.player.setVolume(1);
		player.play();

	}

	public void teste() {

    	try {
        	
		System.out.println(player.getVolume());

		double progresso;
		
		for(int i = 100; i>=0; i--) {
			
			progresso = i;
    		Thread.currentThread();
				Thread.sleep(60);
				
			System.out.println(player.getVolume());
    		player.setVolume(progresso/100);
    	}


		
		System.out.println("teste");


}catch(InterruptedException e) {
	player.pause();
	player.stop();

}
	
	}

}
