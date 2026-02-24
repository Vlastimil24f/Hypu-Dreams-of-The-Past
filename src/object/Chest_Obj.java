package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Chest_Obj extends Entity{
	
	GamePanel gp;
	Entity loot;
	boolean opened = false;
	
	public Chest_Obj(GamePanel gp, Entity loot) {
		
		super(gp);
		this.gp = gp;
		this.loot = loot;
		
		type = 15;
		name = "Chest";
		direction = "down";
		image = setup("/objects/Secret_Chest_Closed", gp.tileSize, gp.tileSize);
		image2 =  setup("/objects/Secret_Chest_Openned", gp.tileSize, gp.tileSize);
		downStand = image;
		collision = true;
		
		solidArea.x = 4;
		solidArea.y = 16;
		solidArea.width = 40;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	public void interact() {
		
		gp.gameState = gp.dialogueState;
		
		if (opened == false) {
			gp.playSE(4);
			
			StringBuilder sb = new StringBuilder();
			
			if (gp.hypu.canObtainItem(loot) == false) {
				sb.append("You are full, aren't you?");
			}
			else {
				sb.append("You obtained the " + loot.name + "!");
				downStand = image2;
				opened = true;
			}
			gp.ui.currentDialogue = sb.toString();
		}
		else  {
			gp.ui.currentDialogue = "Don't be greedy, it's already empty...";
		}
	}
}
