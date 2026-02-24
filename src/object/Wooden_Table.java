package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Wooden_Table extends Entity{

	public Wooden_Table(GamePanel gp) {
		
		super(gp);
		name = "Door";
		direction = "down";
		downStand = setup("/objects/Wooden_Table", gp.tileSize, gp.tileSize);
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
}
