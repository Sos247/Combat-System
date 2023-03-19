import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Adventure {
    public Scanner scanner = new Scanner(System.in);
    public Hero hero;
    public Enemy enemy;
    public Civilian civilian;
    public Animal animal;
    int encounterRoll;
    public Items item;
    public List<Items> playerInventory = new ArrayList<>();
    private int steps;
    public UtilityMethods utility = new UtilityMethods();
    private int selection;
    private boolean isDifficulty = false;
    private boolean isClass = false;

    public void select() {
        selection = scanner.nextInt();
    }

    public void init2() {
        utility.printHeading("textRPG");
        mainMenu();
    }

    public void init() {
        setDifficulty();
        hero = selectClass();
        initialize();
    }

    public void setDifficulty() {
        int difficulty;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Difficulty \n|1| Easy(5 Steps) \n|2| Normal(10 Steps) \n|3| Hard(15 Steps)");
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
                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        } while (difficulty > 3 || difficulty < 1);
        isDifficulty = true;
        mainMenu();
    }

    public int getDifficulty() {
        return steps;
    }

    public Hero selectClass() {

        int selection;

        Scanner input = new Scanner(System.in);
        utility.printHeading("Select Your Class ");
        System.out.println("\n|1| Barbarian \n|2| Rogue \n|3| Wizard");
        System.out.print("Choice : ");
        do {
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    hero = new Hero(NPCType.BARBARIAN, "Barbarian", 500, 40, 60, 60);
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
        isClass = true;
        mainMenu();
        return hero;
    }

    public void initialize() {
        ArrayList<Enemy> path = new ArrayList<>();
        for (int i = 1; i <= getDifficulty(); i++) {
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
                    battle(hero, enemy, animal);
                    break;
                case 1:
                    enemy = new Enemy(NPCType.ROGUE, "Rogue", 100, 30, 45, 80);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    battle(hero, enemy, animal);
                    break;
                case 2:
                    enemy = new Enemy(NPCType.WIZARD, "Wizard", 100, 80, 30, 45);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    battle(hero, enemy, animal);
                    break;
                case 3:
                    item = new Items("def", 10, 10, 10, 10);
                    item = item.itemDrop();
                    playerInventory();
                    openInventory();
                    break;
                case 4:
                    civilian = new Civilian(NPCType.CIVILIAN, "George", 50, 50, 50, 50);
                    System.out.println("Civilian" + civilian.getName());
                    civilian.allStatsTogether();
                    civilian.civilAction();
                    item = new Items("def", 10, 10, 10, 10);
                    item = item.itemDrop();
                    playerInventory();
                    openInventory();
                    break;
                case 5:
                    animal = new Animal(NPCType.ANIMAL, "Boar", 80, 0, 60, 50);
                    System.out.println("Animal" + animal.getName());
                    animal.allStatsTogether();
                    battle(hero, enemy, animal);
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
                if (animal.getHp() <= 0) {
                    animal.hp = 0;
                    System.out.println(animal.getName() + " Died, the journey continues");
                    break;
                }
                System.out.println(animal.getName() + " Hp remain = " + a.hp);
                h.hp -= a.animalAttack();
                if (hero.getHp() <= 0) {
                    hero.hp = 0;
                    System.out.println("You Died, Reset the Game NOW");
                    init();
                }
                System.out.println("Your Hp = " + h.hp);
            } while (h.getHp() != 0 && a.getHp() != 0);

        } else {
            do {
                h.heroAttack();
                e.hp -= h.hAttack - (h.hAttack / e.getArmor());
                if (enemy.getHp() <= 0) {
                    enemy.hp = 0;
                    System.out.println(enemy.getName() + " Died, the journey continues");
                    break;
                }
                System.out.println(e.getName() + " Hp remain = " + e.hp);
                h.hp -= enemy.enemyAttack();
                if (hero.getHp() <= 0) {
                    hero.hp = 0;
                    System.out.println("You Died, Reset the Game NOW");
                    init();
                }
                //healthChecker();
                System.out.println("Your Hp = " + h.hp);
            } while (h.getHp() > 0 && e.getHp() > 0);
        }
    }

    public void playerInventory() {
        if (encounterRoll == 3 || encounterRoll == 4) {
            playerInventory.add(item);
        }
    }

    public void openInventory() {
        for (Items item : playerInventory) {
            System.out.println("-> " + item.getItemName());
        }

    }

    //    public void healthChecker() {
//        if (hero.getHp() <= 0) {
//            hero.hp = 0;
//            System.out.println("You Died, Reset the Game NOW");
//            init();
//        }
//    }
//    public void enemyHealthChecker() {
//        if (enemy.getHp() <= 0) {
//            enemy.hp = 0;
//            System.out.println(enemy.getName() + " Died, the journey continues");
//            //initialize();
//        }
//    }
//
//    public void animalHealthChecker() {
//        if (animal.getHp() <= 0) {
//            animal.hp = 0;
//            System.out.println(animal.getName() + " Died, the journey continues");
//            //initialize();
//        }
//    }
    public void mainMenu() {
        System.out.println("|1| Start Game \n|2| Options \n|3| Exit Game");
        select();
        switch (selection) {
            case 1:
                System.out.println("|1| Begin \n|2| Select Class \n|3| Back to Main Menu");
                select();
                switch (selection) {
                    case 1:
                        if (!isDifficulty || !isClass) {
                            System.out.println("You Must Select a Class and Set your Difficulty in order to Continue");
                            break;
                        } else {
                            initialize();
                        }
                        break;
                    case 2:
                        selectClass();
                        break;
                    case 3:
                        mainMenu();
                        break;
                }
                break;
            case 2:
                utility.printHeading("OPTIONS");
                System.out.println("|1| Set Difficulty \n|2| Back to Main Menu");
                select();
                switch (selection) {
                    case 1:
                        setDifficulty();
                        break;
                    case 2:
                        mainMenu();
                        break;
                    case 3:
                        System.exit(0);
                }
        }

    }
}