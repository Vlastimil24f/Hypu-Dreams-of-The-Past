package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.Blazing_Core;

public class Corefire_Slime extends Entity{

	GamePanel gp;
	
	public Corefire_Slime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = 4;
		name = "Corefire Slime";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 30;
		life = maxLife;
		attack = 5;
		abilityPower = 5;
		armor = 20;
		magicResist = 10;
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
		up1 = setup("/monsters/CorefireSlime_Walk1", gp.tileSize, gp.tileSize);
		up2 = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
		down1 = setup("/monsters/CorefireSlime_Walk1", gp.tileSize, gp.tileSize);
		down2 = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
		left1 = setup("/monsters/CorefireSlime_Walk1", gp.tileSize, gp.tileSize);
		left2 = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
		right1 = setup("/monsters/CorefireSlime_Walk1", gp.tileSize, gp.tileSize);
		right2 = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
		upStand = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
		downStand = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
		leftStand = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
		rightStand = setup("/monsters/CorefireSlime_Walk2", gp.tileSize, gp.tileSize);
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