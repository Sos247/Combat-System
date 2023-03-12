public class Animal extends NPC{

    public NPCType aType;
    public Animal(NPCType _aType, String _name, int _hp, int _mana, int _armor, int _damage){
        super(_name, _hp, _mana, _armor, _damage);
        aType = _aType;
    }

    public int animalAttack(){
        int aAttack;
        aAttack = getDamage();
        return aAttack;
    }
}
