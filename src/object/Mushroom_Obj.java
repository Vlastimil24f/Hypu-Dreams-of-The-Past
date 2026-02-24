package object;

import entity.Entity;
import main.GamePanel;

public class Mushroom_Obj extends Entity{
	
	GamePanel gp;
	
	public Mushroom_Obj(GamePanel gp) {
		super(gp);
		this.gp = gp;

		type = 9;
		value = 3;
		name = "Mushroom";
		downStand = setup("/objects/MushroomObj", gp.tileSize, gp.tileSize);
		description = name + "\nJust a mushroom";
		price = 10;
		stackable = true;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
	public boolean use(Entity entity) {
		
		entity.life += value;
		if (entity.life > entity.maxLife) {
			entity.life = entity.maxLife;
		}
		
		gp.playSE(14);
		return true;
	}	
}
