import java.util.Scanner;

public class Hero extends NPC{

    private classes hero;
    public void selectClass() {

        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Your Class \n 1.Barbarian \n 2.Rogue \n 3.Wizard");
        System.out.print("Choice : ");
        do {
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    hero = classes.BARBARIAN;
                    hero.allStatsTogether();
                    break;
                case 2:
                    hero = classes.ROGUE;
                    hero.allStatsTogether();
                    break;
                case 3:
                    hero = classes.WIZARD;
                    hero.allStatsTogether();

                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        } while (selection > 3 || selection < 1);
    }

    public int heroAttack() {
        int hAttack;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Your Attack : 1.Basic  2.Slash  3. Charge");
        System.out.print("Choice : ");
        hAttack = input.nextInt();
        switch (hAttack) {
            case 1:
                System.out.println("Basic");
                hAttack = hero.getDamage();
                break;
            case 2:
                System.out.println("Slash");
                hAttack = hero.getDamage() + 15;
                break;
            case 3:
                System.out.println("Charge");
                hAttack = hero.getDamage() + 20;
                break;
            default:
                System.out.print("Select a Proper value : ");
                break;
        }
        return hAttack;
    }

}

