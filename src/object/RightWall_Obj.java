package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class RightWall_Obj extends Entity{
	
	public RightWall_Obj(GamePanel gp) {
		
		super(gp);
		name = "RightWall";
		direction = "down";
		downStand = setup("/objects/RightWall_Obj", gp.tileSize, gp.tileSize);
		collision = true;

	}
}
