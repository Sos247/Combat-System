package npcs;
import java.util.Random;

public class Enemy extends NPC{


    public Enemy(NPCType _eType, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative){
        super(_name, _hp, _mana, _armor, _damage, _initiative, _eType);
    }

    @Override
    public String npcTalk() {

        return "dialogue";
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
