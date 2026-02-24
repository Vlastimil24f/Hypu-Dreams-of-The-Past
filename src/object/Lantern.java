package object;

import entity.Entity;
import main.GamePanel;

public class Lantern extends Entity {
	
	public Lantern(GamePanel gp) {
		
		super(gp);
		
		type = 30;
		name = "Lantern";
		downStand = setup("/objects/Lantern4", gp.tileSize, gp.tileSize);
		description = name + "\nWhere light lingers, \nshadows remember";
		price = 150;
		lightRadius = 200;
		
	}
}
