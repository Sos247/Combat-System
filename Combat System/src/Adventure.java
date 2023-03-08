import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Adventure extends NPC{

    private classes enemy;
    private Items item;
    int encounterRoll;

    private int steps;

    public void setDifficulty() {
        int difficulty;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Difficulty \n 1.Easy(5 Steps) \n 2.Normal(10 Steps) \n 3.Hard(15 Steps)");
        System.out.print("Choice : ");

        do {
            difficulty = input.nextInt();

            switch (difficulty) {
                case 1:
                    steps = 5;
                    break;
                case 2:
                    steps = 10;
                    break;
                case 3:
                    steps = 15;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        } while (difficulty > 3 || difficulty < 1);

    }

    public int getDifficulty() {
        return steps;
    }

    public void initialize(Hero h, Enemy e) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < getDifficulty(); ) {
            path.add(encounter());
            if (encounterRoll >= 0 && encounterRoll <= 2) {
              battle(h, e);
            } else {
                i++;
            }
        }
    }
    public int encounter() {
        Random randSelect = new Random();
        encounterRoll = randSelect.nextInt(6);
        switch (encounterRoll) {
            case 0:
                System.out.print("You Encounter a ");
                enemy = NPC.classes.BARBARIAN;
                enemy.allStatsTogether();
                break;
            case 1:
                System.out.print("You Encounter a ");
                enemy = NPC.classes.ROGUE;
                enemy.allStatsTogether();
                break;
            case 2:
                System.out.print("You Encounter a ");
                enemy = NPC.classes.WIZARD;
                enemy.allStatsTogether();
                break;
            case 3:
                System.out.println("You Encountered Nothing");
                break;
            default:
                item.itemDrop();
                break;
        }
        return encounterRoll;
    }

    public void battle(Hero h, Enemy e) {

        do {
            h.heroAttack();
            e.enemyAttack();

        } while (h.getHp() > 0 && e.getHp() > 0);
    }
}
