import java.util.ArrayList;
import java.util.List; 

public class Character {
    public String name;
    public double health;
    public double maxHealth;
    public double damage;
    public List<Item> inventory;
    // Character type
    public double inteligence;

    public Character(String name, Boolean strong) {
        this.name = name;
        this.inventory = new ArrayList<>();
        // Set default values according to the player's type
    }
}
