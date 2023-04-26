import npcsUtils.Abilities;
import npcsUtils.Items;
import npcs.*;
import npcsUtils.StatusEffects;
import tools.*;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Adventure{
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
        System.out.printf("%5s%40s%50s\n", "|1| " + Color.RED + "BARBARIAN" + Color.RESET,
                                                                      "|2| " + Color.GREEN + "ROGUE" + Color.RESET,
                                                                      "|3| " + Color.BLUE + "WIZARD" + Color.RESET);

        System.out.printf("%41s%59s%60s\n", Color.RED + "HP = " + heroBarb.hp + Color.RESET + " / " + Color.RED + heroBarb.getMaxHP() + Color.RESET,
                                                                        Color.RED + "HP = " + heroRog.hp + Color.RESET + " / " + Color.RED + heroRog.getMaxHP() + Color.RESET,
                                                                        Color.RED + "HP = " + heroWiz.hp + Color.RESET + " / " + Color.RED + heroWiz.getMaxHP() + Color.RESET);

        System.out.printf("%41s%57s%57s\n",Color.CYAN + "MANA = " + heroBarb.maxMana + Color.RESET + " / "+ Color.CYAN + heroBarb.getMaxMana() + Color.RESET,
                                                                       Color.CYAN + "MANA = " + heroRog.maxMana + Color.RESET + " / "+ Color.CYAN + heroRog.getMaxMana() + Color.RESET,
                                                                       Color.CYAN + "MANA = " + heroWiz.maxMana + Color.RESET + " / "+ Color.CYAN + heroWiz.getMaxMana() + Color.RESET);

        System.out.printf("%20s%34s%34s\n", "ARMOR = " + heroBarb.armor + " / " + heroBarb.getArmor(),
                                                                         "ARMOR = " + heroRog.armor + " / " + heroRog.getArmor() ,
                                                                         "ARMOR = " + heroWiz.armor + " / " + heroWiz.getArmor() );

        System.out.printf("%16s%36s%35s\n", "DAMAGE = " + heroBarb.damage,
                                                                       "DAMAGE = " + heroRog.damage,
                                                                       "DAMAGE = " + heroWiz.damage);
        System.out.print("\nCHOICE : ");
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
                Boss boss = new Boss(NPCType.DRAGON, "Dragonius", 250, 150, 90, 100, 16);
                battle(hero, boss);
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
        Abilities attackerAbility = new Abilities("Basic", attacker.getDamage(), 20,1, StatusEffects.AIR);
        Abilities defenderAbility = new Abilities("Basic", defender.getDamage(), 20,1,StatusEffects.BLEED);
        int attackA = 0;
        int attackB = 0;
        int turn = 1;
        int counter = 4;
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

utility.printHeading("TURN " + turn);
            System.out.printf("%S%40S\n%s%50s\n%s%48s\n%s%25s\n%s%27s\n\n", attacker.getName(), defender.getName(),
                    Color.RED + "HP = " + attacker.hp + Color.RESET + " / " + Color.RED + attacker.getMaxHP() + Color.RESET,
                    Color.RED + "HP = " + defender.hp + Color.RESET + " / " + Color.RED + defender.getMaxHP() + Color.RESET,
                    Color.CYAN + "MANA = " + attacker.mana + Color.RESET + " / "+ Color.CYAN + attacker.getMaxMana() + Color.RESET,
                    Color.CYAN + "MANA = " + defender.mana + Color.RESET + " / "+ Color.CYAN + defender.getMaxMana() + Color.RESET,
                    "ARMOR = " + attacker.armor + " / " + attacker.getArmor(),
                    "ARMOR = " + defender.armor + " / " + defender.getArmor(),
                    "DAMAGE = " + attacker.damage,
                    "DAMAGE = " + defender.damage);

            if (attackerIsTrue) {
                do {
                    System.out.print("|1| Basic " + attackerAbility.showAbilities(attacker.getType()) + " |4| Inventory \nCHOICE: ");
                    select();
                    //attackerAbility.getAbility(selection - 1, attacker.getType());
                    if (selection == 1) {
                        attackA = attacker.attack();
                        if(attacker.mana < attacker.maxMana) {
                            attacker.mana += attackerAbility.getManaCost();
                        }else {
                            continue;
                        }
                    } else if (selection == 2 || selection == 3) {
                        if(attacker.mana > attackerAbility.getManaCost()){
                            attackerAbility = attackerAbility.getAbility(selection - 1, attacker.getType());
                            attackA = attackerAbility.getDmg() + attacker.attack();
                            attacker.mana -= attackerAbility.getManaCost();
                            System.out.println("You enabled " + attackerAbility.getType().toString() + " on " + defender.getName() +" for the next " + turn + " turns");
                            counter--;
                        }else {
                            System.out.println("You don't have enough mana to cast this spell choose another attack");
                            selection = 0;
                            continue;
                        }

                    } else if (selection == 4) {
                        if (hero.inventory.isEmpty()) {
                            System.out.println("Your Inventory is Empty, Select an Attack");
                            selection = 0;
                            continue;
                        } else {
                            hero.openInventory();
                            do {
                                System.out.println("Select an Item to Use \nCHOICE: ");
                                select();
                                if (selection -1  <= hero.inventory.size()) {
                                    if (Objects.equals(hero.inventory.get(selection).getItemName(), "Armor Debuff") || Objects.equals(hero.inventory.get(selection).getItemName(), "Damage Debuff")) {
                                        defender.armor -= hero.inventory.get(selection).getItemArmor();
                                        defender.damage -= hero.inventory.get(selection).getItemDamage();
                                    } else {
                                        hero.inventory.get(selection);
                                        attacker.hp += hero.inventory.get(selection).getItemHp();
                                        attacker.maxMana += hero.inventory.get(selection).getItemMana();
                                        attacker.armor += hero.inventory.get(selection).getItemArmor();
                                        attacker.damage += hero.inventory.get(selection).getItemDamage();
                                        System.out.println("You used " + hero.inventory.get(selection).getItemName());
                                        hero.inventory.remove(selection);
                                        break;
                                    }
                                }
                            } while (selection > hero.inventory.size());
                        }
                        break;
                    } else {
                        System.out.print("Select A proper Value\n");
                    }
                } while (selection > 4 || selection <=0);
                if(selection ==2 || selection == 3){
                    attackerAbility.statusEffectTrigger(attackerAbility.getType(), defender);

                }
                if(selection >=1 && selection <=3) {
                    if (attackA <= defender.armor) {
                        System.out.println("Your Attack couldn't pierce " + defender.getName() + " Armor");
                    } else {
                        defender.hp -= attackA - defender.armor;
                        System.out.println("You Attacked with " + Color.PURPLE + attackerAbility.getName() + Color.RESET + " for " + (attackA - defender.armor) + " Damage");
                    }
                }
                if (defender.hp <= 0) {
                    defender.hp = 0;
                    System.out.println(defender.getName() + " DIED");
                    break;
                }
            }

            Random randSelect = new Random();
            defAttSelection = randSelect.nextInt(3);

            if (defAttSelection == 0) {
                attackB = defender.attack();
            } else {
                attackB = defenderAbility.getDmg() + defender.attack();
                defender.mana -= defenderAbility.getManaCost();
            }
            attackerIsTrue = true;
            if(attackB <= attacker.armor){
                System.out.println(defender.getName() + " Attack couldn't pierce your Armor");
                utility.enterToContinue();
                Commons.clearConsole();
                continue;
            }else {
                attacker.hp -= attackB - attacker.armor;
                System.out.println(defender.getName() + " Attacked with " + Color.PURPLE + defenderAbility.getName() +Color.RESET + " for " + (attackB -attacker.armor) + " Damage");
            }

            if (attacker.hp <= 0) {
                System.out.println("YOU DIED");
                Commons.clearConsole();
                mainMenu();
            }
            turn++;
            utility.enterToContinue();
            Commons.clearConsole();
        }
    }
}






