package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.Blazing_Core;

public class Red_Slime extends Entity{

	GamePanel gp;
	
	public Red_Slime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = 4;
		name = "Red Slime";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 20;
		life = maxLife;
		attack = 5;
		abilityPower = 2;
		armor = 10;
		magicResist = 1;
		exp = 5;
		projectile = new Blazing_Core(gp);
		
		attackDamage = attack;     
		magicDamage = abilityPower;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		up1 = setup("/monsters/redSlime_Walk1", gp.tileSize, gp.tileSize);
		up2 = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
		down1 = setup("/monsters/redSlime_Walk1", gp.tileSize, gp.tileSize);
		down2 = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
		left1 = setup("/monsters/redSlime_Walk1", gp.tileSize, gp.tileSize);
		left2 = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
		right1 = setup("/monsters/redSlime_Walk1", gp.tileSize, gp.tileSize);
		right2 = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
		upStand = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
		downStand = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
		leftStand = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
		rightStand = setup("/monsters/redSlime_Walk2", gp.tileSize, gp.tileSize);
	}
	
	public void update() {
		
		super.update();
		
		int xDistance = Math.abs(worldX - gp.hypu.worldX);
		int yDistance = Math.abs(worldY - gp.hypu.worldY);
		int tileDistance = (xDistance + yDistance)/gp.tileSize;
		
		if (onPath == false && tileDistance < 5) {
			
			int i = new Random().nextInt(100)+1;
			if (i > 50) {
				onPath = true;
			}
		}
		
		if (onPath == true && tileDistance > 20) {
			onPath = false;
		}
	}
	
	public void setAction() {
		
		if (onPath == true) {
    		
    		int goalCol = (gp.hypu.worldX + gp.hypu.solidArea.x)/gp.tileSize;
    		int goalRow = (gp.hypu.worldY + gp.hypu.solidArea.y)/gp.tileSize; 
    		
    		searchPath(goalCol, goalRow);
    		
    		int i = new Random().nextInt(100)+1;
    		if (i > 99 && projectile.alive == false && shotAvailableCounter == 30) {
    			
    			gp.playSE(17);
    			projectile.set(worldX, worldY, direction, true, this);
    			gp.projectileList.add(projectile);
    			shotAvailableCounter = 0;
    			
    		}
    	}
    	else {
    		
    		actionLockCounter++;

            if (actionLockCounter == 200) {
            	
                Random random = new Random();
                int i = random.nextInt(100) + 1;

                if (i <= 25) {
                    direction = "up";
                } 
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100){
                    direction = "right";
                }

                actionLockCounter = 0;
            }	
    	}
	}
	
	public void damageReaction() {
		
		actionLockCounter = 0;
		onPath = true;	
	}
}
