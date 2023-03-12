public class Civilian extends NPC{
    public NPCType civilType;
    public Civilian(NPCType _type, String _name, int _hp, int _mana, int _armor, int _damage){
        super(_name,_hp,_mana,_armor,_damage);
        civilType = _type;
    }
    public void civilAction(){
        System.out.println("Hello Traveler, here is a free item for your journey");
    }
}
