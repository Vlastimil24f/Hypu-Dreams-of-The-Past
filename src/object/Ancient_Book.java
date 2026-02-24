package object;

import entity.Entity;
import entity.Hypu;
import main.GamePanel;

public class Ancient_Book extends Entity{
	
	GamePanel gp;
	
	public Ancient_Book (GamePanel gp) {
		
		super(gp);
		this.gp = gp;

		type = 9;
		value = 5;
		name = "Ancient Book";
		downStand = setup("/objects/Ancient_Book", gp.tileSize, gp.tileSize);
		description = name + "\nIn the end, we’ll all \nbecome stories";
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
	
	public boolean use(Entity entity) {
		
	    if (entity instanceof Hypu) {
	        Hypu player = (Hypu) entity;
	        player.bonusAbilityPower += value; 
	        player.abilityPower = player.getAP(); 
	        player.magicDamage = player.getMagicDamage();
	    }
	    gp.playSE(20);
	    return true;
	}
}
