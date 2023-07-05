import java.util.Random;

public class Enemy extends NPC{

    public NPCType etype;

    public Enemy(NPCType _etype, String _name, int _hp, int _mana, int _armor, int _damage){
        super(_name, _hp, _mana, _armor, _damage);
        etype = _etype;
    }

    @Override
    public int attack(){
        int attack;
        Random randSelect = new Random();
        attack = randSelect.nextInt(3);

        switch (attack) {
            case 0:
                System.out.println("Enemy Attacked with Basic");
                attack = getDamage();
                break;
            case 1:
                System.out.println("Enemy Attacked with Slash");
                attack= getDamage() + 15;
                break;
            case 2:
                System.out.println("Enemy Attacked with Charge");
                attack = getDamage() + 20;
                break;
        }
        return attack;
    }

}
