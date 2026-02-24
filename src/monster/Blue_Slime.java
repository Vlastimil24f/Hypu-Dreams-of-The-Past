package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.Coin;
import object.Heart;
import object.Mana;
import object.Manashroom;
import object.Small_Mana_Potion;

public class Blue_Slime extends Entity{

	GamePanel gp;
	
	public Blue_Slime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = 3;
		name = "Blue Slime";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 6;
		life = maxLife;
		attack = 0;
		abilityPower = 4;
		armor = 6;
		magicResist = 4;
		exp = 2;
		
		attackDamage = 0; 
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
		up1 = setup("/monsters/blueSlime_Walk1", gp.tileSize, gp.tileSize);
		up2 = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
		down1 = setup("/monsters/blueSlime_Walk1", gp.tileSize, gp.tileSize);
		down2 = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
		left1 = setup("/monsters/blueSlime_Walk1", gp.tileSize, gp.tileSize);
		left2 = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
		right1 = setup("/monsters/blueSlime_Walk1", gp.tileSize, gp.tileSize);
		right2 = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
		upStand = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
		downStand = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
		leftStand = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
		rightStand = setup("/monsters/blueSlime_Walk2", gp.tileSize, gp.tileSize);
	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		if (actionLockCounter == 180) {
			
			Random random = new Random();
			int i = random.nextInt(100)+1;
			
			if (i <= 25) {
				direction = "up";
			}
			
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			
			if (i > 75 && i <= 100) {
				direction = "right";
			}	
			
			actionLockCounter = 0;
		}
		
	}
	
	public void damageReaction() {
		
		actionLockCounter = 0;
		direction = gp.hypu.direction;
		
	}
	
public void checkDrop() {
		
		int i = new Random().nextInt(100)+1;
		
		//SET THE MONSTER DROP
		if (i < 25) {
			dropItem(new Coin(gp));
		}
		if (i >= 25 && i < 30) {
			dropItem(new Manashroom(gp));
		}
		if (i >= 30 && i < 40) {
			dropItem(new Small_Mana_Potion(gp));
		}
	}
}

