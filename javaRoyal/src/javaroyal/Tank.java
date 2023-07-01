package javaroyal;
/**
 * representative of attacking tank
 * @author acer
 */
public class Tank extends AttacFacility{
    private final int damage = 100;
    private final int cost = 400;
    private final int maxHealth = 100;
    //constructor
    public Tank() {
        setHealth(100);
    }
    //getters and setters
    public int getDamage() {
        return damage;
    }

    public int getCost() {
        return cost;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

}
