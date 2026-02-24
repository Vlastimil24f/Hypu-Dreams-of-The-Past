package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Boots_Obj extends Entity{
	
	public Boots_Obj(GamePanel gp) {
		
		super(gp);
		name = "Boots";
		direction = "down";
		downStand = setup("/objects/Boots_Obj", gp.tileSize, gp.tileSize);
		
		//ITEM IS PICKABLE
        isPickable = true;
		
		description = name + "\nI can feel my legs \nmelting...";
		
	}
}

