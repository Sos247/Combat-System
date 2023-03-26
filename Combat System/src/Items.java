import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Items {
    private String itemName;
    private int itemHp;
    private int itemMana;
    private int itemArmor;
    private int itemDamage;

    List<Items> itemsArray = new ArrayList<>();

    Items(String _name, int _hp, int _mana, int _armor, int _damage){

        itemName= _name;
        itemHp= _hp;
        itemMana= _mana;
        itemArmor= _armor;
        itemDamage = _damage;

    }
    public int getManaPot(){
        return +30;
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
        Items armorBooster = new Items("Armor Booster",0,0, 30,0);
        Items damageBoost = new Items("Damage Booster",0,0,0, 30);
        Items armorDebuff = new Items("Armor Debuff",0,0, - 20,0);
        Items damageDebuff = new Items("Damage Debuff",0,0,0, 15);

        itemsArray.add(healthPot);
        itemsArray.add(manaPot);
        itemsArray.add(armorBooster);
        itemsArray.add(damageBoost);
        itemsArray.add(armorDebuff);
        itemsArray.add(damageDebuff);

    }
    public Items itemDrop() {
        itemList();
        Items item;
            int dice;
            Random diceRoll = new Random();
            dice = diceRoll.nextInt(100);
            if (dice <= 40) {
                dice = diceRoll.nextInt(2);
                if (dice == 0) {
                    item = itemsArray.get(0);
                } else {
                    item = itemsArray.get(1);
                }
            } else if (dice <= 80) {
               dice = diceRoll.nextInt(2);
                if (dice == 0) {
                    item = itemsArray.get(2);
                } else {
                    item = itemsArray.get(3);
                }
            } else {
                dice = diceRoll.nextInt(2);
                if (dice == 0) {
                    item = itemsArray.get(4);
                } else {
                    item = itemsArray.get(5);
                }
            }
        return item;
    }
    public Items useItem(){
        Items item = new Items("de",0,0,0,0);
        return item;
    }

}