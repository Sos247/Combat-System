import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Adventure {

    public Hero hero;
    public Enemy enemy;

    int encounterRoll;
    Items item;

    private int steps;

    public void init() {

        setDifficulty();
        hero = selectClass();
        initialize(hero, enemy);
    }
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
    public Hero selectClass() {

        int selection;

        Scanner input = new Scanner(System.in);

        System.out.println("Select Your Class \n 1.Barbarian \n 2.Rogue \n 3.Wizard");

        System.out.print("Choice : ");

        do {
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    hero = new Hero(NPCType.BARBARIAN, "Barbarian", 100, 40, 60, 60);
                    break;
                case 2:
                    hero = new Hero(NPCType.ROGUE, "Rogue", 100, 30, 45, 80);
                    break;
                case 3:
                    hero = new Hero(NPCType.WIZARD, "Wizard", 100, 80, 30, 45);
                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        } while (selection > 3 || selection < 1);

        return hero;
    }
    public void initialize(Hero h, Enemy e) {
        ArrayList<Enemy> path = new ArrayList<>();
        for (int i = 1; i < getDifficulty(); ) {
            path.add(encounter());
            if (encounterRoll >= 0 && encounterRoll <= 2) {
                //battle(h, e);
            } else {
                i++;
            }
        }
    }

    public Enemy encounter() {

        Random randSelect = new Random();
        encounterRoll = randSelect.nextInt(6);
        switch (encounterRoll) {
            case 0:
                System.out.print("You Encounter a ");
                enemy = new Enemy(NPCType.BARBARIAN, "Barbarian", 100, 40, 60, 60);
                break;
            case 1:
                System.out.print("You Encounter a ");
                enemy = new Enemy(NPCType.ROGUE, "Rogue", 100, 30, 45, 80);
                break;
            case 2:
                System.out.print("You Encounter a ");
                enemy = new Enemy(NPCType.WIZARD, "Wizard", 100, 80, 30, 45);
                break;
            case 3:
                System.out.println("You Encountered Nothing");
                break;
            default:
                item.itemDrop();
                break;
        }
        return enemy;
    }

//    public void battle(Hero h, Enemy e) {
//        do {
//            h.heroAttack();
//            e.enemyAttack();
//
//        } while (h.getHp() > 0 && e.getHp() > 0);
//    }
}
