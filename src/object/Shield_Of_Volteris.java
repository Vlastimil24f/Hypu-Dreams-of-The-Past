package object;

import entity.Entity;
import main.GamePanel;

public class Shield_Of_Volteris extends Entity{

	public Shield_Of_Volteris(GamePanel gp) {
		super(gp);
		
		type = 8;
		name = "Shield of Volteris";
		direction = "down";
		downStand = setup("/objects/Shield of Volteris", gp.tileSize, gp.tileSize);
		armorValue = 0;
		magicResistValue = 26;
		description = name + "\nHarness the spark, shield \nthe storm";
		price = 250;
		
		//ITEM IS PICKABLE
        isPickable = true;
	}
}
