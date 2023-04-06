package npcs;

import java.util.Random;

public class Animal extends NPC{

    public NPCType aType;
    public Animal(NPCType _aType, String _name, int _hp, int _mana, int _armor, int _damage, int _initiative){
        super(_name, _hp, _mana, _armor, _damage, _initiative);
        aType = _aType;
    }

    @Override
    public String npcTalk() {
        return "";
    }

    @Override
    public int useAbility(int i) {
        return 0;
    }

    @Override
    public String abilities() {
        return "";
    }

    @Override
    public int attack(){
        return getDamage() / 2 + 5;
    }
    public NPCType animalType(){

        Random random = new Random();
        int dice;
        dice = random.nextInt(3);
        switch (dice){
            case 0:
                aType = NPCType.HAWK;
                break;
            case 1:
                aType =NPCType.BOAR;
                break;
            case 2:
                aType = NPCType.LION;
                break;
        }
        return aType;
    }

    public String getAnimal()
    {
        return aType.toString();
    }
}

