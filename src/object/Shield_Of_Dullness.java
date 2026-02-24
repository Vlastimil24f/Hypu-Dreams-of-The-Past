package object;

import entity.Entity;
import main.GamePanel;

public class Shield_Of_Dullness extends Entity{

	public Shield_Of_Dullness(GamePanel gp) {
		super(gp);
		
		type = 8;
		name = "Shield of Dullness";
		direction = "down";
		downStand = setup("/objects/Shield of Dullness", gp.tileSize, gp.tileSize);
		armorValue = 2;
		magicResistValue = 1;
		description = name + "\nA shield that protects \ncowardly people";
		price = 5;
	}
}
