package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class LeftWall_Obj extends Entity{

	public LeftWall_Obj(GamePanel gp) {
		
		super(gp);
		name = "LeftWall";
		direction = "down";
		downStand = setup("/objects/LeftWall_Obj", gp.tileSize, gp.tileSize);
		collision = true;
	    
	}
}

