package utils;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Commons {

    public static String[] civilianNames = {"George", "Paul", "Keith"};
    public static String[] barbarianNames = {"Kelthos The Mountainwalker", "Akyros The Hoardslayer","Ulos The Skullsmasher"};
    public static String[] rogueNames = {"Meletis The Sweetspeaker", "Anthos The Backstabber","Terenios Swiftfoot"};
    public static String[] wizardNames = {"Rubios Cosmotraveler", "Seretis The Smokepuffer", "Filios The Uranomaster"};

    public Scanner scanner = new Scanner(System.in);


    //[1]----method to simulate clearing out the console (adding EMPTY lines)----
    public static void clearConsole() {
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
        int selection = scanner.nextInt();
    }
    public String randomName (String[]names){

        int index = new Random().nextInt(names.length);
        return names[index];
    }
    public static void cls(){
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
        }
catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}