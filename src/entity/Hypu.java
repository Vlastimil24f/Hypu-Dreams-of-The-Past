package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.Abyss;
import object.Blade_Of_The_Abyss;
import object.Blade_Of_Volteris;
import object.OpChest_Obj;
import object.Radyhm_Key_Obj;
import object.Shield_Of_Dullness;
import object.Sword_Of_Dullness;
import object.Volteris;

public class Hypu extends Entity{
	
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	public int bonusAbilityPower = 0;
	private boolean soundPlayed = false;
	private boolean isProjectileAction = false;
	public boolean lightUpdated = false;
	
	BufferedImage upStand, downStand, leftStand, rightStand;
	
	public Hypu(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		//SOLID AREA
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		//ATTACK AREA
		//attackArea.width = 36;
		//attackArea.height = 36;
		
		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
		setItems();
		
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		
		//worldX = gp.tileSize * 12;
		//worldY = gp.tileSize * 10;
		
		defaultSpeed = 4;
		speed = defaultSpeed;
		direction = "down";
		
		//PLAYER STATUS
		level = 1;
		maxLife = 6;
		life = maxLife;
		maxMana = 3;
		mana = maxMana;
		strength = 1;
		defense = 1;
		exp = 0;
		nextLevelExp = 5;
		coin = 150;
		currentWeapon = new Sword_Of_Dullness(gp);
		currentShield = new Shield_Of_Dullness(gp);
		projectile = new Volteris(gp);
		projectile = new Abyss(gp);
		attack = getAttack();
		abilityPower = getAP();
		armor = getArmor();
		magicResist = getMR();
		
		//TYPES OF DAMAGE
		attackDamage = getAttackDamage();
	    magicDamage = getMagicDamage();
	}
	
	public void setDefaultPositions() {
		
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		direction = "down";
	}
	
	public void restoreLifeAndMana() {
		
		life = maxLife;
		mana = maxMana;
		invincible = false;
	}
	
	public void setItems() {
		
		inventory.clear();
		inventory.add(currentWeapon);
		inventory.add(currentShield);
		inventory.add(new Radyhm_Key_Obj(gp));	
	}
	
	public int getAttack() {
		attackArea = currentWeapon.attackArea;
		return attack = strength * currentWeapon.attackValue;
	}
	
	public int getArmor() {
		return armor = defense * currentShield.armorValue;
	}
	
	public int getAP() {
		return (strength * currentWeapon.abilityPowerValue) + bonusAbilityPower;
	}
	
	public int getMR() {
		return magicResist = defense * currentShield.magicResistValue;
	}
	
	public int getAttackDamage() {
	    if (currentWeapon.affectsAttackDamage) {
	    	int flatBonus = level;
	    	int percentBonus = (int)(attack * (0.05 * level));
	        return attack + flatBonus + percentBonus;
	    }
	    return 0;
	}

	public int getMagicDamage() {
	    if (currentWeapon.affectsMagicDamage) {
	    	int flatBonus = level + 1; 
	        int percentBonus = (int)(abilityPower * (0.10 * level)); 
	        return abilityPower + flatBonus + percentBonus;
	    }
	    return 0;
	}

	public void getPlayerImage() {
		
		up1 = setup("/hypu/Up1", gp.tileSize, gp.tileSize);
		up2 = setup("/hypu/Up2", gp.tileSize, gp.tileSize);
		up3 = setup("/hypu/Up3", gp.tileSize, gp.tileSize);
		down1 = setup("/hypu/Down1", gp.tileSize, gp.tileSize);
		down2 = setup("/hypu/Down2", gp.tileSize, gp.tileSize);
		down3 = setup("/hypu/Down3", gp.tileSize, gp.tileSize);
		left1 = setup("/hypu/Left1", gp.tileSize, gp.tileSize);
		left2 = setup("/hypu/Left2", gp.tileSize, gp.tileSize);
		left3 = setup("/hypu/Left3", gp.tileSize, gp.tileSize);
		right1 = setup("/hypu/Right1", gp.tileSize, gp.tileSize);
		right2 = setup("/hypu/Right2", gp.tileSize, gp.tileSize);
		right3 = setup("/hypu/Right3", gp.tileSize, gp.tileSize);
		upStand = setup("/hypu/Up", gp.tileSize, gp.tileSize);
		downStand = setup("/hypu/Down", gp.tileSize, gp.tileSize);
		leftStand = setup("/hypu/Left", gp.tileSize, gp.tileSize);
		rightStand = setup("/hypu/Right", gp.tileSize, gp.tileSize);
	}
	
