package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

	GamePanel gp;
	public boolean moving = false; 
	public boolean isPickable = false; 
	public BufferedImage upStand, downStand, leftStand, rightStand;
	public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
	public BufferedImage image, image2, image3;
	public BufferedImage[] downSprites = new BufferedImage[15];
	public BufferedImage[] upSprites = new BufferedImage[15];
	public BufferedImage[] leftSprites = new BufferedImage[15];
	public BufferedImage[] rightSprites = new BufferedImage[15];
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collision = false;
	String dialogues[] = new String[50];
	
	//STATE
	public int worldX, worldY;
	public String direction = "down";
	public int spriteNum = 1;
	int dialogueIndex = 0;
	public boolean collisionOn = false;
	public boolean invincible = false;
	boolean attacking = false; 
	public boolean alive = true;
	public boolean dying = false;
	boolean hpBarOn = false;
	public boolean onPath = false;
	public boolean knockBack = false;
	
	//COUNTER
	public int spriteCounter = 0;
	public int actionLockCounter = 0;
	public int invincibleCounter = 0;
	public int shotAvailableCounter = 0;
	int dyingCounter = 0;
	int hpBarCounter = 0;
	int knockBackCounter = 0;
	
	//CHARACTER STATUS
	public int type;
	public String name;
	public int defaultSpeed;
	public int speed;
	public int maxLife;
	public int life;
	public int maxMana;
	public int mana;
	public int level;
	public int strength;
	public int defense;
	public int attack;
	public int abilityPower;
	public int armor;
	public int magicResist;
	public int attackDamage;  
	public int magicDamage;
	public int exp;
	public int nextLevelExp;
	public int coin;
	public Entity currentWeapon;
	public Entity currentShield;
	public Entity currentLight;
	public Projectile projectile;
	
	//ITEM STATUS
	public ArrayList<Entity> inventory = new ArrayList<>();
	public final int maxInventorySize = 20;
	public int value;
	public int attackValue;
	public int armorValue;
	public int abilityPowerValue;
	public int magicResistValue;
	public String description = "";
	public int useCost;
	public int price;
	public int knockBackPower = 0;
	public boolean stackable = false;
	public int amount = 1;
	public int lightRadius;
	
	//DAMAGE TYPE
	public boolean affectsAttackDamage = false;  
	public boolean affectsMagicDamage = false;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public int getLeftX() {
		return worldX + solidArea.x;
	}
	
	public int getRightX() {
		return worldX + solidArea.x + solidArea.width;
	}
	
	public int getTopY() {
		return worldY + solidArea.y;
	}
	
	public int getBottomY() {
		return worldY + solidArea.y + solidArea.height;
	}
	
	public int getCol() {
		return (worldX + solidArea.x)/gp.tileSize;
	}
	
	public int getRow() {
		return (worldY + solidArea.y)/gp.tileSize;
	}
	
	public void setAction() {
		
	}
	
	public void damageReaction() {
		
	}
	
	public void speak() {
		
		if (dialogues[dialogueIndex] == null) {
			dialogueIndex = 0;
		}
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		
		switch(gp.hypu.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
	}
	
	public void interact() {
		
	}
	
	public boolean use(Entity entity) {	
		
		return false;	
	}
	
	public void checkDrop() {
		
	}
	
	public void dropItem(Entity droppedItem) {
		
		for (int i = 0; i < gp.obj[1].length; i++) {
			if (gp.obj[gp.currentMap][i] == null) {
				gp.obj[gp.currentMap][i] = droppedItem;
				gp.obj[gp.currentMap][i].worldX = worldX;
				gp.obj[gp.currentMap][i].worldY = worldY;
				break;
			}
		}
	}
	
	public Color getParticleColor() {
		
		Color color = null;
		return color;
	}
	
	public int getParticleSize() {
		
		int size = 0;
		return size;
	}
	
	public int getParticleSpeed() {
		
		int speed = 0;
		return speed;
	}
	
	public int getParticleMaxLife() {
		
		int maxLife = 0;
		return maxLife;
	}
	
	public void generateParticle(Entity generator, Entity target) {
		
		Color color = generator.getParticleColor();
		int size = generator.getParticleSize();
		int speed = generator.getParticleSpeed();
		int maxLife = generator.getParticleMaxLife();
		
		Particle p1 = new Particle(gp, target, color, size, speed, maxLife, -2, -1);
		Particle p2 = new Particle(gp, target, color, size, speed, maxLife, 2, -1);
		Particle p3 = new Particle(gp, target, color, size, speed, maxLife, -2, 1);
		Particle p4 = new Particle(gp, target, color, size, speed, maxLife, 2, 1);
		gp.particleList.add(p1);
		gp.particleList.add(p2);
		gp.particleList.add(p3);
		gp.particleList.add(p4);
	}
	
	public void checkCollision() {
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.monster);
		gp.cChecker.checkEntity(this, gp.iTile);
		boolean contactPlayer  = gp.cChecker.checkPlayer(this);
		
		if (contactPlayer && this.type >= 2 && this.type <= 4) { 
		    
			damagePlayer(abilityPower);
		}	
	}
	
	public void update() {
		
		if (knockBack == true) {
			
			checkCollision();
			
			if (collisionOn == true) {			
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			}
			
			else if (collisionOn == false) {			
				switch(gp.hypu.direction) {
				case "up": worldY -= speed; moving = true; break;
		        case "down": worldY += speed; moving = true; break;
		        case "left": worldX -= speed; moving = true; break;    
		        case "right": worldX += speed; moving = true; break;
				}
			}
			
			knockBackCounter++;
			
			if (knockBackCounter == 5) {
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			}		
		} 
		
		else {
			
			setAction();
			checkCollision();
			
			if (collisionOn == false) {
			    switch(direction) {
			        case "up": worldY -= speed; moving = true; break;
			        case "down": worldY += speed; moving = true; break;
			        case "left": worldX -= speed; moving = true; break;    
			        case "right": worldX += speed; moving = true; break;
			    }
			}
			
			else {
				moving = false;
			}
		}
		
		spriteCounter++;
		
		if (spriteCounter > 12) {
		    spriteNum = (spriteNum == 1) ? 2 : 1;
		    spriteCounter = 0;
		}
		
		if (invincible) {
	        invincibleCounter++;
	        if (invincibleCounter > 25) {
	            invincible = false;
	            invincibleCounter = 0;
	        }
	    }
		
		if (shotAvailableCounter < 30) {
	    	
	    	shotAvailableCounter++;
	    	
	    }
	}
	
	public void damagePlayer(int abilityPower) {
		
		if (!gp.hypu.invincible) {
	        gp.playSE(6);

	        int AD = attackDamage - gp.hypu.armor;
	        int MD = magicDamage - gp.hypu.magicResist;

	        if (this.type == 2) { //PHYSICAL
	            AD = attackDamage - gp.hypu.armor;
	        }

	        if (this.type == 3) { //MAGIC
	            MD = magicDamage - gp.hypu.magicResist;
	        }

	        if (this.type == 4) { //HYBRID
	            AD = attackDamage - gp.hypu.armor;
	            MD = magicDamage - gp.hypu.magicResist;
	        }

	        if (AD < 0) AD = 0;
	        if (MD < 0) MD = 0;

	        gp.hypu.life -= AD;
	        gp.hypu.life -= MD;

	        gp.hypu.invincible = true;

	        //CHECK DAMAGE DEBUG
	        if (AD > 0) {
	            System.out.println("Physical Damage Taken: " + AD);
	        }
	        if (MD > 0) {
	            System.out.println("Magic Damage Taken: " + MD);
	        }
	        
	    }
		
	}
	
	public void draw(Graphics2D g2) {
	    BufferedImage image = null;
	    int screenX = worldX - gp.hypu.worldX + gp.hypu.screenX;
	    int screenY = worldY - gp.hypu.worldY + gp.hypu.screenY;
	    
	    
	    // Determine which image to use based on the entity's state
	    if (!moving) {
	        switch (direction) {
	            case "up": image = upStand; break;
	            case "down": image = downStand; break;
	            case "left": image = leftStand; break;
	            case "right": image = rightStand; break;
	        }
	    } else {
	        switch (direction) {
	            case "up": image = (spriteNum == 1) ? up1 : up2; break;
	            case "down": image = (spriteNum == 1) ? down1 : down2; break;
	            case "left": image = (spriteNum == 1) ? left1 : left2; break;
	            case "right": image = (spriteNum == 1) ? right1 : right2; break;
	        }
	    }
	    
	    //MONSTER HP BAR
	    if (type == 2 && hpBarOn == true) {

	        double oneScale = (double)(gp.tileSize - 16) / maxLife; 
	        double hpBarValue = oneScale * life;

	        g2.setColor(new Color(35, 35, 35));
	        g2.fillRect(screenX + 8, screenY + 9, gp.tileSize - 14, 8);

	        g2.setColor(new Color(255, 0, 30));
	        g2.fillRect(screenX + 9, screenY + 10, (int) hpBarValue, 6);
	        
	        hpBarCounter++;
	        
	        if (hpBarCounter > 300) {
	        	hpBarCounter = 0;
	        	hpBarOn = false;
	        }
	    }
	    
	    if (type == 3 && hpBarOn == true) {

	        double oneScale = (double)(gp.tileSize - 16) / maxLife; 
	        double hpBarValue = oneScale * life;

	        g2.setColor(new Color(35, 35, 35));
	        g2.fillRect(screenX + 8, screenY + 9, gp.tileSize - 14, 8);

	        g2.setColor(new Color(255, 0, 30));
	        g2.fillRect(screenX + 9, screenY + 10, (int) hpBarValue, 6);
	        
	        hpBarCounter++;
	        
	        if (hpBarCounter > 300) {
	        	hpBarCounter = 0;
	        	hpBarOn = false;
	        }
	    }
	    
	    if (type == 4 && hpBarOn == true) {

	        double oneScale = (double)(gp.tileSize - 16) / maxLife; 
	        double hpBarValue = oneScale * life;

	        g2.setColor(new Color(35, 35, 35));
	        g2.fillRect(screenX + 8, screenY + 9, gp.tileSize - 14, 8);

	        g2.setColor(new Color(255, 0, 30));
	        g2.fillRect(screenX + 9, screenY + 10, (int) hpBarValue, 6);
	        
	        hpBarCounter++;
	        
	        if (hpBarCounter > 300) {
	        	hpBarCounter = 0;
	        	hpBarOn = false;
	        }
	    }
	    
	    if (invincible) {
	    	hpBarOn = true;
	    	hpBarCounter = 0;
	    	changeAlpha(g2, 0.4f);
	    }
	    
	    if (dying == true) {
	    	dyingAnimation(g2);
	    }
	    
	    if (image == null) {
	       
	    } else {
	        g2.drawImage(image, screenX, screenY, null);
	        changeAlpha(g2, 1f);
	    }
	}
	
	public void dyingAnimation(Graphics2D g2) {
		
		dyingCounter++;
		
		int i = 5;
		
		if (dyingCounter <= i) { changeAlpha(g2, 0f); }
		if (dyingCounter > i && dyingCounter <= i*2) { changeAlpha(g2, 1f); }
		if (dyingCounter > i*2 && dyingCounter <= i*3) { changeAlpha(g2, 0f); }
		if (dyingCounter > i*3 && dyingCounter <= i*4) { changeAlpha(g2, 1f); }
		if (dyingCounter > i*4 && dyingCounter <= i*5) { changeAlpha(g2, 0f); }
		if (dyingCounter > i*5 && dyingCounter <= i*6) { changeAlpha(g2, 1f); }
		if (dyingCounter > i*6 && dyingCounter <= i*7) { changeAlpha(g2, 0f); }
		if (dyingCounter > i*7 && dyingCounter <= i*8) { changeAlpha(g2, 1f); }
		if (dyingCounter > i*8) {
			alive = false;
		}
	}
	
	public void changeAlpha(Graphics2D g2, float alphaValue) {
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
		
	}
	
	
	public BufferedImage setup(String imagePath, int width, int height) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public void searchPath(int goalCol, int goalRow) {
		
		int startCol = (worldX + solidArea.x)/gp.tileSize;
		int startRow  = (worldY + solidArea.y)/gp.tileSize;
		
		gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow, this);
		
		if (gp.pFinder.search() == true) {
			
			int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
			int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;
			
			int enLeftX = worldX + solidArea.x;
			int enRightX = worldX + solidArea.x + solidArea.width;
			int enTopY = worldY + solidArea.y;
			int enBottomY = worldY + solidArea.y + solidArea.height;
			
			if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
				direction = "up";
			}
			else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
				direction = "down";
			}
			else if (enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
				if (enLeftX > nextX) {
					direction = "left";
				}
				if (enLeftX < nextX) {
					direction = "right";
				}
			}
			else if (enTopY > nextY && enLeftX > nextX) {
				direction = "up";
				checkCollision();
				if (collisionOn == true) {
					direction = "left";
				}
			}
			else if (enTopY > nextY && enLeftX < nextX) {
				direction = "up";
				checkCollision();
				if (collisionOn == true) {
					direction = "right";
				}
			}
			else if (enTopY < nextY && enLeftX > nextX) {
				direction = "down";
				checkCollision();
				if (collisionOn == true) {
					direction = "left";
				}
			}
			else if (enTopY < nextY && enLeftX < nextX) {
				direction = "down";
				checkCollision();
				if (collisionOn == true) {
					direction = "right";
				}
			}
			
			//IF REACHES THE GOAL, STOP THE SEARCH
			//int nextCol = gp.pFinder.pathList.get(0).col;
			//int nextRow = gp.pFinder.pathList.get(0).row;
			//if (nextCol == goalCol && nextRow == goalRow) {
				//onPath = false;
			//}
		}
	}
	
	public int getDetected(Entity user, Entity target[][], String targetName) {
		
		int index = 999;
		
		int nextWorldX = user.getLeftX();
		int nextWorldY = user.getTopY();
		
		switch(user.direction) {
		case "up": nextWorldY = user.getTopY()-1; break;
		case "down": nextWorldY = user.getBottomY()+1; break;
		case "left": nextWorldX = user.getLeftX()-1; break;
		case "right": nextWorldX = user.getRightX()+1; break;
		}
		int col = nextWorldX/gp.tileSize;
		int row = nextWorldY/gp.tileSize;
		
		for (int i = 0; i < target[1].length; i++) {
			if (target[gp.currentMap][i] != null) {
				if (target[gp.currentMap][i].getCol() == col && target[gp.currentMap][i].getRow() == row && target[gp.currentMap][i].name.equals(targetName)) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
}
