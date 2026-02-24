package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OpChest_Obj extends Entity{
	
	public OpChest_Obj(GamePanel gp) {
		
		super(gp);
		name = "Openned Chest";
		direction = "down";
		downStand = setup("/objects/Secret_Chest_Openned", gp.tileSize, gp.tileSize);
		collision = true;
	}
}