	public void getSleepingImage(BufferedImage image) {
		
		up1 = image;
		up2 = image;
		up3 = image;
		down1 = image;
		down2 = image;
		down3 = image;
		left1 = image;
		left2 = image;
		left3 = image;
		right1 = image;
		right2 = image;
		right3 = image;
		upStand = image;
		downStand = image;
		leftStand = image;
		rightStand = image;
	}
	
	public void getPlayerAttackImage() {
		
		if (currentWeapon.type == 5) {
			if (currentWeapon.name.equals("Blade of Dullness")) {
			attackUp1 = setup("/hypu/Hypu_Attack_Up1", gp.tileSize, gp.tileSize*2);
			attackUp2 = setup("/hypu/Hypu_Attack_Up2", gp.tileSize, gp.tileSize*2);
			attackDown1 = setup("/hypu/Hypu_Attack_Down1", gp.tileSize, gp.tileSize*2);
			attackDown2 = setup("/hypu/Hypu_Attack_Down2", gp.tileSize, gp.tileSize*2);
			attackLeft1 = setup("/hypu/Hypu_Attack_Left1", gp.tileSize*2, gp.tileSize);
			attackLeft2 = setup("/hypu/Hypu_Attack_Left2", gp.tileSize*2, gp.tileSize);
			attackRight1 = setup("/hypu/Hypu_Attack_Right1", gp.tileSize*2, gp.tileSize);
			attackRight2 = setup("/hypu/Hypu_Attack_Right2", gp.tileSize*2, gp.tileSize);
			}
			else if (currentWeapon.name.equals("Blade of the Abyss")) {
	        attackUp1 = setup("/hypu/Hypu_Attack_Up1_Abyss", gp.tileSize, gp.tileSize*2);
	        attackUp2 = setup("/hypu/Hypu_Attack_Up2_Abyss", gp.tileSize, gp.tileSize*2);
	        attackDown1 = setup("/hypu/Hypu_Attack_Down1_Abyss", gp.tileSize, gp.tileSize*2);
	        attackDown2 = setup("/hypu/Hypu_Attack_Down2_Abyss", gp.tileSize, gp.tileSize*2);
	        attackLeft1 = setup("/hypu/Hypu_Attack_Left1_Abyss", gp.tileSize*2, gp.tileSize);
	        attackLeft2 = setup("/hypu/Hypu_Attack_Left2_Abyss", gp.tileSize*2, gp.tileSize);
	        attackRight1 = setup("/hypu/Hypu_Attack_Right1_Abyss", gp.tileSize*2, gp.tileSize);
	        attackRight2 = setup("/hypu/Hypu_Attack_Right2_Abyss", gp.tileSize*2, gp.tileSize);
	        }
		}
		
		if (currentWeapon.type == 6) {
			attackUp1 = setup("/hypu/Hypu_Attack_Up1_Emberlight", gp.tileSize, gp.tileSize*2);
			attackUp2 = setup("/hypu/Hypu_Attack_Up2_Emberlight", gp.tileSize, gp.tileSize*2);
			attackDown1 = setup("/hypu/Hypu_Attack_Down1_Emberlight", gp.tileSize, gp.tileSize*2);
			attackDown2 = setup("/hypu/Hypu_Attack_Down2_Emberlight", gp.tileSize, gp.tileSize*2);
			attackLeft1 = setup("/hypu/Hypu_Attack_Left1_Emberlight", gp.tileSize*2, gp.tileSize);
			attackLeft2 = setup("/hypu/Hypu_Attack_Left2_Emberlight", gp.tileSize*2, gp.tileSize);
			attackRight1 = setup("/hypu/Hypu_Attack_Right1_Emberlight", gp.tileSize*2, gp.tileSize);
			attackRight2 = setup("/hypu/Hypu_Attack_Right2_Emberlight", gp.tileSize*2, gp.tileSize);
		}
		
		if (currentWeapon.type == 7) {
			attackUp1 = setup("/hypu/Hypu_Attack_Up1_Volteris", gp.tileSize, gp.tileSize*2);
			attackUp2 = setup("/hypu/Hypu_Attack_Up2_Volteris", gp.tileSize, gp.tileSize*2);
			attackDown1 = setup("/hypu/Hypu_Attack_Down1_Volteris", gp.tileSize, gp.tileSize*2);
			attackDown2 = setup("/hypu/Hypu_Attack_Down2_Volteris", gp.tileSize, gp.tileSize*2);
			attackLeft1 = setup("/hypu/Hypu_Attack_Left1_Volteris", gp.tileSize*2, gp.tileSize);
			attackLeft2 = setup("/hypu/Hypu_Attack_Left2_Volteris", gp.tileSize*2, gp.tileSize);
			attackRight1 = setup("/hypu/Hypu_Attack_Right1_Volteris", gp.tileSize*2, gp.tileSize);
			attackRight2 = setup("/hypu/Hypu_Attack_Right2_Volteris", gp.tileSize*2, gp.tileSize);
		}
		
	}
	
