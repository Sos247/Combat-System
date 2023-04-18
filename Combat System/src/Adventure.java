import items.Items;
import npcs.*;
import utils.*;

import java.util.Objects;
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

    public void mainMenu() {
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

    public void setDifficulty() {
        int difficulty;
        Scanner input = new Scanner(System.in);
        Commons.clearConsole();
        utility.printHeading("SELECT DIFFICULTY");
        System.out.println(Color.GREEN + "\n|1| Easy(5 Steps)" + Color.RESET +
                Color.YELLOW + "\n|2| Normal(10 Steps)" + Color.RESET +
                Color.PURPLE + "\n|3| Hard(15 Steps)" + Color.RESET);
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
        Hero heroBarb = new Hero(NPCType.BARBARIAN, "Barbarian", 500, 40, 60, 60, 9);
        Hero heroRog = new Hero(NPCType.ROGUE, "Rogue", 100, 30, 45, 80, 18);
        Hero heroWiz = new Hero(NPCType.WIZARD, "Wizard", 100, 80, 30, 45, 14);
        int selection;
        Scanner input = new Scanner(System.in);
        Commons.clearConsole();
        utility.printHeading("SELECT YOUR CLASS ");
        utility.printHeading("|1| " + Color.RED + "BARBARIAN" + Color.RESET);
        System.out.println(heroBarb.Stats());
        utility.printHeading("|2| " + Color.GREEN + "ROGUE" + Color.RESET);
        System.out.println(heroRog.Stats());
        utility.printHeading("|3| " + Color.BLUE + "WIZARD" + Color.RESET);
        System.out.println(heroWiz.Stats());
        System.out.print("Choice : ");
        do {
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    hero = new Hero(NPCType.BARBARIAN, "Barbarian", 500, 40, 60, 60, 9);
                    break;
                case 2:
                    hero = new Hero(NPCType.ROGUE, "Rogue", 100, 30, 45, 80, 18);
                    break;
                case 3:
                    hero = new Hero(NPCType.WIZARD, "Wizard", 100, 80, 30, 45, 14);
                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        } while (selection > 3 || selection < 1);
        return hero;
    }

    public void journey() {
        for (int i = 1; i <= getDifficulty(); i++) {
            utility.enterToContinue();
            Commons.clearConsole();
            if (i == 1) {
                utility.printHeading("THE JOURNEY BEGINS!!!");
                encounter();
            } else if (i == getDifficulty()) {
                utility.printHeading("THE JOURNEY ENDS HERE!!!");
                Boss boss = new Boss(NPCType.DRAGON,"Dragonius",250,150,90,100,16);
                battle(hero,boss);
            } else {
                utility.printHeading("THE JOURNEY CONTINUES!!!");
                encounter();
            }
        }
    }

    public void encounter() {
        try {
            item = new Items("Default", 10, 10, 10, 10);
            animal = new Animal(NPCType.BOAR, " ", 50, 50, 50, 40, 5);
            int encounterRoll;
            Random randSelect = new Random();
            encounterRoll = randSelect.nextInt(7);
            String name;
            switch (encounterRoll) {
                case 0:
                    name = utility.randomName(Commons.barbarianNames);
                    enemy = new Enemy(NPCType.BARBARIAN, name, 100, 40, 60, 60, 9);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.type + enemy.Stats());
                    utility.printHeading("TO BATTLE!!!");
                    utility.enterToContinue();
                    Commons.clearConsole();
                    battle(hero, enemy);
                    break;
                case 1:
                    name = utility.randomName(Commons.rogueNames);
                    enemy = new Enemy(NPCType.ROGUE, name, 100, 30, 45, 80, 15);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.type + enemy.Stats());
                    utility.printHeading("TO BATTLE!!!");
                    utility.enterToContinue();
                    Commons.clearConsole();
                    battle(hero, enemy);
                    break;
                case 2:
                    name = utility.randomName(Commons.wizardNames);
                    enemy = new Enemy(NPCType.WIZARD, name, 100, 80, 30, 45, 13);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.type + enemy.Stats());
                    utility.printHeading("TO BATTLE!!!");
                    utility.enterToContinue();
                    Commons.clearConsole();
                    battle(hero, enemy);
                    break;
                case 3:
                    hero.fillInventory(item.itemDrop());
                    System.out.println("You Found A " + hero.inventory.get(hero.inventory.size() - 1).getItemName());
                    break;
                case 4:
                    name = utility.randomName(Commons.civilianNames);
                    civilian = new Civilian(NPCType.CIVILIAN, name, 50, 50, 50, 50, 50);
                    hero.fillInventory(item.itemDrop());
                    System.out.println("Civilian " + civilian.getName() + "\n" + civilian.talk + " " + hero.inventory.get(hero.inventory.size() - 1).getItemName());
                    break;
                case 5:
                    animal = new Animal(animal.animalType(), animal.getAnimal(), 80, 0, 60, 50, 6);
                    System.out.println("Animal " + animal.getName() + "\n" + animal.Stats());
                    utility.printHeading("TO BATTLE!!!");
                    utility.enterToContinue();
                    Commons.clearConsole();
                    battle(hero, animal);
                    break;
                default:
                    System.out.println("You Encountered Nothing");
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void battle(NPC attacker, NPC defender) {
        Abilities attackerAbility = new Abilities("Basic", 10, 1);
        Abilities defenderAbility = new Abilities("Basic", 10, 1);
        int attackA = 0;
        int attackB = 0;
        int defAttSelection;
        boolean attackerIsTrue;
        if (attacker.initiative > defender.initiative) {
            attackerIsTrue = true;
        } else if (defender.initiative > attacker.initiative) {
            attackerIsTrue = false;
        } else {
            int randomFirst;
            Random randSelect = new Random();
            randomFirst = randSelect.nextInt(2);
            if (randomFirst == 0) {
                attackerIsTrue = true;
            } else {
                attackerIsTrue = false;
            }
        }
        while (attacker.hp > 0 && defender.hp > 0) {
            System.out.println(attacker.getName() + "                  |" + defender.getName()
                    + "\nHP = " + attacker.hp + " / " + attacker.maxHP + "          |HP = " + defender.hp + " / " + defender.maxHP
                    + "\nMANA = " + attacker.mana + " / " + attacker.getMana() + "       |MANA = " + defender.mana + " / " + defender.getMana()
                    + "\nARMOR = " + attacker.armor + " / " + attacker.getArmor() + "     |ARMOR = " + defender.armor + " / " + defender.getArmor()
                    + "\nDAMAGE= " + attacker.damage + "            |DAMAGE= " + defender.damage
                    + "\n\n");
            if (attackerIsTrue) {
                do {
                    System.out.print("|1| Basic" + attackerAbility.showAbilities(attacker.getType()) + "|4| Inventory \nCHOICE: ");
                    select();
                    if (selection == 1) {
                        attackA = attacker.attack();
                        break;
                    } else if (selection == 2 || selection == 3) {
                        attackerAbility = attackerAbility.getAbility(selection - 1, attacker.getType());
                        attackA = attackerAbility.getDmg() + attacker.attack();
                    } else if (selection == 4) {
                        if (hero.inventory.isEmpty()) {
                            System.out.print("Your Inventory is Empty, Select an Attack \nCHOICE :");
                            select();
                        } else {
                            hero.openInventory();
                            do {
                                System.out.println("Select an Item to Use \nCHOICE: ");
                                select();
                                if (selection <= hero.inventory.size()) {
                                    if (Objects.equals(hero.inventory.get(selection).getItemName(), "Armor Debuff") || Objects.equals(hero.inventory.get(selection).getItemName(), "Damage Debuff")) {
                                        defender.armor -= hero.inventory.get(selection).getItemArmor();
                                        defender.damage -= hero.inventory.get(selection).getItemDamage();
                                    } else {
                                        hero.inventory.get(selection);
                                        attacker.hp += hero.inventory.get(selection).getItemHp();
                                        attacker.mana += hero.inventory.get(selection).getItemMana();
                                        attacker.armor += hero.inventory.get(selection).getItemArmor();
                                        attacker.damage += hero.inventory.get(selection).getItemDamage();
                                        hero.inventory.remove(selection);
                                        attacker.Stats();
                                    }
                                }
                            } while (selection > hero.inventory.size());
                            break;
                        }
                    } else {
                        System.out.print("Select A proper Value\n");
                    }
                } while (selection > 4);
                attackerIsTrue = false;
            }

            Random randSelect = new Random();
            defAttSelection = randSelect.nextInt(3);
            if (defAttSelection == 0) {
                attackB = defender.attack();
                attackerIsTrue = true;
            } else {
                defenderAbility = defenderAbility.getAbility(defAttSelection, defender.getType());
                attackB = defenderAbility.getDmg() + defender.attack();
                attackerIsTrue = true;
            }
            defender.hp -= attackA;
            attacker.hp -= attackB;
            System.out.println("You Attacked with " + attackerAbility.getName() + "\n" + defender.getName() + " Attacked with " + defenderAbility.getName());
            System.out.println("You Did " + attackA + " Damage\n" + defender.getName() + " Did " + attackB + " Damage");
            if (defender.hp <= 0) {
                defender.hp = 0;
                System.out.println(defender.getName() + "DIED");
            }
            if (attacker.hp <= 0) {
                System.out.println("YOU DIED");
                mainMenu();
            }
        }
    }
}






