package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Radyhm_Key_Obj extends Entity{
	
	GamePanel gp;

	public Radyhm_Key_Obj(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = 9;
		name = "Radyhm Key";
		direction = "down";
		downStand = setup("/objects/Radyhm_Key_Obj", gp.tileSize, gp.tileSize);
		description = name + "\nJust a shiny key";
		price = 75;
		stackable = true;
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "Door");
		
		if(objIndex != 999) {
			gp.ui.currentDialogue = "You used the " + name + ".";
			gp.playSE(3);
			gp.obj[gp.currentMap][objIndex] = null;
			return true;
		}
		
		else {
			gp.ui.currentDialogue = "Huh, didn't you forgot something?";
			return false;
		}
		
	}
}
