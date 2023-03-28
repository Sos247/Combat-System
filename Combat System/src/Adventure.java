import java.util.ArrayList;
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
            item = new Items("Default", 10, 10, 10, 10);
            int encounterRoll;
            Random randSelect = new Random();
            encounterRoll = randSelect.nextInt(7);
            String name;
            switch (encounterRoll) {
                case 0:
                    name = utility.randomName(Commons.barbarianNames);
                    enemy = new Enemy(NPCType.BARBARIAN, name, 100, 40, 60, 60, 9);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.etype);
                    enemy.Stats();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 1:
                    name = utility.randomName(Commons.rogueNames);
                    enemy = new Enemy(NPCType.ROGUE, name, 100, 30, 45, 80, 15);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.etype);
                    enemy.Stats();
                    utility.printHeading("TO BATTLE!!!");
                    battle(hero, enemy);
                    break;
                case 2:
                    name = utility.randomName(Commons.wizardNames);
                    enemy = new Enemy(NPCType.WIZARD, name, 100, 80, 30, 45, 13);
                    System.out.println("You Encountered " + enemy.getName());
                    System.out.println("CLASS = " + enemy.etype);
                    enemy.Stats();
                    utility.printHeading("TO BATTLE!!!");
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
                    animal = new Animal(NPCType.ANIMAL, "Boar", 80, 0, 60, 50, 6);
                    System.out.println("Animal " + animal.getName());
                    animal.Stats();
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

//    public void battle(NPC attacker, NPC defender) {
//
//        //int itemSelection;
//        while (attacker.hp > 0 && defender.hp > 0) {
//            if (attackerIsTrue) {
//
//            } else {
//
//
//                if (defenderHP <= 0) {
//                    defender.hp = 0;
//                    System.out.println(defender.getName() + " DIED");
//                    break;
//                } else {
//                    if (defender == enemy) {
//                        enemy.Stats();
//                    } else {
//                        animal.Stats();
//                    }
//                    System.out.println(defender.getName() + " HP = " + defenderHP + " / " + defender.getHp());
//                }
//            }
//
//        } else{
//
//        }
//    }

    public void battle(NPC attacker, NPC defender) {
        boolean attackerIsTrue;
        int attackerHP = attacker.hp;
        int attackerMana = attacker.mana;
        int attackerArmor = attacker.armor;
        int attackerDamage = attacker.damage;

        int defenderHP = defender.hp;
        int defenderArmor = defender.armor;
        int defenderMana = defender.mana;
        int defenderDamage = defender.damage;

        if (attacker.initiative > defender.initiative) {
            attackerIsTrue = true;
        } else if(defender.initiative > attacker.initiative){
            attackerIsTrue = false;
        }else{
            int randomFirst;
            Random randSelect = new Random();
            randomFirst = randSelect.nextInt(2);
            if(randomFirst == 0){
                attackerIsTrue = true;
            }else{
                attackerIsTrue = false;
            }
        }
        while (attackerHP > 0 && defenderHP > 0) {
            if (attackerIsTrue) {
                do {
                    System.out.print("Select Your Attack : |1| Basic  |2| Slash  |3| Charge |4| Inventory \nChoice: ");
                    select();
                    if (selection == 1) {
                        System.out.println("You Attacked with Basic");
                        defenderHP = attacker.attack() - defenderArmor;
                        break;
                    } else if (selection == 2) {
                        System.out.println("You Attacked with Slash");
                        defenderHP -= (attacker.attack() + 10) - defenderArmor;
                        break;
                    } else if (selection == 3) {
                        System.out.println("You Attacked with Charge");
                        defenderHP -= (attacker.attack() + 20) - defenderArmor;
                        break;

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
                                    if(Objects.equals(hero.inventory.get(selection).getItemName(), "Armor Debuff") || Objects.equals(hero.inventory.get(selection).getItemName(), "Damage Debuff")){
                                        defenderArmor -= hero.inventory.get(selection).getItemArmor();
                                        defenderDamage -= hero.inventory.get(selection).getItemDamage();
                                    }else{
                                        hero.inventory.get(selection);
                                        attackerHP += hero.inventory.get(selection).getItemHp();
                                        attackerMana += hero.inventory.get(selection).getItemMana();
                                        attackerArmor += hero.inventory.get(selection).getItemArmor();
                                        attackerDamage += hero.inventory.get(selection).getItemDamage();
                                        hero.inventory.remove(selection);
                                        hero.Stats();
                                    }
                                }
                            } while (selection > hero.inventory.size());
                            break;
                        }
                    } else {
                        System.out.println("Select A Proper Value");
                    }
                } while (selection > 4);
                attackerIsTrue = false;
                if (defenderHP <= 0) {
                    defender.hp = 0;
                    System.out.println(defender.getName() + " DIED");
                    break;
                } else {
                    System.out.println(defender.getName() + " HP = " + defenderHP + " / " + defender.getHp());
                }
            } else {
                System.out.println(defender.getName() + " ATTACKS YOU ");
                attackerHP -= defender.attack() - attacker.getArmor();
                if (attackerHP <= 0) {
                    attacker.hp = 0;
                    System.out.println(attacker.getName() + " YOU DIED");
                    mainMenu();
                } else {
                    System.out.println("YOUR REMAINING HP = " + attackerHP + " / " + attacker.getHp());
                }
                attackerIsTrue = true;
            }
        }
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
                item.itemsArray.iterator();
                break;
            case 2:
                System.exit(0);
        }
    }
}