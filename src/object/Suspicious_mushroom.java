package object;

import entity.Entity;
import main.GamePanel;

public class Suspicious_mushroom extends Entity{
	
	GamePanel gp;
	
	public Suspicious_mushroom(GamePanel gp) {
		super(gp);
		this.gp = gp;

		type = 9;
		value = 4;
		name = "Suspicious mushroom";
		downStand = setup("/objects/Suspicious mushroom", gp.tileSize, gp.tileSize);
		description = name + "\nHmm... Looks kinda sus";
		price = 5;
		stackable = true;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
	
	public boolean use(Entity entity) {
        
        entity.life -= value; 

        if (entity.life < 0) {
            entity.life = 0; 
        }

        gp.playSE(14); 
        return true;
    }   
}
