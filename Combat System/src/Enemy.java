import java.util.Random;

public class Enemy extends NPC{

    public int classType;
    public int encounterClass() {
        Random randSelect = new Random();
        classType = randSelect.nextInt(4);
        switch (classType) {

            case 0:
                System.out.print("You Encounter a ");
                Classes.BARBARIAN;
                Classes.allStatsTogether();
                break;
            case 1:
                System.out.print("You Encounter a ");
                Classes.ROGUE;
                Classes.allStatsTogether();
                break;
            case 2:
                System.out.print("You Encounter a ");
                Classes.WIZARD
                Classes.allStatsTogether();
                break;
            case 3:
                System.out.println("You Encountered Nothing");
                break;
            default:
                break;
        }
        return classType;
    }

    public int enemyAttack(){

        int eAttack;
        Random randSelect = new Random();
        eAttack = randSelect.nextInt(3);

        switch (eAttack) {
            case 0:
                System.out.println("Enemy Attacked with Basic");
                eAttack = getDamage();
                break;
            case 1:
                System.out.println("Enemy Attacked with Slash");
                eAttack= getDamage() + 15;
                break;
            case 2:
                System.out.println("Enemy Attacked with Charge");
                eAttack = getDamage() +20;
                break;
        }
        return eAttack;
    }
}
