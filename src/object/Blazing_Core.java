package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;
import monster.Corefire_Slime;
import monster.Red_Slime;

public class Blazing_Core extends Projectile {

    GamePanel gp;

    public Blazing_Core(GamePanel gp) {
    	
        super(gp);
        this.gp = gp;
        
        name = "Blazing Core";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        knockBackPower = 0;
        useCost = 1;
        alive = false;
        getImage();
    }
    
    @Override
    public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
        super.set(worldX, worldY, direction, alive, user);

        if (user instanceof Corefire_Slime) {
            Corefire_Slime slime = (Corefire_Slime) user;
            this.attackDamage = slime.attack;
            this.magicDamage = slime.abilityPower; 
        }
        
        if (user instanceof Red_Slime) {
            Red_Slime slime1 = (Red_Slime) user;
            this.attackDamage = slime1.attack;
            this.magicDamage = slime1.abilityPower; 
        }

    }


    public void getImage() {
        try {
            for (int i = 0; i < 10; i++) {
                rightSprites[i] = setup("/projectile/F" + (i + 1), gp.tileSize, gp.tileSize);
                leftSprites[i] = setup("/projectile/F" + (i + 15), gp.tileSize, gp.tileSize);
                upSprites[i] = setup("/projectile/F" + (i + 30), gp.tileSize, gp.tileSize);
                downSprites[i] = setup("/projectile/F" + (i + 45), gp.tileSize, gp.tileSize);
            }

            rightStand = rightSprites[0];
            leftStand = leftSprites[0];
            upStand = upSprites[0];
            downStand = downSprites[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
