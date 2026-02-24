package tile_interactive;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;

public class Destroyable_Rock extends InteractiveTile{
	
	GamePanel gp;

	public Destroyable_Rock(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		downStand = setup("/tiles_interactive/Destroyable_Rock",gp.tileSize, gp.tileSize);
		destructible = true;
		life = 3;
		
	}
	
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		
		if (entity.currentWeapon.type == 7) {
			isCorrectItem = true;
		}
		return isCorrectItem;
	}
	
	public void playSE() {
		gp.playSE(21);
	}
	
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = new Grass_Destroyable_Bush(gp, worldX/gp.tileSize, worldY/gp.tileSize);
		return tile;
	}
	
	public Color getParticleColor() {
		
		Color color = new Color(166, 145, 118);
		return color;
	}
	
	public int getParticleSize() {
		
		int size = 3;
		return size;
	}
	
	public int getParticleSpeed() {
		
		int speed = 1;
		return speed;
	}
	
	public int getParticleMaxLife() {
		
		int maxLife = 20;
		return maxLife;
	}
}

