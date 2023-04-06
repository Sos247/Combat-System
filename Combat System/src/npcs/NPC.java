package npcs;
import utils.Color;
public abstract class NPC {

    public String name;
    public int maxHP;
    public int mana;
    public int armor;
    public int damage;
    public int hp;
    public int initiative;
    public abstract String npcTalk();
    public abstract int useAbility(int i);
    public abstract String abilities();


    public NPC(String _name, int _maxHP, int _mana, int _armor, int _damage, int _initiative) {

        name = _name;
        maxHP = _maxHP;
        mana = _mana;
        armor = _armor;
        damage = _damage;
        initiative = _initiative;
        hp = maxHP;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMana() {
        return mana;
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
                Color.CYAN + "\nMANA = " + mana + Color.RESET + " / "+ Color.CYAN + getMana() + Color.RESET +
                "\nARMOR = " + armor + " / " + getArmor() +
                "\nDAMAGE = " + damage ;
    }
}


