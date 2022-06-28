/**
 * @(#)Game.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/5/1
 */
import java.util.Scanner;
import java.util.Arrays;
public class Game {
	//private scanner for the game
	private static Scanner input = new Scanner(System.in);
	//a new deck for the game
	private static Deck deck = new Deck();
	//game deck is declared
	private static Card[] gameDeck;
	//player and dealer hands are created for 11 cards
	Card playerHand[] = new Card[11];
    Card dealerHand[] = new Card[11];
    //player and dealer card values are set to 0
	private int playerCards = 0;
	private int dealerCards = 0;
	//state of game represents the winning side- 1)player -1)dealer 0)game is going on
	private int stateOfGame = 0;
	//hitOrStay is the choice of user
	private int hitOrStay = 0;
	
	//game object where deck is shuffled, game deck is assigned and game starts
    public Game(){
    	deck.shuffle();
    	gameDeck = deck.getDeck();
    	play();
    }
    //returns the deck of game
    public Deck getGameDeck(){
    	return deck;
    }
    //prints the parameter hand without the empty indexes
    public void printHand(Card[] hand){
    	for(int i = 0; i < hand.length; i++){
    		if(hand[i] != null){
    			System.out.println(hand[i]);
    		}
    	}
    }
    //determines the result according to the game rules
    //this method may use hitOrStay to decide
    public void determineResult(int hitOrStay){
    	if(playerCards == 21){
    		System.out.println("Blackjack!!\n");
    		System.out.println("Dealer hand:");
    		printHand(dealerHand);
    		System.out.println("Player: " + playerCards + " Dealer: " + dealerCards);
    		System.out.println("Congrats - You win!");
    		stateOfGame = 1;
    	}
    	else if(playerCards > 21){
    		System.out.println("Dealer hand:");
    		printHand(dealerHand);
    		System.out.println("Player: " + playerCards + " Dealer: " + dealerCards);
    		System.out.println("Sorry - you lose");
    		stateOfGame = -1;
    	}
    	else if(playerCards == dealerCards){
    		System.out.println("Dealer hand:");
    		printHand(dealerHand);
    		System.out.println("Player: " + playerCards + " Dealer: " + dealerCards);
    		System.out.println("Sorry - you lose");
    		stateOfGame = -1;
    	}
    	else if(dealerCards > 21){
    		System.out.println("Dealer hand:");
    		printHand(dealerHand);
    		System.out.println("Player: " + playerCards + " Dealer: " + dealerCards);
    		System.out.println("Congrats - You win!");
    		stateOfGame = 1;
    	}
    	else if(hitOrStay == 2){
    		if(Math.abs(21-dealerCards) < Math.abs(21-playerCards)){
    			System.out.println("Dealer hand:");
    			printHand(dealerHand);
    			System.out.println("Player: " + playerCards + " Dealer: " + dealerCards);
    			System.out.println("Sorry - you lose");
    			stateOfGame = -1;
    		}
    		else{
    			System.out.println("Your hand:");
    			printHand(playerHand);
    			System.out.println("Player: " + playerCards + " Dealer: " + dealerCards);
    			System.out.println("Congrats - You win!");
    			stateOfGame = 1;
    		}
    	}
    }
    //this is the heart of game
    public void play(){
    	//two cards are distributed to dealer and player from the game deck with skipping the index 0
    	//as the card at 0 is 0
    	playerHand[0] = gameDeck[1];
    	playerHand[1] = gameDeck[2];
    	dealerHand[0] = gameDeck[3];
    	dealerHand[1] = gameDeck[4];
    	//printing the current state
    	System.out.println("Your hand:");
    	printHand(playerHand);
    	//updating the values of cards for both player and dealer
    	playerCards = playerHand[0].getValue() + playerHand[1].getValue();
    	dealerCards = dealerHand[0].getValue() + dealerHand[1].getValue();
    	//creating index variables to move along the indexes
    	int indexPlayer = 1;
    	int indexDealer = 1;
    	int indexGameDeck = 4;
    	//while the game still goes on we play
    	while(stateOfGame == 0){
    		//asking the next move
    		System.out.print("\n(1)Hit or (2)Stay: ");
    		hitOrStay = input.nextInt();
    		//if hit
    		if(hitOrStay == 1){
    			indexPlayer++;
    			indexGameDeck++;
    			//taking the next card from the deck,displaying it and evaluating their values
    			playerHand[indexPlayer] = gameDeck[indexGameDeck];
    			System.out.println("Your hand:");
    			printHand(playerHand);
    			playerCards = playerCards + playerHand[indexPlayer].getValue();
    			//if current value is under 21 we go on
    			if(playerCards < 21){
    				continue;
    			}
    			//else we evaluate situation
    			else{
    				determineResult(hitOrStay);
    			}
    		}
    		//if stay
    		else if(hitOrStay == 2){
    			//while the dealer value is under 17, dealer takes cards from the deck
    			while(dealerCards < 17){
    				indexDealer++;
    				indexGameDeck++;
    				dealerHand[indexDealer] = gameDeck[indexGameDeck];
    				dealerCards = dealerCards + dealerHand[indexDealer].getValue();
    			}
    			//at the end we decide if we win or lose
    			determineResult(hitOrStay);
    		}
    	}
    	
    }
    
    
}