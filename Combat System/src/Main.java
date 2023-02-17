public class Main {
    public static void main(String[] args)
    {
        ClassSelection George = new ClassSelection();
        Randomizer steps = new Randomizer();


        George.selectClass();
        steps.setStepSize(3);
        steps.initialize();
    }
}