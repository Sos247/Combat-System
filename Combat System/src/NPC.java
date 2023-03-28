public class NPC {

    public String name;
    public int hp;
    public int mana;
    public int armor;
    public int damage;

    public int initiative;

    public NPC(String _name, int _hp, int _mana, int _armor, int _damage, int _initiative) {

        name = _name;
        hp = _hp;
        mana = _mana;
        armor = _armor;
        damage = _damage;
        initiative = _initiative;
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

    public void Stats() {
        System.out.println("HP = " + hp + " / " + getHp() +
                "\nMANA = " + mana + " / " + getMana() +
                "\nARMOR = " + armor + " / " + getArmor() +
                "\nDAMAGE = " + damage);
    }
    public int attack(){

        return getDamage();
    }

}


