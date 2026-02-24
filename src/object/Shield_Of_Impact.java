package object;

import entity.Entity;
import main.GamePanel;

public class Shield_Of_Impact extends Entity{

	public Shield_Of_Impact(GamePanel gp) {
		super(gp);
		
		type = 8;
		name = "Shield of Impact";
		direction = "down";
		downStand = setup("/objects/Shield of Impact", gp.tileSize, gp.tileSize);
		armorValue = 999;
		magicResistValue = 999;
		description = name + "\n???";
		price = 1;
		
		//ITEM IS PICKABLE
        isPickable = true;
	}
}
