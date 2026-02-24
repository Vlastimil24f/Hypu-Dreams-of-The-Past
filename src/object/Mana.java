package object;

import entity.Entity;
import main.GamePanel;

public class Mana extends Entity{
	
	GamePanel gp;

	public Mana(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = 10;
		value = 1;
		name = "Mana";
		downStand = setup("/objects/Mana_Full1", gp.tileSize, gp.tileSize);
		image = setup("/objects/Mana_Full", gp.tileSize, gp.tileSize);
		image2 = setup("/objects/Mana_Empty", gp.tileSize, gp.tileSize);
		
		//ITEM IS PICKABLE
        isPickable = true;
	}
	
	public boolean use(Entity entity) {
		
		entity.mana += value;
		gp.playSE(2);
		return true;
	}
}
