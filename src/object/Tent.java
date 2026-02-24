package object;

import entity.Entity;
import main.GamePanel;

public class Tent extends Entity {
	
	GamePanel gp;
	
	public Tent(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = 9;
		name = "Tent";
		downStand = setup("/objects/Tent", gp.tileSize, gp.tileSize);
		description = name + "\nSleep tight.";
		price = 400;	
		stackable = true;
		isPickable = true;
	}
	
	public boolean use(Entity entity) {
		
		gp.gameState = gp.sleepState;
		gp.playSE(26);
		gp.hypu.life = gp.hypu.maxLife;
		gp.hypu.mana = gp.hypu.maxMana;
		gp.hypu.getSleepingImage(downStand);
		return true;
	}
}
