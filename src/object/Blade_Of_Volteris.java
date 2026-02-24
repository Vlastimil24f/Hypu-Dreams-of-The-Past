package object;

import entity.Entity;
import main.GamePanel;

public class Blade_Of_Volteris extends Entity{

	public Blade_Of_Volteris(GamePanel gp) {
		
		super(gp);
		
		type = 7;
		name = "Blade of Volteris";
		direction = "down";
		downStand = setup("/objects/Blade of Volteris", gp.tileSize, gp.tileSize);
		attackValue = 0;
		abilityPowerValue = 20;
		attackArea.width = 26;
		attackArea.height = 26;
		knockBackPower = 4;
		price = 400;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
		//DAMAGE TYPE
		affectsAttackDamage = false; 
        affectsMagicDamage = true;  
		
		description = name + "\nElectricity dances where \nchaos meets control";		
	}
}
