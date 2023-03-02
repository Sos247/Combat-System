import java.util.Random;
import java.util.Scanner;

public class Setup {
    private int hp;
    private int mana;
    private int armor;

    private int damage;

    Setup() {

    }

    public void setStats(int _hp, int _mana, int _armor, int _dmg) {
        hp = _hp;
        mana = _mana;
        armor = _armor;
        damage = _dmg;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }

    public void allStatsTogether() {
        System.out.println("HP = " + getHp() +
                "\nMANA = " + getMana() +
                "\nARMOR = " + getArmor() +
                "\nDAMAGE = " + getDamage());
    }

    class Hero {
        public int hpEnemy = getHp();
        public int armorEnemy = getArmor();
        public void selectClass() {

            int selection;
            Scanner input = new Scanner(System.in);
            System.out.println("Select Your Class \n 1.Barbarian \n 2.Rogue \n 3.Wizard");
            System.out.print("Choice : ");
            do {
                selection = input.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("Barbarian");
                        Setup.this.setStats(100,30,70,60);
                        allStatsTogether();
                        break;
                    case 2:
                        System.out.println("Rogue");
                        Setup.this.setStats(60,45,25,30);
                        allStatsTogether();
                        break;
                    case 3:
                        System.out.println("Wizard");
                        Setup.this.setStats(70,100,40,30);
                        allStatsTogether();
                        break;
                    default:
                        System.out.print("Select a Proper value : ");
                        break;
                }
            } while (selection > 3 || selection < 1);
        }

        public int heroAttack() {

            int selectAttack;
            Scanner input = new Scanner(System.in);


            System.out.println("Select Your Attack : 1.Basic  2.Slash  3. Charge");
            System.out.print("Choice : ");
            selectAttack = input.nextInt();
            switch (selectAttack) {
                case 1:
                    System.out.println("Basic");
                    hpEnemy = hpEnemy - (getDamage() - armorEnemy);
                    System.out.println(" Enemy Remaining HP is " + hpEnemy);
                    break;
                case 2:
                    System.out.println("Slash");
                    hpEnemy = hpEnemy - ((getDamage() + 15) - armorEnemy);
                    System.out.println(" Enemy Remaining HP is " + hpEnemy);
                    break;
                case 3:
                    System.out.println("Charge");
                    hpEnemy = hpEnemy - ((getDamage() + 20) - armorEnemy);
                    System.out.println(" Enemy Remaining HP is " + hpEnemy);
                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
            return selectAttack;
        }
    }

    class Enemy {

        int classType;
        int hpHero = getHp();
        int armorHero = getArmor();
        int range = 3;
        public int encounterClass() {

            Random randSelect = new Random();
            classType = randSelect.nextInt(range);
            switch (classType) {

                case 0:
                    System.out.println("You Encounter a Barbarian");
                    Setup.this.setStats(100,30,70,60);
                    allStatsTogether();
                    break;
                case 1:
                    System.out.println("You Encounter a Rogue");
                    Setup.this.setStats(100,30,40,80);
                    allStatsTogether();
                    break;
                case 2:
                    System.out.println("You Encounter a Wizard");
                    Setup.this.setStats(100,70,20,40);
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

        public int enemyAttack() {


            Random enemyAttackSelection = new Random();
            int enemyAttack = enemyAttackSelection.nextInt(3);
            System.out.print("Enemy Attacked you with ");


            switch (enemyAttack) {
                case 0:
                    System.out.println("Basic");
                    hpHero = hpHero - (getDamage() - armorHero);
                    System.out.println(" Your Remaining HP is " + hpHero);
                    break;
                case 1:
                    System.out.println("Slash");
                    hpHero = hpHero - ((getDamage() + 15) - armorHero);
                    System.out.println(" Your Remaining HP is " + hpHero);
                    break;
                case 2:
                    System.out.println("Charge");
                    hpHero = hpHero - ((getDamage() + 20) - armorHero);
                    System.out.println(" Your Remaining HP is " + hpHero);
                    break;
            }
            return enemyAttack;
        }
    }
}


