import java.io.IOException;
import java.util.Scanner;

public class UtilityMethods {

    public Scanner scanner = new Scanner(System.in);
    private int selection;


    //[1]----method to simulate clearing out the console (adding EMPTY lines)----
    public void clearConsole() {
        for (int i = 0; i < 20; i++)
            System.out.println();
    }

    //[2]----//method to print a separator with length 'n' (adding separators)----
    public void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //[3]----//method to print a heading----
    public void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //[4]----//method to stop the game until user enters anything (pause for the user to read or take a break)----
    public void enterToContinue() {
        System.out.print("Press " + "\u001B[32m" + "ENTER " + "\u001B[0m" + "To Continue ...");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void select() {
        selection = scanner.nextInt();
    }
}