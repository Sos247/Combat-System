import java.util.Scanner;

public class Hero extends NPC {

    public NPCType type;

    public Hero(NPCType _type, String _name, int _hp, int _mana, int _armor, int _damage) {

        super(_name, _hp, _mana, _armor, _damage);
        
        type = _type;
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