	public void update() {

		if (gp.keyH.XPressed) { 
	        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
	        if (npcIndex != 999) { 
	            interactNPC(npcIndex);
	        } else {

	            int objIndex = gp.cChecker.checkObject(this, true); 
	            if (objIndex != 999) {
	                Entity obj = gp.obj[gp.currentMap][objIndex];
	                obj.interact(); 
	            } else {
	                gp.eHandler.checkEvent();
	            }
	        }
	        gp.keyH.XPressed = false; 
	    }

	    if (gp.keyH.QPressed && !attacking) { 
	        attacking = true;
	        spriteCounter = 0;
	        gp.keyH.QPressed = false; 
	        if (currentWeapon instanceof Blade_Of_Volteris) {
	        
	        }
	    }
	    
	    if (!attacking) {
	        movePlayer();
	    } else {
	        attacking();
	    }
	    
	    if (gp.keyH.shotKeyPressed && !attacking && currentWeapon != null && !projectile.alive 
	    	    && shotAvailableCounter == 30 && projectile.haveResource(this)) {

	    	    if (currentWeapon instanceof Blade_Of_The_Abyss || currentWeapon instanceof Blade_Of_Volteris) {
	    	        isProjectileAction = true; 
	    	        attacking = true;
	    	        spriteCounter = 0;

	    	        if (currentWeapon instanceof Blade_Of_The_Abyss) {
	    	            projectile = new Abyss(gp);
	    	            gp.playSE(23); 
	    	        } else if (currentWeapon instanceof Blade_Of_Volteris) {
	    	            projectile = new Volteris(gp);
	    	            gp.playSE(16); 
	    	        }

	    	        projectile.set(worldX, worldY, direction, true, this);
	    	        projectile.subtractResource(this);
	    	        gp.projectileList.add(projectile);

	    	        shotAvailableCounter = 0;
	    	    }
	    	}

	    if (invincible) {
	        invincibleCounter++;
	        if (invincibleCounter > 30) {
	            invincible = false;
	            invincibleCounter = 0;
	        }
	    }

	    if (shotAvailableCounter < 30) {
	        shotAvailableCounter++;
	    } 
	    
	    if (life > maxLife) {
			life = maxLife;
		}
	    
	    if (mana > maxMana) {
			mana = maxMana;
		}
	    
	    if (life <= 0) {
	    	gp.gameState = gp.gameOverState;
	    	gp.ui.commandNum = -1;
	    	gp.stopMusic();
	    	gp.playSE(22);
	    }
	}
		
