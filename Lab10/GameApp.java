/**
 * @(#)GameApp.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/5/1
 */
import java.util.Arrays;
import java.util.Scanner;
public class GameApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //sateOfPlay is the state if user plays for another round or not
        String stateOfPlay = "";
        //each time user plays, a new game is created, decks are shuffled and values are
        //set to their original
        do{
        	Game game = new Game();
        	System.out.print("Play Again? (y/n):");
        	stateOfPlay = input.next();
        }while(stateOfPlay.equals("y"));
        System.out.println("Thanks for playing - Goodbye!");
    }
}
