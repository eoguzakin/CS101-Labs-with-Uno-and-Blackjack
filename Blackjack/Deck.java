import java.util.Arrays;
import java.util.Random;
public class Deck {
	//a new deck
	private Card[] deck = new Card[52];
	//the first card is initialized as top card
	private Card topCard = deck[0];
	
    public Deck(){
    	initialize();
		shuffle();
    }
    //gets the deck
    public Card[] getDeck(){
    	return deck;
    }
    //fills the deck for each suit with all values
    public void initialize(){
    	//max number of values
    	int val = 13;
    	//max number of suits
    	int suit = 4;
    	//starting index for the deck
    	int index = 0;
    	//for every suit, 13 value types are assigned and created a new card
    	for(int i = 1; i <= 4; i++){
    		for(int x = 1; x <= 13; x++){
    			Card card = new Card(i,x);
    			//adding each card to deck
    			deck[index] = card;
    			index++;
    		}
    	}
    }
    //shuffles the deck by changing random index cards from deck
    public void shuffle(){
    	Random random = new Random();
	    Card temp;
	    for(int i=0; i<200; i++)
	    {
	        int index1 = random.nextInt(deck.length-1);
	        int index2 = random.nextInt(deck.length-1);
	        temp = deck[index2];
	        deck[index2] = deck[index1];
	        deck[index1] = temp;
	    }
    }
    //string representation of a deck
    public String deckToString(){
    	String s = "";
    	for(int i = 0; i < deck.length; i++){
    		if(i < deck.length-1)
    			s = s + deck[i].toString() + " , ";
    		else
    			s = s + deck[i].toString();
    	}
    	return s;
    }
}