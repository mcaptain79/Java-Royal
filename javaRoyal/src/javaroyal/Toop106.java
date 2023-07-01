
package javaroyal;

/**
 *representative of one defender
 * @author acer
 */
public class Toop106 extends DefendFacility{
    private final int damage = 300;
    private final int cost = 200;
    private final int maxHealth = 500;
    //constructor
    public Toop106() {
        setHealth(500);
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
