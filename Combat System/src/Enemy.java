import java.util.Random;

public class Enemy extends NPC{

    public int classType;
    public int encounterClass() {
        Random randSelect = new Random();
        classType = randSelect.nextInt(4);
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

    public int enemyAttack(Hero h){

        int eAttack;
        Random randSelect = new Random();
        eAttack = randSelect.nextInt(3);

        switch (eAttack) {
            case 0:
                System.out.println("Enemy Attacked with Basic");
                eAttack = damage - h.armor;
                break;
            case 1:
                System.out.println("Enemy Attacked with Slash");
                eAttack= (damage + 15) - h.armor;
                break;
            case 2:
                System.out.println("Enemy Attacked with Charge");
                eAttack = (damage + 20) - h.armor;
                break;
        }
        return eAttack;
    }
}
