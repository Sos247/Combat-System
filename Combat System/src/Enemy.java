import java.util.Random;

public class Enemy extends NPC{

    public NPCType etype;
    public Enemy(NPCType _etype, String _name, int _hp, int _mana, int _armor, int _damage){
        super(_name, _hp, _mana, _armor, _damage);
        etype = _etype;
    }

    public int enemyAttack(){

        int eAttack;
        Random randSelect = new Random();
        eAttack = randSelect.nextInt(3);

        switch (eAttack) {
            case 0:
                System.out.println("Enemy Attacked with Basic");
                eAttack = etype.getDamage();
                break;
            case 1:
                System.out.println("Enemy Attacked with Slash");
                eAttack= enemy.getDamage() + 15;
                break;
            case 2:
                System.out.println("Enemy Attacked with Charge");
                eAttack = enemy.getDamage() +20;
                break;
        }
        return eAttack;
    }
}
