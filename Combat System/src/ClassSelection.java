import java.util.Scanner;
public class ClassSelection
{
    protected int hp;
    protected int mana;
    protected int armor;

    static int damage;
    public void setStats(int _hp, int _mana, int _armor, int _dmg )
    {
        hp = _hp;
        mana = _mana;
        armor = _armor;
        damage = _dmg;
    }
    public int getHp()
    {
        return hp;
    }
    public int getMana()
    {
        return mana;
    }
    public int getArmor()
    {
        return armor;
    }

    public static int getDamage()
    {
        return damage;
    }
    public void allStatsTogether()
    {
        System.out.println("HP = " + getHp() +
                "\nMANA = " + getMana() +
                "\nARMOR = " + getArmor() +
                "\nDAMAGE = " + getDamage());
    }
    public void selectClass()
    {
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Your Class \n 1.Barbarian \n 2.Rogue \n 3.Wizard");
        System.out.print("Choice : ");
        do
        {
            selection = input.nextInt();
            switch (selection)
            {
                case 1:
                    System.out.println("Barbarian");
                    setStats(100, 30, 70, 60);
                    allStatsTogether();
                    break;
                case 2:
                    System.out.println("Rogue");
                    setStats(60, 45, 25, 85);
                    allStatsTogether();
                    break;
                case 3:
                    System.out.println("Wizard");
                    setStats(70, 100, 40, 30);
                    allStatsTogether();
                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        }while(selection >3 || selection <1);
    }
}

