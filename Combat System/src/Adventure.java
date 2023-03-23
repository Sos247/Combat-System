import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Adventure {
    public Scanner scanner = new Scanner(System.in);
    public Hero hero;
    public Enemy enemy;
    public Civilian civilian;
    public Animal animal;
    //int encounterRoll;
    public Items item;
    private int steps;
    public UtilityMethods utility = new UtilityMethods();
    private int selection;
    private boolean isDifficulty = false;
    private boolean isClass = false;

    public void select() {
        selection = scanner.nextInt();
    }

    public void init() {
        utility.printHeading("textRPG");
        mainMenu();
    }

    public void setDifficulty() {
        int difficulty;
        Scanner input = new Scanner(System.in);
        utility.printHeading("Difficulty");
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
        beginMenu();
    }

    public int getDifficulty() {
        return steps;
    }

    public Hero selectClass() {
        int selection;
        Scanner input = new Scanner(System.in);
        utility.clearConsole();
        utility.printHeading("SELECT YOUR CLASS ");
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
        beginMenu();
        return hero;
    }

    public void journey() {
        ArrayList<Enemy> path = new ArrayList<>();
        for (int i = 1; i <= getDifficulty(); i++) {
            utility.enterToContinue();
            utility.clearConsole();
            if (i == 1) {
                utility.printHeading("THE JOURNEY BEGINS!!!");
                path.add(encounter());
            } else {
                utility.printHeading("THE JOURNEY CONTINUES!!");
                path.add(encounter());
            }
        }
    }

    public Enemy encounter() {
        try {
            int encounterRoll;
            Random randSelect = new Random();
            encounterRoll = randSelect.nextInt(7);
            switch (encounterRoll) {
                case 0:
                    enemy = new Enemy(NPCType.BARBARIAN, "Barbarian", 100, 40, 60, 60);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 1:
                    enemy = new Enemy(NPCType.ROGUE, "Rogue", 100, 30, 45, 80);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 2:
                    enemy = new Enemy(NPCType.WIZARD, "Wizard", 100, 80, 30, 45);
                    System.out.println("You Encounter a " + enemy.getName());
                    enemy.allStatsTogether();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 3:
                    item = new Items("def", 10, 10, 10, 10);
                    hero.fillInventory(item.itemDrop());
                    hero.openInventory();
                    //System.out.println("You Found a " + item.getItemName());
                    break;
                case 4:
                    civilian = new Civilian(NPCType.CIVILIAN, "George", 50, 50, 50, 50);
                    item = new Items("def", 10, 10, 10, 10);

                    System.out.println("Civilian " + civilian.getName());
                    civilian.talk();
                    hero.fillInventory(item.itemDrop());
                    hero.openInventory();
                    //System.out.println("You Found a " + item.getItemName());
                    break;
                case 5:
                    animal = new Animal(NPCType.ANIMAL, "Boar", 80, 0, 60, 50);
                    System.out.println("Animal" + animal.getName());
                    animal.allStatsTogether();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, animal);
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

    public void battle(NPC attacker, NPC defender) {
        int attackerHP = attacker.hp;
        int defenderHP = defender.hp;
        do {
            System.out.print("Select Your Attack : |1| Basic  |2| Slash  |3| Charge |4| Inventory \nChoice: ");
            defenderHP -= attacker.attack();
            if (defenderHP <= 0) {
                defender.hp = 0;
                System.out.println(defender.getName() + " DIED");
                utility.enterToContinue();
                utility.clearConsole();
                break;
            } else {
                System.out.println(defender.getName() + " HP = " + defenderHP + " / " + defender.getHp());
            }
            attackerHP -= defender.attack();
            if (attackerHP <= 0) {
                attacker.hp = 0;
                System.out.println(attacker.getName() + " YOU DIED");
                isDifficulty = false;
                isClass = false;
                utility.enterToContinue();
                utility.clearConsole();
                mainMenu();
            } else {
                System.out.println("YOUR REMAINING HP = " + attackerHP + " / " + attacker.getHp());
            }
        } while (attacker.hp > 0 && defender.hp > 0);
    }

    public void mainMenu() {
        System.out.println("|1| Start Game \n|2| Exit Game");
        System.out.print("Choice : ");
        select();
        switch (selection) {
            case 1:
                beginMenu();
                break;
            case 2:
                System.exit(0);
        }
    }

    public void beginMenu() {
        utility.clearConsole();
        utility.printHeading("PREPARATION MENU");
        if (!isClass) {
            System.out.println("Current State of Class and Difficulty: CLASS: NO CLASS SELECTED YET" + " DIFFICULTY:" + getDifficulty() + " STEPS");
        } else {
            System.out.println("Current State of Class and Difficulty: CLASS:" + hero.getName() + " DIFFICULTY:" + getDifficulty() + " STEPS");
        }
        System.out.println("|1| Begin Adventure \n|2| Select Class \n|3| Select Difficulty \n|4| Back to Main Menu");
        System.out.print("Choice : ");
        select();
        switch (selection) {
            case 1:
                if (!isDifficulty || !isClass) {
                    System.out.println("You Must Select a Class and Set your Difficulty in order to Continue");
                    beginMenu();
                    break;
                } else {
                    journey();
                }
                break;
            case 2:
                selectClass();
                break;
            case 3:
                setDifficulty();
            case 4:
                mainMenu();
                break;
        }
    }
}