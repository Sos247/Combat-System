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
                        setStats("Barbarian",100,40,60,60);
                        allStatsTogether();
                        break;
                    case 2:

                        setStats("Rogue",100,40,40,80);
                        allStatsTogether();
                        break;
                    case 3:
                        setStats("Wizard", 100,80,20,40);
                        allStatsTogether();
                        break;
                    default:
                        System.out.print("Select a Proper value : ");
                        break;
                }
            } while (selection > 3 || selection < 1);
        }

        public int heroAttack(Enemy e) {
            int hAttack;
            Scanner input = new Scanner(System.in);
            System.out.println("Select Your Attack : 1.Basic  2.Slash  3. Charge");
            System.out.print("Choice : ");
            hAttack = input.nextInt();
            switch (hAttack) {
                case 1:
                    System.out.println("Basic");
                    hAttack = damage - e.armor;
                    break;
                case 2:
                    System.out.println("Slash");
                    hAttack = (damage + 15) - e.armor;
                    break;
                case 3:
                    System.out.println("Charge");
                    hAttack = (damage + 20) - e.armor;
                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
            return hAttack;
        }

    }
