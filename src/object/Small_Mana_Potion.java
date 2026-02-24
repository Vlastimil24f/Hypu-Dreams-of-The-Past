package object;

import entity.Entity;
import main.GamePanel;

public class Small_Mana_Potion extends Entity{
	
	GamePanel gp;
	
	public Small_Mana_Potion(GamePanel gp) {
		super(gp);
		this.gp = gp;

		type = 9;
		value = 3;
		name = "Small mana potion";
		downStand = setup("/objects/Small_Mana_Potion", gp.tileSize, gp.tileSize);
		description = name + "\nSmall things saves time";
		price = 25;
		stackable = true;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
	public boolean use(Entity entity) {
		
		entity.mana += value;
		if (entity.mana > entity.maxMana) {
			entity.mana = entity.maxMana;
		}
		
		gp.playSE(13);
		return true;
	}	
}
