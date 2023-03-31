import java.util.Random;

public class Enemy extends NPC{

    public NPCType etype;

    public Enemy(NPCType _etype, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative){
        super(_name, _hp, _mana, _armor, _damage, _initiative);
        etype = _etype;
    }

    @Override
    public int attack(){
        return getDamage();
    }
}
