import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Items {
    private String itemName;
    private int itemHp;
    private int itemMana;
    private int itemArmor;
    private int itemDamage;
    private  Items item;

    private ArrayList<Items> recoversArray;
    private ArrayList<Items> boostArray;
    private ArrayList<Items> debuffsArray;


    Items(String _name, int _hp, int _mana, int _armor, int _damage){

        itemName= _name;
        itemHp= _hp;
        itemMana= _mana;
        itemArmor= _armor;
        itemDamage = _damage;

    }

    public void itemList() {
        ArrayList<Items> recovers = new ArrayList<>(List.of
                (new Items("Health Pot",30,0,0,0),
                        new Items("Mana Pot",0,30,0,0)));
        ArrayList<Items> boosts = new ArrayList<>(List.of(
                new Items("Armor Booster",0,0,30,0),
                new Items("Damage Booster",0,0,0,30)));
        ArrayList<Items> debuffs = new ArrayList<>(List.of(
                new Items("Armor Debuff",0,0,20,0),
                new Items("Damage Debuff",0,0,0,15)));
        recoversArray = recovers;
        boostArray = boosts;
        debuffsArray = debuffs;
    }
    public Items itemDrop() {
        try {

            int dice;
            Random diceRoll = new Random();
            dice = diceRoll.nextInt(100);
            if (dice >= 0 && dice <= 40) {
                diceRoll.nextInt(2);
                if (dice == 1) {
                    System.out.println("You Found a " + item.recoversArray.get(0));
                } else {
                    System.out.println("You Found a " + item.recoversArray.get(1));
                }
            } else if (dice > 40 && dice <= 80) {
                diceRoll.nextInt(2);
                if (dice == 1) {

                    System.out.println("You Found a " + item.boostArray.get(0));
                } else {
                    System.out.println("You Found a " + boostArray.get(1));
                }
            } else {
                diceRoll.nextInt(2);
                if (dice == 1) {

                    System.out.println("You Found a " + item.debuffsArray.get(0));
                } else {
                    System.out.println("You Found a " + item.debuffsArray.get(1));
                }
            }

        } catch (Exception e) {
            System.out.println("Dont know why");
        }
        return item;
    }

}