		public void attacking() {
		    
			    if (!soundPlayed && !isProjectileAction) { 
			        if (currentWeapon.type == 6) {
			            gp.playSE(12); 
			        } else if (currentWeapon.type == 7) {
			            gp.playSE(15); 
			        } else if (currentWeapon.type == 5 && currentWeapon.name.equals("Blade of the Abyss")) {
			            gp.playSE(23); 
			        } else {
			            gp.playSE(8); 
			        }
			        soundPlayed = true; 
			    }

			    spriteCounter++;

			    if (spriteCounter <= 5) {
			        spriteNum = 1;
			    } else if (spriteCounter > 5 && spriteCounter <= 25) {
			        spriteNum = 2;
		        
		        int currentWorldX = worldX;
		        int currentWorldY = worldY;
		        int solidAreaWidth = solidArea.width;
		        int solidAreaHeight = solidArea.height;
		        
		        switch(direction) {
		            case "up": worldY -= attackArea.height; break;
		            case "down": worldY += attackArea.height; break;
		            case "left": worldX -= attackArea.width; break;
		            case "right": worldX += attackArea.width; break;
		        }
		        
		        solidArea.width = attackArea.width;
		        solidArea.height = attackArea.height;
		        
		        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		        damageMonster(monsterIndex, abilityPower, currentWeapon.knockBackPower);
		        
		        int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
		        damageInteractiveTile(iTileIndex);
		        
		        worldX = currentWorldX;
		        worldY = currentWorldY;
		        solidArea.width = solidAreaWidth;
		        solidArea.height = solidAreaHeight;
		        
			    } else if (spriteCounter > 25) {
			        spriteNum = 1;
			        spriteCounter = 0;
			        attacking = false; 
			        soundPlayed = false; 
			        isProjectileAction = false; 
			    }
			}

		public void movePlayer() {
		    if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

		        if (keyH.upPressed) direction = "up";
		        else if (keyH.downPressed) direction = "down";
		        else if (keyH.leftPressed) direction = "left";
		        else if (keyH.rightPressed) direction = "right";

		        //CHECK COLLISION
		        
		        collisionOn = false;
		        gp.cChecker.checkTile(this);

		        int objIndex = gp.cChecker.checkObject(this, true);
		        pickUpObject(objIndex);

		        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
		        if (npcIndex != 999) {
		        }

		        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		        contactMonster(monsterIndex);
		        
		        int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);

		        gp.eHandler.checkEvent();

		        if (!collisionOn) {
		            switch(direction) {
		                case "up": worldY -= speed; break;
		                case "down": worldY += speed; break;
		                case "left": worldX -= speed; break;
		                case "right": worldX += speed; break;
		            }
		        }

