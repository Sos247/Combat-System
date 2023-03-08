import java.util.Random;

public class Enemy extends NPC{
    private classes enemy;

    public int enemyAttack(){

        int eAttack;
        Random randSelect = new Random();
        eAttack = randSelect.nextInt(3);

        switch (eAttack) {
            case 0:
                System.out.println("Enemy Attacked with Basic");
                eAttack = enemy.getDamage();
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
