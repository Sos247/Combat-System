import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Adventure {

    public Hero hero;
    public Enemy enemy;
    public Civilian civilian;
    public Animal animal;
    int encounterRoll;
    public Items item = new Items("default", 10,10,10,10);

    private int steps;
    private boolean healthCheck = true;
    private boolean enemyHealthCheck = true;
    private boolean animalHealthCheck = true;
    public void init() {

        setDifficulty();
        hero = selectClass();
        initialize();
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

    public void initialize() {
        ArrayList<Enemy> path = new ArrayList<>();
        for (int i = 1; i < getDifficulty(); i++) {
            path.add(encounter());
            }
        }

    public Enemy encounter() {
        try {
            //healthChecker();
            Random randSelect = new Random();
            encounterRoll = randSelect.nextInt(7);
            switch (encounterRoll) {
                case 0:
                    enemy = new Enemy(NPCType.BARBARIAN, "Barbarian", 100, 40, 60, 60);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    battle(hero,enemy,animal);
                    break;
                case 1:
                    enemy = new Enemy(NPCType.ROGUE, "Rogue", 100, 30, 45, 80);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    battle(hero,enemy,animal);
                    break;
                case 2:
                    enemy = new Enemy(NPCType.WIZARD, "Wizard", 100, 80, 30, 45);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    battle(hero,enemy,animal);
                    break;
                case 3:
                    item = item.itemDrop();
                    break;
                case 4:
                    civilian = new Civilian(NPCType.CIVILIAN, "George", 50, 50, 50, 50);
                    System.out.println("Civilian" + civilian.getName());
                    civilian.allStatsTogether();
                    civilian.civilAction();
                    item = item.itemDrop();
                    break;
                case 5:
                    animal = new Animal(NPCType.ANIMAL, "Boar", 80, 0, 60, 50);
                    System.out.println("Animal" + animal.getName());
                    animal.allStatsTogether();
                    battle(hero,enemy,animal);
                    break;
                default:
                    System.out.println("You Encountered Nothing");
                    break;
            }
            return enemy;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void battle(Hero h, Enemy e, Animal a) {
        if (encounterRoll == 5) {
            do {
                a.hp -= h.heroAttack();
                System.out.println("Hp remain = "+ a.hp);
                animalHealthChecker();
                h.hp -= a.animalAttack();
                System.out.println("Your Hp = " + h.hp);
                healthChecker();
            } while (h.getHp() !=0 && a.getHp() != 0);

        } else {
            do {
                e.hp -= h.heroAttack();
                System.out.println("Hp remain = "+ e.hp);
                enemyHealthChecker();
                h.hp -= enemy.enemyAttack();
                System.out.println("Your Hp = " + h.hp);
                healthChecker();
            } while (h.getHp() > 0 && e.getHp() > 0);
        }
    }

    public void healthChecker(){
        if(hero.getHp() <= 0)
        {
            System.out.println("You Died");
            healthCheck = false;
            init();
        }
    }
    public void enemyHealthChecker(){
        if(enemy.getHp() <= 0)
        {
            enemyHealthCheck = false;
            encounter();
        }
    }
    public void animalHealthChecker(){
        if(animal.getHp() <= 0)
        {
            animalHealthCheck = false;
            encounter();
        }
    }
}

