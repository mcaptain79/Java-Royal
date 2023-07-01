package javaroyal;
/**
 * representative of attacking soldier
 * @author acer
 */
public class Soldier extends AttacFacility{
    private final int damage = 10;//damage
    private final int cost = 100;//cost
    private final int maxHealth = 10;//maximum health

    //constructor
    public Soldier() {
        setHealth(10);
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
