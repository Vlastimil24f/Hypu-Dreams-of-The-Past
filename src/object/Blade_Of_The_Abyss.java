package object;

import entity.Entity;
import main.GamePanel;

public class Blade_Of_The_Abyss extends Entity{

	public Blade_Of_The_Abyss(GamePanel gp) {
		
		super(gp);
		
		type = 5;
		name = "Blade of the Abyss";
		direction = "down";
		downStand = setup("/objects/Blade of the Abyss", gp.tileSize, gp.tileSize);
		attackValue = 10;
		abilityPowerValue = 10;
		attackArea.width = 22;
		attackArea.height = 22;
		knockBackPower = 1;
		price = 999;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
		//DAMAGE TYPE
		affectsAttackDamage = true; 
        affectsMagicDamage = true;  
		
		description = name + "\nFrom the Abyss, I rise; \nto the Abyss, all return.";	
	}
}
