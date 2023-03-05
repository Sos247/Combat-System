import java.util.Scanner;

public class Hero extends NPC {

    public void selectClass() {

        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Your Class \n 1.Barbarian \n 2.Rogue \n 3.Wizard");
        System.out.print("Choice : ");
        do {
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    NPC.Classes.BARBARIAN;
                    allStatsTogether();
                    break;
                case 2:
                    NPC.Classes.ROGUE;
                    allStatsTogether();
                    break;
                case 3:
                    NPC.Classes.WIZARD;
                    allStatsTogether();
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
                hAttack = getDamage();
                break;
            case 2:
                System.out.println("Slash");
                hAttack = getDamage() + 15;
                break;
            case 3:
                System.out.println("Charge");
                hAttack = getDamage() + 20;
                break;
            default:
                System.out.print("Select a Proper value : ");
                break;
        }
        return hAttack;
    }

}

