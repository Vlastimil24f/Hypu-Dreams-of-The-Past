package object;

import entity.Entity;
import entity.Hypu;
import entity.Projectile;
import main.GamePanel;

public class Volteris extends Projectile {

    GamePanel gp;

    public Volteris(GamePanel gp) {
    	
        super(gp);
        this.gp = gp;
        name = "Volteris";
        speed = 8;
        maxLife = 999;
        life = maxLife;
        knockBackPower = 0;
        useCost = 1;
        alive = false;
        getImage();
    }

    @Override
    public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
        super.set(worldX, worldY, direction, alive, user);

        if (user instanceof Hypu) {
            Hypu player = (Hypu) user;

            Entity weapon = player.currentWeapon;

            if (weapon.affectsMagicDamage) {
                this.abilityPower = player.getMagicDamage();
            } else if (weapon.affectsAttackDamage) {
                this.abilityPower = player.getAttackDamage(); 
            } else {
                this.abilityPower = 0; 
            }
        }
    }

    public void getImage() {
        try {
            for (int i = 0; i < 10; i++) {
                rightSprites[i] = setup("/projectile/B" + (i + 1), gp.tileSize, gp.tileSize);
                leftSprites[i] = setup("/projectile/B" + (i + 11), gp.tileSize, gp.tileSize);
                upSprites[i] = setup("/projectile/B" + (i + 21), gp.tileSize, gp.tileSize);
                downSprites[i] = setup("/projectile/B" + (i + 31), gp.tileSize, gp.tileSize);
            }

            rightStand = rightSprites[0];
            leftStand = leftSprites[0];
            upStand = upSprites[0];
            downStand = downSprites[0];
        } catch (Exception e) {
            e.printStackTrace();
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
