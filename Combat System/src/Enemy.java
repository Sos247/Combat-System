import java.util.Random;
import java.util.Scanner;

public class Enemy extends NPC{

    public int classType;
    public int encounterClass() {
        int range = 3;
        Random randSelect = new Random();
        classType = randSelect.nextInt(range);
        switch (classType) {

            case 0:
                System.out.print("You Encounter a ");
                setStats("Barbarian",100,30,70,60);
                allStatsTogether();
                break;
            case 1:
                System.out.print("You Encounter a ");
                setStats("Rogue",100,30,40,80);
                allStatsTogether();
                break;
            case 2:
                System.out.print("You Encounter a ");
                setStats("Wizard",100,70,20,40);
                allStatsTogether();
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
        int range = 2;
        Random randSelect = new Random();
        eAttack = randSelect.nextInt(range);

        switch (eAttack) {
            case 1:
                System.out.println("Enemy Attacked with Basic");
                eAttack = getDamage();
                break;
            case 2:
                System.out.println("Enemy Attacked with Slash");
                eAttack= getDamage() + 15;
                break;
            case 3:
                System.out.println("Enemy Attacked with Charge");
                eAttack = getDamage() +20;
                break;
        }
        return eAttack;
    }
}
