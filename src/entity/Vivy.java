package entity;
import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;

public class Vivy extends Entity {

    public Vivy(GamePanel gp) { 
        super(gp);
        direction = "down";
        speed = 2;
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;
        
        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("/npc/Vivy_Up1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/Vivy_Up2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/Vivy_Down1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/Vivy_Down2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/Vivy_Left1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/Vivy_Left2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/Vivy_Right1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/Vivy_Right2", gp.tileSize, gp.tileSize);
        upStand = setup("/npc/Vivy_Up", gp.tileSize, gp.tileSize);
        downStand = setup("/npc/Vivy_Down", gp.tileSize, gp.tileSize);
        leftStand = setup("/npc/Vivy_Left", gp.tileSize, gp.tileSize);
        rightStand = setup("/npc/Vivy_Right", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0] = "I will go with you, honey.";
        dialogues[1] = "Wait a minute...";
        dialogues[2] = "Aren't you Hypu?";
        dialogues[3] = "I've been here for a while, trying to figure out \nwhat happened... How'd you get here anyway?";
        dialogues[4] = "Lexis is trapped, I honestly don't know what to \ndo... Can you help me?";
    }

    @Override
    public void setAction() {
    	
    	if (onPath == true) {
    		
    		//int goalCol = 11;
    		//int goalRow = 32;   
    		int goalCol = (gp.hypu.worldX + gp.hypu.solidArea.x)/gp.tileSize;
    		int goalRow = (gp.hypu.worldY + gp.hypu.solidArea.y)/gp.tileSize; 
    		
    		searchPath(goalCol, goalRow);
    	}
    	else {
    		
    		actionLockCounter++;

            if (actionLockCounter == 200) {
            	
                Random random = new Random();
                int i = random.nextInt(100) + 1;

                if (i <= 25) {
                    direction = "up";
                } 
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100){
                    direction = "right";
                }

                actionLockCounter = 0;
            }	
    	}
    }
    
    public void speak() {
    	
    	super.speak();	
    	onPath = true;
    }
}

