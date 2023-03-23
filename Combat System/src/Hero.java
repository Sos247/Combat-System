import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hero extends NPC {
    public NPCType type;
    private List<Items> inventory = new ArrayList<>();

    public Hero(NPCType _type, String _name, int _hp, int _mana, int _armor, int _damage) {

        super(_name, _hp, _mana, _armor, _damage);
        
        type = _type;
    }

    public int attack() {
        int attack;
        Scanner input = new Scanner(System.in);
        attack = input.nextInt();
        switch (attack) {
            case 1:
                System.out.println("Basic");
                attack = getDamage();
                break;
            case 2:
                System.out.println("Slash");
                attack = getDamage() + 15;
                break;
            case 3:
                System.out.println("Charge");
                attack = getDamage() + 20;
                break;
            case 4:
                openInventory();
                break;
            default:
                System.out.print("Select a Proper value : ");
                break;
        }
        return attack;
    }
    public void fillInventory(Items item){
        inventory.add(item);
    }
    public void openInventory(){
        for(Items item : inventory){
            System.out.println("-> " + item.getItemName());
        }
    }
    public int useItem(){
        return 0;
    }
}

