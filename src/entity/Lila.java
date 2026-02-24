package entity;

import main.GamePanel;
import object.Manashroom;
import object.Mushroom_Obj;
import object.Radyhm_Key_Obj;
import object.Shield_Of_Dullness;
import object.Small_Healing_Potion;
import object.Small_Mana_Potion;
import object.Suspicious_mushroom;
import object.Sword_Of_Dullness;

public class Lila extends Entity {
	
	 public Lila(GamePanel gp) { 
	        super(gp);
	        direction = "down";
	        speed = 0;
	        
	        getImage();
	        setDialogue();
	        setItems();
	        
	    }

	    public void getImage() {
	        up1 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        up2 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        down1 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        down2 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        left1 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        left2 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        right1 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        right2 = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        upStand = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        downStand = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        leftStand = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	        rightStand = setup("/npc/Lila_Down", gp.tileSize, gp.tileSize);
	    }
	    
	    @Override
	    public void setAction() {
	      
	    }

	    public void setDialogue() {
	    	
	        dialogues[0] = "Hmmm... It's not often someone comes here. \nDo you want some... good stuff?";
	    }
	    
	    public void setItems() {
	    	
	    	inventory.add(new Small_Healing_Potion(gp));
	    	inventory.add(new Small_Mana_Potion(gp));
	    	inventory.add(new Mushroom_Obj(gp));
	    	inventory.add(new Manashroom(gp));
	    	inventory.add(new Suspicious_mushroom(gp));
	    	inventory.add(new Radyhm_Key_Obj(gp));
	    	inventory.add(new Sword_Of_Dullness(gp));
	    	inventory.add(new Shield_Of_Dullness(gp));    	
   }
	    
	    public void speak() {
	    	
	    	super.speak();
	    	gp.gameState = gp.tradeState;
	    	gp.ui.npc = this;
	}
}
