public class NPC {

    enum Classes{
        BARBARIAN("Barbarian",100,30,60,70),
        ROGUE("Rogue",100,45,45,80),
        WIZARD("Wizard",100,80,60,40);

        private String name;
        private int hp;
        private int mana;
        private int armor;
        private int damage;
        Classes(String _name, int _hp, int _mana, int _armor, int _damage){
            name = _name;
            hp = _hp;
            mana = _mana;
            armor = _armor;
            damage = _damage;
        }
    }
    private String name;
    private int hp;
    private int mana;
    private int armor;
    private int damage;

    public void setStats(String _name, int _hp, int _mana, int _armor, int _damage) {
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


