import java.io.IOException;

public class Main {


    public static void main(String[] args){
        Adventure newAdventure = new Adventure();
        newAdventure.init();
    }
}



//        throws InterruptedException {
//        int hp = 100;
//        int mana = 60;
//
//        while (hp > 0) {
//
//        System.out.print("\rHP = " + hp+ "\rMana =" +mana+"\n");
//        hp -= 10;
//        mana -=10;
//        Thread.sleep(500);
//        }