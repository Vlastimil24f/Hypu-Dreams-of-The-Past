package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Heart extends Entity{
	
	GamePanel gp;

	public Heart(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = 10;
		value = 2;
		name = "heart";
		downStand = setup("/objects/Heart_Full1", gp.tileSize, gp.tileSize);
		image = setup("/objects/Heart_Full", gp.tileSize, gp.tileSize);
		image2 = setup("/objects/Heart_Half", gp.tileSize, gp.tileSize);
		image3 = setup("/objects/Heart_Empty", gp.tileSize, gp.tileSize);
		
		//ITEM IS PICKABLE
        isPickable = true;
		
	}
	public boolean use(Entity entity) {
		
		entity.life += value;
		gp.playSE(2);
		return true;
	}
}

