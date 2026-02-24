package object;

import entity.Entity;
import main.GamePanel;

public class Small_Healing_Potion extends Entity{
	
	GamePanel gp;
	
	public Small_Healing_Potion(GamePanel gp) {
		super(gp);
		this.gp = gp;

		type = 9;
		value = 2;
		name = "Small healing potion";
		downStand = setup("/objects/Small_Healing_Potion", gp.tileSize, gp.tileSize);
		description = name + "\nSmall things saves life";
		price = 25;
		stackable = true;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
	public boolean use(Entity entity) {
		
		entity.life += value;
		if (entity.life > entity.maxLife) {
			entity.life = entity.maxLife;
		}
		
		gp.playSE(13);
		return true;
	}	
}
