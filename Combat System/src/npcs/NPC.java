package npcs;
import tools.Color;
public abstract class NPC {

    public String name;
    public int maxHP;
    public int maxMana;
    public int armor;
    public int damage;
    public int hp;
    public int mana;
    public int initiative;
    public NPCType type;
    public abstract String npcTalk();
    public abstract String abilities();


    public NPC(String _name, int _maxHP, int _mana, int _armor, int _damage, int _initiative, NPCType _type) {

        name = _name;
        maxHP = _maxHP;
        maxMana = _mana;
        armor = _armor;
        damage = _damage;
        initiative = _initiative;
        type = _type;
        hp = maxHP;
        mana = maxMana;
    }
    public NPCType getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }

    public int attack() {
        return getDamage();
    }

    public String Stats() {
        abilities();
        return Color.RED + "\nHP = " + hp + Color.RESET + " / " + Color.RED + getMaxHP() + Color.RESET +
                Color.CYAN + "\nMANA = " + maxMana + Color.RESET + " / "+ Color.CYAN + getMaxMana() + Color.RESET +
                "\nARMOR = " + armor + " / " + getArmor() +
                "\nDAMAGE = " + damage ;
    }
}


