import java.util.ArrayList;
import java.util.List;

public class Items {
    private String itemName;
    private int itemHp;
    private int itemMana;
    private int itemArmor;
    private int itemDamage;


    Items(String _name, int _hp, int _mana, int _armor, int _damage){

        itemName= _name;
        itemHp= _hp;
        itemMana= _mana;
        itemArmor= _armor;
        itemDamage = _damage;

    }

    public void itemList(Items _recovers[], Items _boosts[], Items _debuffs[]) {
        ArrayList<Items> recovers = new ArrayList<>(List.of
                (new Items("Health Pot",30,0,0,0),
                 new Items("ManaPot",0,30,0,0)));
        ArrayList<Items> boosts = new ArrayList<>(List.of(
                 new Items("Armor Booster",0,0,30,0),
                 new Items("Damage Booster",0,0,0,30)));
        ArrayList<Items> debuffs = new ArrayList<>(List.of(
                new Items("Armor Debuff",0,0,20,0),
                new Items("Damage Debuff",0,0,0,15)));

    }

}
