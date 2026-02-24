package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Door_Obj extends Entity{
	
	GamePanel gp;

	public Door_Obj(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = 15;
		name = "Door";
		downStand = setup("/objects/Door", gp.tileSize, gp.tileSize);
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}
	public void interact() {
		
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "You need a key to open this. :3";
	}
}
