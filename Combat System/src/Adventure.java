import java.util.ArrayList;
import java.util.Scanner;

public class Adventure extends Setup {
    private int steps;

    Adventure() {
        super();
    }

    public void setDifficulty() {
        int difficulty;
        Scanner input = new Scanner(System.in);
        System.out.println("Select Difficulty \n 1.Easy(5 Steps) \n 2.Normal(10 Steps) \n 3.Hard(15 Steps)");
        System.out.print("Choice : ");

        do {
            difficulty = input.nextInt();

            switch (difficulty) {
                case 1:
                    steps = 5;
                    break;
                case 2:
                    steps = 10;
                    break;
                case 3:
                    steps = 15;
                default:
                    System.out.print("Select a Proper value : ");
                    break;
            }
        } while (difficulty > 3 || difficulty < 1);

    }

    public int getDifficulty() {
        return steps;
    }

    public void initialize() {
        Enemy encounter = new Enemy();
        Enemy classType = new Enemy();
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < getDifficulty(); ) {

            path.add(encounter.encounterClass());

            if (classType.classType >=0 && classType.classType <=2) {
                battle();
            } else {
                i++;
            }
        }

    }

    public void battle() {
        Hero heroBattle = new Hero();
        Enemy enemyBattle = new Enemy();
        do {
            heroBattle.heroAttack();
            enemyBattle.enemyAttack();

        } while (heroBattle.hpEnemy > 0 || enemyBattle.hpHero > 0);

    }
}
