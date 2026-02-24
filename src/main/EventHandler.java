package main;

import entity.Entity;

public class EventHandler {

	GamePanel gp;
	EventRect eventRect[][][];
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	int tempMap, tempCol, tempRow;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col = 0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 2;
			eventRect[map][col][row].height = 2;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if (col == gp.maxWorldCol) {
				col = 0;
				row++;
				
				if (row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
		}
			
	}
	
	public void checkEvent() {
		
		//CHECK IF THE HYPU IS MORE THAN ONE TILE AWAY FROM THE LAST EVENT
		int xDistance = Math.abs(gp.hypu.worldX - previousEventX);
		int yDistance = Math.abs(gp.hypu.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if (distance > gp.tileSize) {
			canTouchEvent = true;
		}
		if (canTouchEvent == true) {
			
			if (hit(0, 23, 19, "any") == true) {damagePit(gp.dialogueState);}
			else if (hit(0, 27, 16, "right") == true) {portal(gp.dialogueState);}
			else if (hit(0, 23, 12, "up") == true) {healingPool(gp.dialogueState);}
			else if (hit(0, 10, 39, "any") == true) {teleport(1, 12, 11);}
			else if (hit(1, 12, 11, "any") == true) {teleport(0, 10, 39);}
			else if (hit(1, 12, 9, "up") == true) {speak(gp.npc[1][0]);}
			
		}
	}
	
	public boolean hit(int map, int col, int row, String reqDirection) {
		
	    boolean hit = false;
	    
	    if (map == gp.currentMap) {

	    gp.hypu.solidArea.x = gp.hypu.worldX + gp.hypu.solidArea.x;
	    gp.hypu.solidArea.y = gp.hypu.worldY + gp.hypu.solidArea.y;
	    eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
	    eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
	    
	    if (gp.hypu.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
	    	if (gp.hypu.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
	    		hit = true;
	    		
	    		previousEventX = gp.hypu.worldX;
	    		previousEventY = gp.hypu.worldY;
	    	}
	    }
	    
	    gp.hypu.solidArea.x = gp.hypu.solidAreaDefaultX;
	    gp.hypu.solidArea.y = gp.hypu.solidAreaDefaultY;
	    eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
	    eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
	    
	    }
	        
	    return hit;	    
	}
	
	public void portal(int gameState) {
		gp.gameState = gameState;
		gp.playSE(5);
		gp.ui.currentDialogue = "Huh? What just happened?";
		gp.hypu.worldX = gp.tileSize*37;
		gp.hypu.worldY = gp.tileSize*10;
	}
	
	public void teleport(int map, int col, int row) {
		
		gp.gameState = gp.transitionState;
		tempMap = map;
		tempCol = col;
		tempRow = row;
		gp.playSE(5);
		canTouchEvent = false;
	}
	
	public void damagePit(int gameState) {
		
		gp.gameState = gameState;
		gp.ui.currentDialogue = "Does it hurt?";
		gp.hypu.life -=1;
		canTouchEvent = false;	
	}
	
	public void speak(Entity entity) {
		
		if (gp.keyH.XPressed == true) {
			
			gp.gameState = gp.dialogueState;
			entity.speak();
		}	
	}
	
	public void healingPool(int gameState) {
		
	    if (gp.keyH.XPressed == true) {
	        gp.gameState = gameState;
	        gp.ui.currentDialogue = "It tastes very bad, but I think it does \nsomething...";

	        if (gp.hypu.life < gp.hypu.maxLife) {
	            gp.hypu.life += 2;

	            if (gp.hypu.life > gp.hypu.maxLife) {
	                gp.hypu.life = gp.hypu.maxLife;
	                gp.aSetter.setMonster(); //SPAWN MONSTERS
	            }
	        } else {
	            gp.ui.currentDialogue = "Not again...";
	        }
	    }
	}
}

