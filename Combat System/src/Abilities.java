import npcs.NPCType;

import java.util.ArrayList;
import java.util.List;

public class Abilities {

    private int dmg;
    private int id;
    private String name;


    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    public int getId() {
        return id;
    }

    List<Abilities> barbArray = new ArrayList<>();
    List<Abilities> rogArray = new ArrayList<>();
    List<Abilities> wizArray = new ArrayList<>();
    List<Abilities> hawkArray = new ArrayList<>();
    List<Abilities> boarArray = new ArrayList<>();
    List<Abilities> lionArray = new ArrayList<>();



    public Abilities(String _name, int _dmg, int _id){
        name = _name;
        dmg = _dmg;
        id = _id;
    }

    public void abilityList(){

        Abilities basic = new Abilities("Basic", getDmg(),1);

        Abilities slash = new Abilities("Slash", +10, 2);
        Abilities charge = new Abilities("Charge", +15, 3);

        Abilities backstab = new Abilities("Backstab", +20, 2);
        Abilities daggerThrow = new Abilities("Dagger Throw", +30, 3);

        Abilities fireball = new Abilities("Fireball",+20,2);
        Abilities thunderstorm = new Abilities("Thunderstorm", +30, 3);

        Abilities wings = new Abilities("Wingflap", +10,2);
        Abilities feathers = new Abilities("Feather Swing", +25,3);

        Abilities squeal = new Abilities("Squeal", 15, 2);
        Abilities tusk = new Abilities("Tusks", 35,3);

        Abilities claw = new Abilities("Claws",20,2);
        Abilities rawr= new Abilities("Rawr", 25,3);

        barbArray.add(slash);
        barbArray.add(charge);
        rogArray.add(backstab);
        rogArray.add(daggerThrow);
        wizArray.add(fireball);
        wizArray.add(thunderstorm);
        hawkArray.add(wings);
        hawkArray.add(feathers);
        boarArray.add(squeal);
        boarArray.add(tusk);
        lionArray.add(claw);
        lionArray.add(rawr);
    }

    public Abilities getAbility(int _id , NPCType _type){
        abilityList();
        if(_type == NPCType.BARBARIAN) {
            return barbArray.get(_id - 1);
        }else if(_type == NPCType.ROGUE){
                return rogArray.get(_id - 1);
            }else if(_type == NPCType.WIZARD) {
            return wizArray.get(_id - 1);
        }else if(_type == NPCType.HAWK) {
            return hawkArray.get(_id - 1);
        }else if(_type == NPCType.BOAR) {
            return boarArray.get(_id - 1);
        }else
            return lionArray.get(_id - 1);
    }
    public String showAbilities(NPCType _type){
        abilityList();
        if(_type == NPCType.BARBARIAN) {
            return "|2| " +barbArray.get(0).getName() + " |3| " + barbArray.get(1).getName() ;
        }else if(_type == NPCType.ROGUE){
            return "|2| " +rogArray.get(0).getName() + " |3| " + rogArray.get(1).getName() ;
        }else
            return "|2| " +wizArray.get(0).getName() + " |3| " + wizArray.get(1).getName() ;
    }
}
