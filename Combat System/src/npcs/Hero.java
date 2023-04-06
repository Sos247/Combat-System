package npcs;

import java.util.*;

import items.*;

public class Hero extends NPC {
    public NPCType type;
    public List<Items> inventory = new ArrayList<>();
    public String ability1 = "|1| Basic ";
    public String ability2 = "|2| Slash ";
    public String ability3 = "|3|Charge ";

    public Hero(NPCType _hType, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative) {

        super(_name, _hp, _mana, _armor, _damage, _initiative);
        type = _hType;
    }

    @Override
    public String npcTalk() {
        return "";
    }

    @Override
    public int useAbility(int i) {
        if (i == 1) {
            return damage;
        } else
            switch (type) {
                case BARBARIAN:
                    if (i == 2) {
                        return damage + 10;
                    } else {
                        return damage + 15;
                    }
                case ROGUE:
                    if (i == 2) {
                        return damage;
                    } else {
                        return damage + 30;
                    }
                case WIZARD:
                    if (i == 2) {
                        return damage + 20;
                    } else {
                        return damage + 30;
                    }
            }
        return i;
    }

    @Override
    public String abilities() {
        switch (type) {
            case BARBARIAN:
                break;
            case ROGUE:
                ability2 = "|2| Backstab ";
                ability3 = "|3|Dagger Throw ";
                break;
            case WIZARD:
                ability2 = "|2| Fireball ";
                ability3 = "|3|Thunderstorm ";
                break;
        }
        return ability1 + ability2 + ability3;
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
