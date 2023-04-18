package npcs;

public class Civilian extends NPC{
    public NPCType civilType;
    public String talk = "Hello Traveler, here is a free item for your journey";
    public Civilian(NPCType _type, String _name, int _hp, int _mana, int _armor, int _damage,int _initiative){

        super(_name,_hp,_mana,_armor,_damage, _initiative, _type);

        civilType = _type;
    }

    @Override
    public String npcTalk() {
        return "";
    }


    @Override
    public String abilities() {
        return "";
    }

}
