import java.util.ArrayList;
import java.util.Scanner;

public class Randomizer extends NPC
{
    private int steps;

    public void setStepSize(int _stepSize)
    {
        steps = _stepSize;

    }
    public int getStepsSize()
    {
        return steps;
    }

    public void initialize()
    {
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i<getStepsSize();)
        {

            path.add(encounterClass());

            if (classType >= 0 && classType <=2)
            {
                battle();
            }
            else
            {
                i++;
            }
        }

    }

    public void battle()
    {
        int selectAttack ;
        Scanner input = new Scanner(System.in);

        do
        {
            System.out.println("Select Your Attack : 1.Basic  2.Slash  3. Charge");
            System.out.print("Choice : ");
            selectAttack = input.nextInt();
            switch (selectAttack)
            {
                case 1:
                    System.out.println("Basic");
                    hpNpc = hpNpc - ( ClassSelection.getDamage() - getArmorNPC() );
                    System.out.println(classType + " Remaining HP is " + hpNpc);
                    break;
                case 2:
                    System.out.println("Slash");
                    hpNpc = hpNpc - ((ClassSelection.getDamage()+ 15) - getArmorNPC()) ;
                    System.out.println(classType + " Remaining HP is " + hpNpc);
                    break;
                case 3:
                    System.out.println("Charge");
                    hpNpc = hpNpc - ( (ClassSelection.getDamage()+ 20) - getArmorNPC() ) ;
                    System.out.println(classType + " Remaining HP is " + hpNpc);
                    break;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        }while(hpNpc > 0);

    }
}
