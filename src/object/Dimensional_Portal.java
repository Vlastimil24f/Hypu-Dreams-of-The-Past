package object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Dimensional_Portal extends Entity {
	
	GamePanel gp;
    private BufferedImage[] frames;
    private int currentFrame;
    private int frameCount = 6; 
    private int frameDelay = 8;  
    private int frameTimer = 0;

    public Dimensional_Portal(GamePanel gp) {
    	
        super(gp);
        this.gp = gp;
        name = "Dimensional Portal";
        direction = "down";
        frames = new BufferedImage[frameCount];
        loadFrames();
        downStand = frames[0];  
    }

    private void loadFrames() {
    	for (int i = 0; i < frameCount; i++) {
            frames[i] = setup("/objects/Dimensional_Portal" + (i + 1), gp.tileSize, gp.tileSize);
        }
    }

    @Override
    public void update() {
        frameTimer++;
        if (frameTimer >= frameDelay) {
            frameTimer = 0;
            currentFrame = (currentFrame + 1) % frameCount;
            downStand = frames[currentFrame];
        }
    }
}
