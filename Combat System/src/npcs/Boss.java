package npcs;

public class Boss extends Enemy{

    public NPCType  bType = NPCType.DRAGON;

    public Boss(NPCType _bType, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative){
        super(_bType, _name,_hp,_mana,_armor,_damage,_initiative);
    }

    @Override
    public int attack() {
        return super.attack()+15;
    }
}
