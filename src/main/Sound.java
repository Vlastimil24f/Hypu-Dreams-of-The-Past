package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    
    Clip clip;
    URL soundURL[] = new URL[30];
    private long clipPosition = 0; 
    FloatControl fc;
    int volumeScale = 3;
    float volume;

    public Sound() {
    	
        soundURL[0] = getClass().getResource("/sound/Luna.wav");
        soundURL[1] = getClass().getResource("/sound/Hypu's Silence.wav");
        soundURL[2] = getClass().getResource("/sound/Collect.wav");
        soundURL[3] = getClass().getResource("/sound/Unlock.wav");
        soundURL[4] = getClass().getResource("/sound/OpenChest.wav");
        soundURL[5] = getClass().getResource("/sound/Teleport.wav");
        soundURL[6] = getClass().getResource("/sound/AHH.wav");
        soundURL[7] = getClass().getResource("/sound/Hypu's Dream.wav");
        soundURL[8] = getClass().getResource("/sound/BladeSound.wav");
        soundURL[9] = getClass().getResource("/sound/Stab.wav");
        soundURL[10] = getClass().getResource("/sound/levelUp.wav");
        soundURL[11] = getClass().getResource("/sound/Cursor.wav");
        soundURL[12] = getClass().getResource("/sound/Emberlight.wav");
        soundURL[13] = getClass().getResource("/sound/GLUG.wav");
        soundURL[14] = getClass().getResource("/sound/Eat.wav");
        soundURL[15] = getClass().getResource("/sound/Volteris.wav");
        soundURL[16] = getClass().getResource("/sound/VoltarisImpact.wav");
        soundURL[17] = getClass().getResource("/sound/Blaze.wav");
        soundURL[18] = getClass().getResource("/sound/Coin.wav");
        soundURL[19] = getClass().getResource("/sound/Bush_Cut.wav");
        soundURL[20] = getClass().getResource("/sound/Book.wav");
        soundURL[21] = getClass().getResource("/sound/Rock_Hit.wav");
        soundURL[22] = getClass().getResource("/sound/GameOver.wav");
        soundURL[23] = getClass().getResource("/sound/Abyss.wav");
        soundURL[24] = getClass().getResource("/sound/Buy.wav");
        soundURL[25] = getClass().getResource("/sound/Sell.wav");
        soundURL[26] = getClass().getResource("/sound/Sleeping.wav");      
    }
    
    public void setFile(int i) {
    	
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void play() {
    	
        clip.setMicrosecondPosition(0); 
        clip.start();
    }
    
    public void loop() {
    	
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop() {
    	
        clip.stop();
        clipPosition = 0; 
    }
    
    public void checkVolume() {
    	
    	switch(volumeScale) {
    	
    	case 0: volume = -80f; break;
    	case 1: volume = -20f; break;
    	case 2: volume = -12f; break;
    	case 3: volume = -5f;  break;
    	case 4: volume = 1f;   break;
    	case 5: volume = 6f;   break;

    	}  	
    	
    	fc.setValue(volume);
    }
    
    public void pause() {
    	
        if (clip.isRunning()) {
            clipPosition = clip.getMicrosecondPosition(); 
            clip.stop(); 
        }
    }
    
    public void resume() {
    	
        clip.setMicrosecondPosition(clipPosition); 
        clip.start();
    }
    
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
