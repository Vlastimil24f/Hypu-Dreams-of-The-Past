package object;

import entity.Entity;
import entity.Hypu;
import entity.Projectile;
import main.GamePanel;

public class Abyss extends Projectile {

    GamePanel gp;

    public Abyss(GamePanel gp) {
    	
        super(gp);
        this.gp = gp;
        name = "Abyss";
        speed = 0;
        maxLife = 80;
        life = maxLife;
        knockBackPower = 0;
        useCost = 0;
        alive = false;
        getImage();
    }

    @Override
    public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
        super.set(worldX, worldY, direction, alive, user);

        if (user instanceof Hypu) {
            Hypu player = (Hypu) user;

            int tileSize = gp.tileSize;
            int offsetX = tileSize / 2; 
            int offsetY = tileSize / 2;

            switch (direction) {
                case "up":
                    this.worldX = player.worldX + offsetX - (tileSize / 4) - 10; 
                    this.worldY = player.worldY - tileSize - 10; 
                    break;
                case "down":
                    this.worldX = player.worldX + offsetX - (tileSize / 4 + 13);
                    this.worldY = player.worldY + tileSize + 30;
                    break;
                case "left":
                    this.worldX = player.worldX - tileSize - 20;
                    this.worldY = player.worldY + offsetY - (tileSize / 4) + 5; 
                    break;
                case "right":
                    this.worldX = player.worldX + tileSize + 20; 
                    this.worldY = player.worldY + offsetY - (tileSize / 4) + 5;
                    break;
            }

            Entity weapon = player.currentWeapon;
            if (weapon.affectsMagicDamage) {
                this.abilityPower = player.getMagicDamage();
            } else if (weapon.affectsAttackDamage) {
                this.abilityPower = player.getAttackDamage();
            } else {
                this.abilityPower = 0;
            }

            this.speed = 0;
            this.alive = alive; 
        }
    }


    public void getImage() {
        try {
            for (int i = 0; i < 10; i++) {
                rightSprites[i] = setup("/projectile/A" + (i + 1), gp.tileSize, gp.tileSize);
                leftSprites[i] = setup("/projectile/A" + (i + 15), gp.tileSize, gp.tileSize);
                upSprites[i] = setup("/projectile/A" + (i + 29), gp.tileSize, gp.tileSize);
                downSprites[i] = setup("/projectile/A" + (i + 43), gp.tileSize, gp.tileSize);
            }

            rightStand = rightSprites[0];
            leftStand = leftSprites[0];
            upStand = upSprites[0];
            downStand = downSprites[0];
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    @Override
    public void update() {

        if (user == gp.hypu) {
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            if (monsterIndex != 999) {
                gp.hypu.damageMonster(monsterIndex, abilityPower, knockBackPower);
            }
        }

        if (user != gp.hypu) {
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if (!gp.hypu.invincible && contactPlayer) {
                damagePlayer(abilityPower);
            }
        }

        life--;
        if (life <= 0) {
            alive = false;
            return;
        }

        spriteCounter++;
        if (spriteCounter > 3) { 
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
    	if (user.mana >= useCost) {
    		haveResource = true;
    	}
    	return haveResource;
    }
    
    public void subtractResource(Entity user) {
    	user.mana -= useCost;
    }
}