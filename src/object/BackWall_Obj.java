package object;

import entity.Entity;
import main.GamePanel;

public class BackWall_Obj extends Entity{

	public BackWall_Obj(GamePanel gp) {
		
		super(gp);
		name = "BackWall";
		direction = "down";
		downStand = setup("/objects/BackWall_Obj", gp.tileSize, gp.tileSize);
		collision = true;
		
		solidArea.width = gp.tileSize / 3;    
	    solidArea.height = gp.tileSize / 3;  

	    solidArea.x = gp.tileSize / 5; 
	    solidArea.y = gp.tileSize / 5;  

	    solidAreaDefaultX = solidArea.x;
	    solidAreaDefaultY = solidArea.y;    
		
	}
}
