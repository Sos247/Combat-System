import java.util.Random;

public class Enemy extends NPC{

    public NPCType etype;

    public Enemy(NPCType _etype, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative){
        super(_name, _hp, _mana, _armor, _damage, _initiative);
        etype = _etype;
    }

    @Override
    public int attack(){
        int attack;
        Random randSelect = new Random();
        attack = randSelect.nextInt(3);

        switch (attack) {
            case 0:
                attack = getDamage();
                break;
            case 1:
                attack= getDamage() + 15;
                break;
            case 2:
                attack = getDamage() + 20;
                break;
        }
        return attack;
    }
}
