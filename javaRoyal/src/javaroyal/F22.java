
package javaroyal;

/**
 *representative of attacking f22
 * @author acer
 */
public class F22 extends AttacFacility{
    private final int damage = 250;
    private final int cost = 800;
    private final int maxHealth = 50;
    //constructor
    public F22() {
        setHealth(50);
    }
    
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
