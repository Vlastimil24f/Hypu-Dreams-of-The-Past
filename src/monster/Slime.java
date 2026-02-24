package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.Coin;
import object.Heart;
import object.Mana;
import object.Small_Healing_Potion;

public class Slime extends Entity{
	
	GamePanel gp;

	public Slime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = 2;
		name = "Green Slime";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 6;
		life = maxLife;
		attack = 3;
		abilityPower = 0;
		armor = 2;
		magicResist = 2;
		exp = 1;
		
		attackDamage = attack; 
	    magicDamage = 0;       
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		up1 = setup("/monsters/slime_Walk1", gp.tileSize, gp.tileSize);
		up2 = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
		down1 = setup("/monsters/slime_Walk1", gp.tileSize, gp.tileSize);
		down2 = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
		left1 = setup("/monsters/slime_Walk1", gp.tileSize, gp.tileSize);
		left2 = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
		right1 = setup("/monsters/slime_Walk1", gp.tileSize, gp.tileSize);
		right2 = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
		upStand = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
		downStand = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
		leftStand = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
		rightStand = setup("/monsters/slime_Walk2", gp.tileSize, gp.tileSize);
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
		if (i < 20) {
			dropItem(new Coin(gp));
		}
		if (i >= 20 && i < 22) {
			dropItem(new Small_Healing_Potion(gp));
		}
		if (i >= 22 && i < 30) {
			dropItem(new Heart(gp));
		}
		if (i >= 30 && i < 40) {
			dropItem(new Mana(gp));
		}
	}
}
