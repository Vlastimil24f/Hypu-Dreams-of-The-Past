package object;

import entity.Entity;
import main.GamePanel;

public class Blade_Of_Emberlight extends Entity{

	public Blade_Of_Emberlight(GamePanel gp) {
		
		super(gp);
		
		type = 6;
		name = "Blade of Emberlight";
		direction = "down";
		downStand = setup("/objects/Blade of Emberlight", gp.tileSize, gp.tileSize);
		attackValue = 7;
		abilityPowerValue = 0;
		attackArea.width = 23;
		attackArea.height = 23;
		knockBackPower = 0;
		price = 150;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
		//DAMAGE TYPE
		affectsAttackDamage = true; 
        affectsMagicDamage = false;  
		
		description = name + "\nI saw a light that makes \na holes into people";
	}
}
