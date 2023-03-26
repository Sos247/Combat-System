import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Adventure {
    public Scanner scanner = new Scanner(System.in);
    public Hero hero;
    public Enemy enemy;
    public Civilian civilian;
    public Animal animal;
    public Items item;
    private int steps;
    public Commons utility = new Commons();
    private int selection;

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
        Commons.clearConsole();
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
    }

    public int getDifficulty() {
        return steps;
    }

    public Hero selectClass() {
        int selection;
        Scanner input = new Scanner(System.in);
        Commons.clearConsole();
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
        return hero;
    }

    public void journey() {
        ArrayList<Enemy> path = new ArrayList<>();
        for (int i = 1; i <= getDifficulty(); i++) {
            utility.enterToContinue();
            Commons.clearConsole();
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
            item = new Items("def", 10, 10, 10, 10);
            int encounterRoll;
            Random randSelect = new Random();
            encounterRoll = randSelect.nextInt(7);
            String name;
            switch (encounterRoll) {
                case 0:
                    name = randomName(Commons.barbarianNames);
                    enemy = new Enemy(NPCType.BARBARIAN, name, 100, 40, 60, 60);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.etype);
                    enemy.allStatsTogether();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 1:
                    name = randomName(Commons.rogueNames);
                    enemy = new Enemy(NPCType.ROGUE, name, 100, 30, 45, 80);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.etype);
                    enemy.allStatsTogether();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 2:
                    name = randomName(Commons.wizardNames);
                    enemy = new Enemy(NPCType.WIZARD, name, 100, 80, 30, 45);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.etype);
                    enemy.allStatsTogether();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 3:
                    hero.fillInventory(item.itemDrop());
                    hero.openInventory();
                    break;
                case 4:
                    name = randomName(Commons.civilianNames);
                    civilian = new Civilian(NPCType.CIVILIAN, name, 50, 50, 50, 50);
                    System.out.println("Civilian " + civilian.getName() + "\n" + civilian.talk);
                    hero.fillInventory(item.itemDrop());
                    hero.openInventory();
                    break;
                case 5:
                    animal = new Animal(NPCType.ANIMAL, "Boar", 80, 0, 60, 50);
                    System.out.println("Animal " + animal.getName());
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
            System.out.print("Select Your Attack : |1| Slash  |2| Charge  |3| Inventory |AnyOtherNumber| Basic \nChoice: ");
            select();
            if (selection == 1) {
                System.out.println("You Attacked with Slash");
                defenderHP -= attacker.attack() + 10;
            } else if (selection == 2) {
                System.out.println("You Attacked with Charge");
                defenderHP -= attacker.attack() + 20;
            }else {
                    System.out.println("You Attacked with Basic");
                    defenderHP -= attacker.attack();
                }
                if (defenderHP <= 0) {
                    defender.hp = 0;
                    System.out.println(defender.getName() + " DIED");
                    break;
                } else {
                    System.out.println(defender.getName() + " HP = " + defenderHP + " / " + defender.getHp());
                }
                System.out.println(defender.getName() + " ATTACKS YOU ");
                attackerHP -= defender.attack();
                if (attackerHP <= 0) {
                    attacker.hp = 0;
                    System.out.println(attacker.getName() + " YOU DIED");
                    mainMenu();
                } else {
                    System.out.println("YOUR REMAINING HP = " + attackerHP + " / " + attacker.getHp());
                }
        }while (attacker.hp > 0 && defender.hp > 0) ;
    }

        public void mainMenu () {
            System.out.println("|1| Start Game \n|2| Exit Game");
            System.out.print("Choice : ");
            select();
            switch (selection) {
                case 1:
                    selectClass();
                    Commons.clearConsole();
                    setDifficulty();
                    journey();
                    break;
                case 2:
                    System.exit(0);
            }
        }
        public String randomName (String[]names){

            int index = new Random().nextInt(names.length);
            return names[index];
        }

    }