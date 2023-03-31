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
        Items healthPot = new Items(Color.RED +"Health Pot"+Color.RESET,30,0,0,0);
        Items manaPot = new Items(Color.BLUE +"Mana Pot"+Color.RESET,0,30,0,0);
        Items armorBooster = new Items(Color.CYAN+"Armor Booster"+Color.RESET,0,0, 30,0);
        Items damageBoost = new Items(Color.YELLOW+"Damage Booster"+Color.RESET,0,0,0, 30);
        Items armorDebuff = new Items(Color.PURPLE+"Armor Debuff"+Color.RESET,0,0, 20,0);
        Items damageDebuff = new Items(Color.GREEN+"Damage Debuff"+Color.RESET,0,0,0, 15);

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


}