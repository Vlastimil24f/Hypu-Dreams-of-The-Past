package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Small_Door_Obj extends Entity{
	
	public Small_Door_Obj(GamePanel gp) {
		
		super(gp);
		name = "Small Door";
		direction = "down";
		downStand = setup("/objects/Small_Door_Obj", gp.tileSize, gp.tileSize);
		
	}
}

