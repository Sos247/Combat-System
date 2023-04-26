package npcsUtils;

import npcs.NPC;
import npcs.NPCType;

import java.util.ArrayList;
import java.util.List;

public class Abilities {

    private int dmg;
    private int id;

    private int manaCost;

    private String name;

    private StatusEffects type;

    public StatusEffects getType() {
        return type;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }


    List<Abilities> barbArray = new ArrayList<>();
    List<Abilities> rogArray = new ArrayList<>();
    List<Abilities> wizArray = new ArrayList<>();
    List<Abilities> hawkArray = new ArrayList<>();
    List<Abilities> boarArray = new ArrayList<>();
    List<Abilities> lionArray = new ArrayList<>();



    public Abilities(String _name, int _dmg, int _manaCost, int _id, StatusEffects _type){
        name = _name;
        dmg = _dmg;
        manaCost = _manaCost;
        id = _id;
        type = _type;
    }

    public void abilityList(){

        Abilities slash = new Abilities("Slash", 10, 20,2,StatusEffects.BLEED);
        Abilities charge = new Abilities("Charge", 15, 30,3,StatusEffects.BLEED);

        Abilities backstab = new Abilities("Backstab", 20, 20,2,StatusEffects.BLEED);
        Abilities daggerThrow = new Abilities("Dagger Throw", 30, 30,3,StatusEffects.POISON);

        Abilities fireball = new Abilities("Fireball",20,20,2,StatusEffects.FIRE);
        Abilities thunderstorm = new Abilities("Thunderstorm", 30, 30,3,StatusEffects.ELECTRIC);

        Abilities wings = new Abilities("Wingflap", 10,0,2,StatusEffects.AIR);
        Abilities feathers = new Abilities("Feather Swing", 25,0,3,StatusEffects.AIR);

        Abilities squeal = new Abilities("Squeal", 15, 0,2,StatusEffects.ECHO);
        Abilities tusk = new Abilities("Tusks", 35,0,3,StatusEffects.BLEED);

        Abilities claw = new Abilities("Claws",20,0,2,StatusEffects.BLEED);
        Abilities rawr= new Abilities("Rawr", 25,0,3,StatusEffects.ECHO);

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

    public int statusEffectTrigger(StatusEffects effect, NPC combatant){
        int effectType = 0;

                if(effect == StatusEffects.BLEED){
                    return combatant.hp -= 5;
                }else if(effect == StatusEffects.POISON)
                {
                    return  combatant.armor -= 5;
                } else if (effect == StatusEffects.FIRE) {
                    return combatant.damage -= 5;
                }

        return effectType;
    }
}
