import java.util.*;

public class Hero extends NPC {
    public NPCType type;
    public List<Items> inventory = new ArrayList<>();

    public Hero(NPCType _type, String _name, int _hp, int _mana, int _armor, int _damage) {

        super(_name, _hp, _mana, _armor, _damage);
        
        type = _type;
    }

    public int attack() {

        return getDamage();
    }
    public void fillInventory(Items item){
        inventory.add(item);
    }
    public void openInventory() {
        for (Items item : inventory) {
            System.out.println("-> " + item.getItemName());
        }
    }
}

