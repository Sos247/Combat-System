import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Items {
    private String itemName;
    private int itemHp;
    private int itemMana;
    private int itemArmor;
    private int itemDamage;

    List<Items> recoversArray = new ArrayList<>();
    List<Items> boostArray = new ArrayList<>();
    List<Items> debuffsArray = new ArrayList<>();


    Items(String _name, int _hp, int _mana, int _armor, int _damage){

        itemName= _name;
        itemHp= _hp;
        itemMana= _mana;
        itemArmor= _armor;
        itemDamage = _damage;

    }

    public void itemList() {

        recoversArray.add(new Items("Health Pot",30,0,0,0));
        recoversArray.add(new Items("Mana Pot",0,30,0,0));

        boostArray.add(new Items("Armor Booster",0,0,30,0));
        boostArray.add(new Items("Damage Booster",0,0,0,30));

        debuffsArray.add(new Items("Armor Debuff",0,0,20,0));
        debuffsArray.add(new Items("Damage Debuff",0,0,0,15));

    }
    public Items itemDrop() {
            Items item;
            int dice;
            Random diceRoll = new Random();
            dice = diceRoll.nextInt(100);
            if (dice >= 0 && dice <= 40) {
                diceRoll.nextInt(2);
                if (dice == 1) {
                    item = recoversArray.get(0);
                    System.out.println("You Found a " + item);
                } else {
                    item = recoversArray.get(1);
                    System.out.println("You Found a " + item);
                }
            } else if (dice > 40 && dice <= 80) {
                diceRoll.nextInt(2);
                if (dice == 1) {
                    item = boostArray.get(0);
                    System.out.println("You Found a " + item);
                } else {
                    item = boostArray.get(1);
                    System.out.println("You Found a " + item);
                }
            } else {
                diceRoll.nextInt(2);
                if (dice == 1) {
                    item = debuffsArray.get(0);
                    System.out.println("You Found a " + item);
                } else {
                    item = debuffsArray.get(1);
                    System.out.println("You Found a " + item);
                }
            }
        return item;
    }

}