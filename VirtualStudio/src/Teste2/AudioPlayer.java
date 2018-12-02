package Teste2;

import java.io.File;

import com.sun.javafx.application.PlatformImpl;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class AudioPlayer implements Runnable{

	private File arquivo;
	private Media midia;
	private MediaPlayer player;
	
	private boolean flag;
	

	public AudioPlayer() {
		//PlatformImpl.startup(() -> {});
		flag = false;
	}


	public void play(String audio) throws InterruptedException{

		while(flag) {
		     Thread.currentThread().sleep(15000);
		}

		this.arquivo = new File(audio);
		this.midia = new Media(this.arquivo.toURI().toASCIIString());
		this.player = new MediaPlayer(midia);
		this.player.setVolume(1);
		player.play();

	}
	
	
	public Runnable fade() {
		flag = true;
		return null;
	}

    public void run(){
    	
    	

    	while(flag) {
    	
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

		
		
		System.out.println("fim> "+player.getVolume());
		player.pause();
		flag = false;
		player.stop();
    	PlatformImpl.exit();

		 
    	}catch(InterruptedException e) {
    		player.pause();
        	player.stop();
        	PlatformImpl.exit();

    	}
    	}

    	
    	
      }

}
