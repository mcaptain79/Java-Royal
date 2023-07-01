
package javaroyal;

/**
 *bomb defender
 * @author acer
 */
public class Bomb extends DefendFacility{
    private final int damage = 750;
    private final int cost = 100;
    private final int maxHealth = 1000;
    //constructor
    public Bomb() {
        setHealth(1000);
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
