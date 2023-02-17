import java.util.Random;

public class NPC extends ClassSelection{
    //name
    //classType
    //stats (hp, armor, mana)
    protected int hpNpc;
    protected int manaNpc;
    protected int armorNpc;

    protected int damageNpc;

    public void setStats(int _hpNpc, int _manaNpc, int _armorNpc, int _dmgNpc )
    {
        hpNpc = _hpNpc;
        manaNpc = _manaNpc;
        armorNpc = _armorNpc;
        damageNpc = _dmgNpc;
    }
    public int getHpNPC()
    {
        return hpNpc;
    }
    public int getManaNPC()
    {
        return manaNpc;
    }
    public int getArmorNPC()
    {
        return armorNpc;
    }

    public int getDamageNPC()
    {
        return damageNpc;
    }
    public void allStatsTogetherNPC()
    {
        System.out.println("HP = " + getHpNPC() +
                "\nMANA = " + getManaNPC() +
                "\nARMOR = " + getArmorNPC() +
                "\nDAMAGE = " + getDamageNPC());
    }
    int classType;
    public int encounterClass()
    {
        Random randSelect = new Random();

        classType = randSelect.nextInt(5);
        switch (classType)
        {

            case 0:
                System.out.println("You Encounter a Barbarian");
                setStats(100, 30, 50, 60);
                allStatsTogetherNPC();
                break;
            case 1:
                System.out.println("You Encounter a Rogue");
                setStats(60, 45, 25, 85);
                allStatsTogetherNPC();
                break;
            case 2:
                System.out.println("You Encounter a Wizard");
                setStats(70, 100, 40, 30);
                allStatsTogetherNPC();
                break;
            case 3:
                System.out.println("You Encountered Nothing");
                break;
            default:
                break;
        }

        return classType;
    }
}
