public class Civilian extends NPC{
    public NPCType civilType;
    public String talk = "Hello Traveler, here is a free item for your journey";
    public Civilian(NPCType _type, String _name, int _hp, int _mana, int _armor, int _damage){
        super(_name,_hp,_mana,_armor,_damage);
        civilType = _type;
    }
    public String talk(){
        return talk;
    }
}
