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

    public String getItemName() {
        return itemName;
    }

    public int getItemHp() {
        return itemHp;
    }

    public int getItemMana() {
        return itemMana;
    }

    public int getItemArmor() {
        return itemArmor;
    }

    public int getItemDamage() {
        return itemDamage;
    }

    public void itemList() {
        Items healthPot = new Items("Health Pot",30,0,0,0);
        Items manaPot = new Items("Mana Pot",0,30,0,0);
        recoversArray.add(healthPot);
        recoversArray.add(manaPot);

        Items armorBooster = new Items("Armor Booster",0,0,30,0);
        Items damageBoost = new Items("Damage Booster",0,0,0,30);
        boostArray.add(armorBooster);
        boostArray.add(damageBoost);

        Items armorDebuff = new Items("Armor Debuff",0,0,20,0);
        Items damageDebuff = new Items("Damage Debuff",0,0,0,15);
        debuffsArray.add(armorDebuff);
        debuffsArray.add(damageDebuff);

    }
    public Items itemDrop() {
        itemList();
            Items item;
            int dice;
            Random diceRoll = new Random();
            dice = diceRoll.nextInt(100);
            if (dice <= 40) {
                dice = diceRoll.nextInt(2);
                if (dice == 1) {
                    item = recoversArray.get(0);
                    System.out.println("You Found a " + item.getItemName());
                } else {
                    item = recoversArray.get(1);
                    System.out.println("You Found a " + item.getItemName());
                }
            } else if (dice > 40 && dice <= 80) {
               dice = diceRoll.nextInt(2);
                if (dice == 1) {
                    item = boostArray.get(0);
                    System.out.println("You Found a " + item.getItemName());
                } else {
                    item = boostArray.get(1);
                    System.out.println("You Found a " + item.getItemName());
                }
            } else {
                dice = diceRoll.nextInt(2);
                if (dice == 1) {
                    item = debuffsArray.get(0);
                    System.out.println("You Found a " + item.getItemName());
                } else {
                    item = debuffsArray.get(1);
                    System.out.println("You Found a " + item.getItemName());
                }
            }
        return item;
    }

}