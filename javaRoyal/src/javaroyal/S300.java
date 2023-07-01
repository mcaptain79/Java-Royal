
package javaroyal;

/**
 *s300 defender
 * @author acer
 */
public class S300 extends DefendFacility{
    private final int damage = 500;
    private final int cost = 300;
    private final int maxHealth = 500;
    //constructor
    public S300() {
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
