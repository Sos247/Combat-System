import java.util.Random;

public class Animal extends NPC{

    public NPCType aType;
    public Animal(NPCType _aType, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative){
        super(_name, _hp, _mana, _armor, _damage, _initiative);
        aType = _aType;
    }
    @Override
    public int attack(){
        return getDamage() / 2 + 5;
    }

}
