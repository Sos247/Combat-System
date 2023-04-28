package npcs;

import java.util.*;

import npcsUtils.*;

public class Hero extends NPC {

    public NPCType type;
    public List<Items> inventory = new ArrayList<>();
    public Hero(NPCType _type, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative) {

        super(_name, _hp, _mana, _armor, _damage, _initiative, _type);

    }

    @Override
    public String npcTalk() {
        return "";
    }


    @Override
    public String abilities() {

        return "";
    }

    public int attack() {

        return damage;
    }

    public void fillInventory(Items item) {
        inventory.add(item);
    }
    public void openInventory() {
        for (Items item : inventory) {
            System.out.println("-> " + item.getItemName());
        }
    }

}