		        spriteCounter++;
		        if (spriteCounter > 12) {
		            spriteNum = (spriteNum == 1) ? 2 : 1;
		            spriteCounter = 0;
		        }
		    }
		}
	
		public void pickUpObject(int index) {

		    if (index < 0 || index >= gp.obj[1].length || index == 999) {
		        return;
		    }

		    Entity obj = gp.obj[gp.currentMap][index];
		    
		    if (obj == null) return;
		    
		    if (gp.obj[gp.currentMap][index].type == 15) { 
		        if (keyH.XPressed == true) {
		            System.out.println("Interacting with door...");
		            gp.obj[gp.currentMap][index].interact(); 
		            keyH.XPressed = false; 
		        }
		    }

		    if (obj.isPickable) {
		        if (obj.type == 10) { 
		            if ("Coin".equals(obj.name)) {
		                obj.use(this);
		                gp.obj[gp.currentMap][index] = null;
		                gp.playSE(18);
		            } else {
		                obj.use(this);
		                gp.obj[gp.currentMap][index] = null;
		                gp.playSE(2);
		            }
		        }
		        
		        // (inventory.size() < maxInventorySize)
		        
		        else if (canObtainItem(gp.obj[gp.currentMap][index]) == true) {
		            //inventory.add(obj);
		            gp.obj[gp.currentMap][index] = null;
		            gp.playSE(2);
		        }
		    }
		}
	
	public void checkInteraction() {
		
	    int interactionDistance = gp.tileSize / 2;  
	    
	    int targetX = worldX;
	    int targetY = worldY;

	    switch (direction) {
	        case "up":    targetY -= interactionDistance; break;
	        case "down":  targetY += interactionDistance; break;
	        case "left":  targetX -= interactionDistance; break;
	        case "right": targetX += interactionDistance; break;
	    }

	    for (int i = 0; i < gp.npc.length; i++) {
	        if (gp.npc[i] != null) {
	            int npcLeft = gp.npc[gp.currentMap][i].worldX;
	            int npcRight = gp.npc[gp.currentMap][i].worldX + gp.tileSize;
	            int npcTop = gp.npc[gp.currentMap][i].worldY;
	            int npcBottom = gp.npc[gp.currentMap][i].worldY + gp.tileSize;

	            if (targetX < npcRight && targetX + gp.tileSize > npcLeft &&
	                targetY < npcBottom && targetY + gp.tileSize > npcTop) {
	                interactNPC(i);
	                break;
	            }
	        }
	    }
	}

	public void interactNPC(int i) {
		
		if(gp.keyH.XPressed == true) {
			
			if (i != 999) {
				gp.gameState = gp.dialogueState;
				gp.npc[gp.currentMap][i].speak();
		    }
		    else {
		    	attacking = true;
		    }
		}
	}
	
	public void contactMonster(int i) {
	    if (i != 999) {
	        if (!invincible && gp.monster[gp.currentMap][i].dying == false) {
	            gp.playSE(6);

	            int physicalDamage = gp.monster[gp.currentMap][i].attackDamage - armor;
	            if (physicalDamage < 0) physicalDamage = 0;

	            int magicalDamage = gp.monster[gp.currentMap][i].magicDamage - magicResist;
	            if (magicalDamage < 0) magicalDamage = 0;

	            life -= physicalDamage;
	            life -= magicalDamage;

	            //System.out.println("Player took Physical Damage from Monster: " + physicalDamage);
	            //System.out.println("Player took Magic Damage from Monster: " + magicalDamage);

	            invincible = true;
	        }
	    }
	}


	public void damageMonster(int i, int abilityPower, int knockBackPower) {
	    if (i != 999) {
	        if (!gp.monster[gp.currentMap][i].invincible) {
	        	
	            gp.playSE(9);
	            
	            if (knockBackPower > 0) {
	            	
	            	 knockBack(gp.monster[gp.currentMap][i], knockBackPower);
	            }

	            int physicalDamage = attackDamage - gp.monster[gp.currentMap][i].armor;
	            if (physicalDamage < 0) physicalDamage = 0;

	            int magicalDamage = magicDamage - gp.monster[gp.currentMap][i].magicResist;
	            if (magicalDamage < 0) magicalDamage = 0;

	            gp.monster[gp.currentMap][i].life -= physicalDamage;
	            gp.monster[gp.currentMap][i].life -= magicalDamage;

	            System.out.println("Dealt Physical Damage to Monster: " + physicalDamage);
	            System.out.println("Dealt Magic Damage to Monster: " + magicalDamage);

	            gp.monster[gp.currentMap][i].invincible = true;
	            gp.monster[gp.currentMap][i].damageReaction();

	            if (gp.monster[gp.currentMap][i].life <= 0) {
	                gp.monster[gp.currentMap][i].dying = true;
	                exp += gp.monster[gp.currentMap][i].exp;
	                checkLevelUp();
	            }
	        }
	    }
	}
	
	public void knockBack(Entity entity, int knockBackPower) {
		
		entity.direction = direction;
		entity.speed += knockBackPower;
		entity.knockBack = true;
		
	}
	
	public void damageInteractiveTile(int i) {
		
		if (i != 999 && gp.iTile[gp.currentMap][i].destructible == true && gp.iTile[gp.currentMap][i].isCorrectItem(this) == true && gp.iTile[gp.currentMap][i].invincible == false) {
			
			gp.iTile[gp.currentMap][i].playSE();
			gp.iTile[gp.currentMap][i].life--;
			gp.iTile[gp.currentMap][i].invincible = true;
			
			//GENERATE PARTICLES
			generateParticle(gp.iTile[gp.currentMap][i], gp.iTile[gp.currentMap][i]);
			
			if (gp.iTile[gp.currentMap][i].life == 0) {
				gp.iTile[gp.currentMap][i] = gp.iTile[gp.currentMap][i].getDestroyedForm();
			}	
		}		
	}

	public void checkLevelUp() {
	
		if (exp >= nextLevelExp) {
			
			level++;
			nextLevelExp = nextLevelExp*2;
			strength++;
			defense++;
			attack = getAttack();
			armor = getArmor();
			abilityPower = getAP();
			magicResist = getMR();
			
			attackDamage = getAttackDamage();
		    magicDamage = getMagicDamage();
			
			gp.playSE(10);
			
		}
	}
	
	public void selectItem() {
		
		int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol, gp.ui.playerSlotRow);
		
		if (itemIndex < inventory.size()) {
			Entity selectedItem = inventory.get(itemIndex);
			if (selectedItem.type == 5 || selectedItem.type == 6 || selectedItem.type == 7) {
				
				currentWeapon = selectedItem;
				attack = getAttack();
				abilityPower = getAP();
	            attackDamage = getAttackDamage(); 
	            magicDamage = getMagicDamage();
				getPlayerAttackImage();
			}
			
			if (selectedItem.type == 8) {
				
				currentShield = selectedItem;
				armor = getArmor();
				magicResist = getMR();
			}
			
			if (selectedItem.type == 30) {
				
				if (currentLight == selectedItem) {
					currentLight = null;
				}
				else {
					currentLight = selectedItem;
				}
				lightUpdated = true;
			}
			
			if (selectedItem.type == 9) {
				
				if (selectedItem.use(this) == true) {
					if (selectedItem.amount > 1) {
						selectedItem.amount--;
					}
					else {
						inventory.remove(itemIndex);
					}
				}			
			}
		}		
	}
	
	public int searchItemInInventory(String itemName) {
		
		int itemIndex = 999;
		
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name.equals(itemName)) {
				itemIndex = i;
				break;
			}
		}
		return itemIndex;
	}
	
	public boolean canObtainItem(Entity item) {
		
		boolean canObtain = false;
		
		// Check if item is stackable
		if (item.stackable == true) {
			
			int index = searchItemInInventory(item.name);
			
			if (index != 999) {
				inventory.get(index).amount++;
				canObtain = true;
			}
			else {
				if (inventory.size() != maxInventorySize) {
					inventory.add(item);
					canObtain = true;
				}
			}
		}
		// For not stackable
		else {
			if (inventory.size() != maxInventorySize) {
				inventory.add(item);
				canObtain = true;
			}
		}
		return canObtain;
	}
	
	public void draw(Graphics2D g2) {
	    BufferedImage image = null;
	    int tempScreenX = screenX;
	    int tempScreenY = screenY;
	    int attackOffset = 23; 

	    if (attacking) {
	        switch(direction) {
	            case "up":
	                tempScreenY = screenY - attackOffset; 
	                image = (spriteNum == 1) ? attackUp1 : attackUp2;
	                break;
	            case "down":
	                tempScreenY = screenY - attackOffset; 
	                image = (spriteNum == 1) ? attackDown1 : attackDown2;
	                break;
	            case "left":
	                tempScreenX = screenX - attackOffset;
	                image = (spriteNum == 1) ? attackLeft1 : attackLeft2;
	                break;
	            case "right":
	                tempScreenX = screenX - attackOffset; 
	                image = (spriteNum == 1) ? attackRight1 : attackRight2;
	                break;
	        }
	    } else {
	        
	        if (!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
	            switch(direction) {
	                case "up": image = upStand; break;
	                case "down": image = downStand; break;
	                case "left": image = leftStand; break;
	                case "right": image = rightStand; break;
	            }
	        } else {
	           
	            switch(direction) {
	                case "up": image = (spriteNum == 1) ? up1 : up3; break;
	                case "down": image = (spriteNum == 1) ? down1 : down3; break;
	                case "left": image = (spriteNum == 1) ? left1 : left2; break;
	                case "right": image = (spriteNum == 1) ? right1 : right2; break;
	            }
	        }
	    }

	   
	    if (invincible) {
	        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
	    }

	    g2.drawImage(image, tempScreenX, tempScreenY, null);
	    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}
}