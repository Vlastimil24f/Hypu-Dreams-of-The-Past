package object;

import entity.Entity;
import main.GamePanel;

public class Sword_Of_Dullness extends Entity{

	public Sword_Of_Dullness(GamePanel gp) {
		
		super(gp);
		
		type = 5;
		name = "Blade of Dullness";
		direction = "down";
		downStand = setup("/objects/Blade of Dullness", gp.tileSize, gp.tileSize);
		attackValue = 2;
		abilityPowerValue = 1;
		attackArea.width = 24;
		attackArea.height = 24;
		knockBackPower = 2;
		price = 5;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
		//DAMAGE TYPE
		affectsAttackDamage = true; 
        affectsMagicDamage = true;  
		
		description = name + "\nThis sword was once \nwielded by John Johnson";
	}
}
