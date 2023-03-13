public class NPC {

    private String name;
    public int hp;
    private int mana;
    public int armor;
    public int damage;

    public NPC(String _name, int _hp, int _mana, int _armor, int _damage) {

        name = _name;
        hp = _hp;
        mana = _mana;
        armor = _armor;
        damage = _damage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
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

    public void allStatsTogether() {
        System.out.println("Class Name = " + getName() +
                "\nHP = " + getHp() +
                "\nMANA = " + getMana() +
                "\nARMOR = " + getArmor() +
                "\nDAMAGE = " + getDamage());
    }
   
    }


