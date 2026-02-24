package tile_interactive;

import main.GamePanel;

public class Grass_Destroyable_Bush extends InteractiveTile{
	
	GamePanel gp;

	public Grass_Destroyable_Bush(GamePanel gp, int col, int row) {
		
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		downStand = setup("/tiles_interactive/Grass_Destroyable_Bush",gp.tileSize, gp.tileSize);
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;

	}

}
