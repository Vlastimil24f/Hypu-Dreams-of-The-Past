package object;

import entity.Entity;
import main.GamePanel;

public class Manashroom extends Entity{
	
	GamePanel gp;
	
	public Manashroom(GamePanel gp) {
		super(gp);
		this.gp = gp;

		type = 9;
		value = 3;
		name = "Manashroom";
		downStand = setup("/objects/Manashroom", gp.tileSize, gp.tileSize);
		description = name + "\nNot just a mushroom";
		price = 15;
		stackable = true;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}

	public boolean use(Entity entity) {
	
	entity.mana += value;
	if (entity.mana > entity.maxMana) {
		entity.mana = entity.maxMana;
	}
	
	gp.playSE(14);
	return true;
	
	}	
}
