
package javaroyal;

/**
 *a head quarter representer
 * @author acer
 */
public class HeadQuarter extends DefendFacility{
    private final int cost = 3000;
    private final int maxHealth = 3000;

    //constructor
    public HeadQuarter() {
        setHealth(3000);
    }

    //getters and setters
    public int getCost() {
        return cost;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
