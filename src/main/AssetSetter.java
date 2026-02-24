package main;

import entity.Lila;
import entity.Vivy;
import monster.Blue_Slime;
import monster.Corefire_Slime;
import monster.Red_Slime;
import monster.Slime;
import object.Abyss;
import object.Ancient_Book;
import object.BackWall_Obj;
import object.Blade_Of_Emberlight;
import object.Blade_Of_The_Abyss;
import object.Blade_Of_Volteris;
import object.Boots_Obj;
import object.Chest_Obj;
import object.Coin;
import object.Dimensional_Portal;
import object.Door_Obj;
import object.Heart;
import object.Lantern;
import object.LeftWall_Obj;
import object.Mana;
import object.Manashroom;
import object.Mushroom_Obj;
import object.Radyhm_Key_Obj;
import object.RightWall_Obj;
import object.Shield_Of_Impact;
import object.Shield_Of_Volteris;
import object.Small_Door_Obj;
import object.Small_Healing_Potion;
import object.Small_Mana_Potion;
import object.Suspicious_mushroom;
import object.Tent;
import object.Wooden_Table;
import tile_interactive.Destroyable_Bush;
import tile_interactive.Destroyable_Rock;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		
		this.gp = gp;
	}
	
	public void setObject() {
		
		int mapNum = 0;
		int i = 0;
		
		gp.obj[mapNum][i] = new Suspicious_mushroom(gp);
		gp.obj[mapNum][i].worldX = 25 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 41 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Dimensional_Portal(gp);
		gp.obj[mapNum][i].worldX = 27 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Door_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Chest_Obj(gp, new Lantern(gp));
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 9 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Radyhm_Key_Obj(gp);
		gp.obj[mapNum][i].worldX = 34 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 42 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Boots_Obj(gp);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Blade_Of_Emberlight(gp);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Shield_Of_Impact(gp);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Small_Healing_Potion(gp);
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Mushroom_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 30 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Mushroom_Obj(gp);
		gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 33 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Mushroom_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 32 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Blade_Of_Volteris(gp);
		gp.obj[mapNum][i].worldX = 37 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Small_Mana_Potion(gp);
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Manashroom(gp);
		gp.obj[mapNum][i].worldX = 37 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 40 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Ancient_Book(gp);
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Tent(gp);
		gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Shield_Of_Volteris(gp);
		gp.obj[mapNum][i].worldX = 39 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Blade_Of_The_Abyss(gp);
		gp.obj[mapNum][i].worldX = 23 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 23 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Dimensional_Portal(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 39 * gp.tileSize;
		i++;
		
		mapNum = 1;
		gp.obj[mapNum][i] = new Dimensional_Portal(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new Wooden_Table(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new LeftWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new RightWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new BackWall_Obj(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		
	}
	
	public void setNPC() {
		
		int mapNum = 0;
		int i = 0;
		
		// MAP 0
		gp.npc[mapNum][i] = new Vivy(gp);
		gp.npc[mapNum][i].worldX = gp.tileSize*21;
		gp.npc[mapNum][i].worldY = gp.tileSize*21;
		i++;
		
		// MAP 1
		mapNum = 1;
		i = 0;
		gp.npc[mapNum][i] = new Lila(gp);
		gp.npc[mapNum][i].worldX = gp.tileSize*12;
		gp.npc[mapNum][i].worldY = gp.tileSize*7;
		i++;
		
	}
	
	public void setMonster() {
		
		int mapNum = 0;
		int i = 0;
		
		gp.monster[mapNum][i] = new Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*23;
		gp.monster[mapNum][i].worldY = gp.tileSize*36;
		i++;
		
		gp.monster[mapNum][i] = new Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*24;
		gp.monster[mapNum][i].worldY = gp.tileSize*37;
		i++;
		
		gp.monster[mapNum][i] = new Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*25;
		gp.monster[mapNum][i].worldY = gp.tileSize*38;
		i++;
		
		gp.monster[mapNum][i] = new Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*27;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		
		gp.monster[mapNum][i] = new Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*23;
		gp.monster[mapNum][i].worldY = gp.tileSize*40;
		i++;
		
		gp.monster[mapNum][i] = new Blue_Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*37;
		gp.monster[mapNum][i].worldY = gp.tileSize*41;
		i++;
		
		gp.monster[mapNum][i] = new Blue_Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*38;
		gp.monster[mapNum][i].worldY = gp.tileSize*41;
		i++;
		
		gp.monster[mapNum][i] = new Blue_Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*39;
		gp.monster[mapNum][i].worldY = gp.tileSize*41;
		i++;
		
		gp.monster[mapNum][i] = new Red_Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*37;
		gp.monster[mapNum][i].worldY = gp.tileSize*9;
		i++;
		
		gp.monster[mapNum][i] = new Red_Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*38;
		gp.monster[mapNum][i].worldY = gp.tileSize*10;
		i++;
		
		gp.monster[mapNum][i] = new Corefire_Slime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*24;
		gp.monster[mapNum][i].worldY = gp.tileSize*25;
		i++;
	}
	
	public void setInteractiveTile() {
		
		int mapNum = 0;
		int i = 0;
		
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 27, 12); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 28, 12); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 29, 12); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 30, 12); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 31, 12); i++;	
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 32, 12); i++;	
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 33, 12); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 17, 40); i++;	
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 16, 40); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 15, 40); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 14, 40); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 13, 40); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 13, 41); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 12, 41); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 11, 41); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 10, 41); i++;
		gp.iTile[mapNum][i] = new Destroyable_Bush(gp, 10, 40); i++;
		gp.iTile[mapNum][i] = new Destroyable_Rock(gp, 25, 16); i++;
		
	}
}