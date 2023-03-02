public class Main {
    public static void main(String[] args)
    {
        Setup newGame = new Setup();
        Setup.Hero chooseHero = newGame.new Hero();
        Adventure newAdventure = new Adventure();

        chooseHero.selectClass();
        newAdventure.setDifficulty();
        newAdventure.initialize();

    }
}