package object;

import entity.Entity;
import main.GamePanel;

public class Coin extends Entity{
	
	GamePanel gp;
	
	public Coin(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = 10;
		value = 1;
		name = "Coin";
		direction = "down";
		downStand = setup("/objects/Coin", gp.tileSize, gp.tileSize);
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
public boolean use(Entity entity) {

		gp.playSE(18);
		gp.hypu.coin += value;
		return true;
	}	
}
