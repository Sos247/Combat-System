package npcs;
import java.util.Random;

public class Enemy extends NPC{

    public NPCType eType;

    public Enemy(NPCType _eType, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative){
        super(_name, _hp, _mana, _armor, _damage, _initiative);
        eType = _eType;
    }

    @Override
    public String npcTalk() {
        Random selectAbility = new Random();
        String dialogue = "";
        int select;
        select = selectAbility.nextInt(3);
        if (select == 0) {
            dialogue= "Hahaha, That did nothing";
        } else
            switch (eType) {
                case BARBARIAN:
                    if (select == 1) {
                        dialogue = "Hmm, Your Power is Increasing";
                        break;
                    } else {
                        dialogue= "At Last, A true Battle";
                        break;
                    }
                case ROGUE:
                    if (select == 1) {
                        dialogue= "I should've dodge that";
                        break;
                    } else {
                        dialogue= "Im fading";
                        break;
                    }
                case WIZARD:
                    if (select == 1) {
                        dialogue= "The Void is consuming me";
                        break;
                    } else {
                        dialogue= "I failed my Order";
                        break;
                    }
            }
        return dialogue;
    }

    @Override
    public int useAbility(int i) {
        Random selectAbility = new Random();
        int select;
        select = selectAbility.nextInt(3);
        if (select == 0) {
            return damage;
        } else
            switch (eType) {
                case BARBARIAN:
                    if (select == 1) {
                        return damage + 10;
                    } else {
                        return damage + 15;
                    }
                case ROGUE:
                    if (select == 1) {
                        this.armor -= 60 / 100;
                        return damage;
                    } else {
                        return damage + 30;
                    }
                case WIZARD:
                    if (select == 1) {
                        return damage + 20;
                    } else {
                        return damage + 30;
                    }
            }
        return select;
    }
    @Override
    public String abilities() {
        return "";
    }

    @Override
    public int attack(){
        return getDamage();
    }
}
