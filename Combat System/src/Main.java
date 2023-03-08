public class Main {
    public static void main(String[] args)
    {
        Hero newHero = new Hero();
        Enemy newEnemy = new Enemy();
        Adventure newAdventure = new Adventure();

        newHero.selectClass();
        newAdventure.setDifficulty();
        newAdventure.initialize(newHero, newEnemy);



    }
}