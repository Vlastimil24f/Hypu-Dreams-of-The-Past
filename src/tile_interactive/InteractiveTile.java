package tile_interactive;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.GamePanel;

public class InteractiveTile extends Entity{
	
	GamePanel gp;
	public boolean destructible = false;

	public InteractiveTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}
	
	public boolean isCorrectItem(Entity entity) {
		
		boolean isCorrectItem = false;
		return isCorrectItem;
		
	}
	
	public void playSE() {
		
	}
	
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = null;
		return tile;
	}
	
	public void update() {
		
		if (invincible) {
	        invincibleCounter++;
	        if (invincibleCounter > 20) {
	            invincible = false;
	            invincibleCounter = 0;
	        }
	    }	
	}
	
	/*public void draw (Graphics2D g2) {
		
	    int screenX = worldX - gp.hypu.worldX + gp.hypu.screenX;
	    int screenY = worldY - gp.hypu.worldY + gp.hypu.screenY;
	    
	    if (worldX + gp.tileSize > gp.hypu.worldX - gp.hypu.screenX && worldX - gp.tileSize < gp.hypu.worldX + gp.hypu.screenX && worldY + gp.tileSize > gp.hypu.worldY - gp.hypu.screenY && worldY - gp.tileSize < gp.hypu.worldY + gp.hypu.screenY) {
	    	
	    }
	    
	    g2.drawImage(downStand, screenX, screenY, null);
	    
	    //TRANSPARENT WHEN HIT
	        
	}*/
	
}
