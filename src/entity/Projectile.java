package entity;

import main.GamePanel;
import object.Volteris;

public class Projectile extends Entity{
	
	protected Entity user;

	public Projectile(GamePanel gp) {
		super(gp);
	}
		
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		
		this.worldX = worldX;
		this.worldY = worldY;
		this.direction = direction;
		this.alive = alive;
		this.user= user;
		this.life = this.maxLife;
		int offset = 32;
		
		 switch (direction) {
	        case "up":
	            this.worldY = worldY - offset;
	            upStand = upSprites[0];
	            break;
	        case "down":
	            this.worldY = worldY + offset;
	            downStand = downSprites[0];
	            break;
	        case "left":
	            this.worldX = worldX - offset;
	            leftStand = leftSprites[0];
	            break;
	        case "right":
	            this.worldX = worldX + offset;
	            rightStand = rightSprites[0];
	            break;
	    }
	    this.spriteNum = 0;
	}
	
	@Override
	public void update() {
		
		if (this instanceof Volteris) {
	        int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
	        if (iTileIndex != 999) {
	            gp.hypu.damageInteractiveTile(iTileIndex);
	        }
	    }

		if (user == gp.hypu) {
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			if (monsterIndex != 999) {
				gp.hypu.damageMonster(monsterIndex, abilityPower, knockBackPower);
			}
		}
		
		if (user != gp.hypu) {
			boolean contactPlayer = gp.cChecker.checkPlayer(this);
			if (gp.hypu.invincible == false && contactPlayer == true) {
				damagePlayer(abilityPower);
			}			
		}
		
	    switch (direction) {
	        case "up": worldY -= speed; break;
	        case "down": worldY += speed; break;
	        case "left": worldX -= speed; break;
	        case "right": worldX += speed; break;
	    }

	    life--;
	    if (life <= 0) {
	        alive = false;
	        return;
	    }

	    spriteCounter++;
	    if (spriteCounter > 7) { 
	        spriteNum++; 
	        spriteCounter = 0;

	        if (spriteNum >= 10) { 
	            alive = false;
	            spriteNum = 0; 
	        }

	        switch (direction) {
	            case "up": upStand = upSprites[spriteNum]; break;
	            case "down": downStand = downSprites[spriteNum]; break;
	            case "left": leftStand = leftSprites[spriteNum]; break;
	            case "right": rightStand = rightSprites[spriteNum]; break;
	        }
	    }    
	}
	
	public boolean haveResource(Entity user) {
    	
    	boolean haveResource = false;
    	return haveResource;
    }
	
	public void subtractResource(Entity user) {
		
    }
	
}