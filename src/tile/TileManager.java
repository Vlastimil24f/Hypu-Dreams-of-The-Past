package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][];
    boolean drawPath = false;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[70];
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow]; 
        

        getTileImage();
        loadMap("/maps/W3.txt", 0);
        loadMap("/maps/Merchant.txt", 1);
    }

    public void getTileImage() {
    	
    		//PLACEHOLDER
            setup(0, "Grass", false);
            setup(1, "Grass", false);
            setup(2, "Grass", false);
            setup(3, "Grass", false);
            setup(4, "Grass", false);
            setup(5, "Grass", false);
            setup(6, "Grass", false);
            setup(7, "Grass", false);
            setup(8, "Grass", false);
            setup(9, "Grass", false);
            
            //SURFACE
            setup(10, "Grass", false);
            setup(11, "Dark_Grass", false);
            setup(12, "Light_Grass", false);
            setup(13, "Blue_Mushroom", false);
            setup(14, "Red_Roses", false);
            setup(15, "Pink_Roses", false);
            setup(16, "White_Grass_Flowers", false);
            setup(17, "White_Pixie_Bloom", true);
            setup(18, "Blue_Mushrooms", true);  
            setup(19, "Bush", true);
            setup(20, "Cherry_Bush", true);
            setup(21, "Up_Shore", true);
            setup(22, "Down_Shore", true);
            setup(23, "Left_Shore", true);
            setup(24, "Right_Shore", true);
            setup(25, "Up_Left_Shore", true);
            setup(26, "Up_Right_Shore", true);
            setup(27, "Down_Left_Shore", true);
            setup(28, "Down_Right_Shore", true);
            setup(29, "Stone", false);
            setup(30, "FrontWall", true);  
            
            //WATER
            setup(31, "Water", true);
            setup(32, "MiniIsland", false);
            setup(33, "WaterWeed", true);
            setup(34, "StoneWater", true);
            setup(35, "Frog", true);
            setup(36, "Up_Right_Edge", true); 
            setup(37, "Up_Left_Edge", true); 
            setup(38, "Down_Left_Edge", true);
            setup(39, "Down_Right_Edge", true);
            
            //MORE
            setup(40, "Full_Wooden_Bucket", false);
            setup(41, "Sign", true);
            
            //ROAD
            setup(50, "Road", false);
            setup(51, "Road_Up", false);
            setup(52, "Road_Down", false);
            setup(53, "Road_Left", false);
            setup(54, "Road_Right", false);
            setup(55, "Road_Up_Left", false);
            setup(56, "Road_Up_Right", false);
            setup(57, "Road_Down_Left", false);
            setup(58, "Road_Down_Right", false);
            
            //HOUSE
            setup(62, "Wooden_Floor", false);
            
            //VOID
            setup(69, "Void", true);
            
    	}
    
    public void setup(int index, String imageName, boolean collision) {
    	
    	UtilityTool uTool = new UtilityTool();
    	
    	try {
    		tile[index] = new Tile();
    		tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
    		tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
    		tile[index].collision = collision;
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void loadMap(String filePath, int map) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col, row = 0;

            String line;
            while (row < gp.maxWorldRow && (line = br.readLine()) != null) {  
                String[] numbers = line.split(" ");
                col = 0; 

                while (col < gp.maxWorldCol && col < numbers.length) { 
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[map][col][row] = num;
                    col++;
                }

                row++; 
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2) {
    	
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.hypu.worldX + gp.hypu.screenX;
            int screenY = worldY - gp.hypu.worldY + gp.hypu.screenY;

            if (worldX + gp.tileSize > gp.hypu.worldX - gp.hypu.screenX - gp.tileSize && 
                worldX - gp.tileSize < gp.hypu.worldX + gp.hypu.screenX + gp.tileSize && 
                worldY + gp.tileSize > gp.hypu.worldY - gp.hypu.screenY - gp.tileSize && 
                worldY - gp.tileSize < gp.hypu.worldY + gp.hypu.screenY + gp.tileSize) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
        
        if (drawPath == true) {
        	g2.setColor(new Color(255, 0, 0, 70));
        	
        	for (int i = 0; i < gp.pFinder.pathList.size(); i++) {
        		
        		int worldX = gp.pFinder.pathList.get(i).col * gp.tileSize;
                int worldY =  gp.pFinder.pathList.get(i).row * gp.tileSize;
                int screenX = worldX - gp.hypu.worldX + gp.hypu.screenX;
                int screenY = worldY - gp.hypu.worldY + gp.hypu.screenY;
                
                g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
        	}
        }
    }
}

