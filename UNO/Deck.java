/**
 * @(#)Deck.java
 *
 *
 * @author 
 * @version 1.00 2021/5/26
 */
import java.util.Random;
import java.util.ArrayList;
public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
    public Deck() {
    	initialize();
    	shuffle();
    }
    public void initialize(){
    	int index = 0;
    	for(int a = 1; a <= 2; a++){
    		for(int i = 1; i <= 4; i++){
    			for(int k = 0; k <= 9; k++){
    				Card card = new Card(k,i,0);
    				deck.add(card);
    			}
    		}
    	}
    	for(int i = 1; i <= 4; i++){
    		for(int a = 1; a <= 2; a++){
    			Card cardS = new Card(10,i,1);
    			deck.add(cardS);
    		}
    	}
    	for(int i = 1; i <= 4; i++){
    		for(int a = 1; a <= 2; a++){
    			Card cardS = new Card(11,i,2);
    			deck.add(cardS);
    		}
    	}
    	for(int i = 1; i <= 4; i++){
    		for(int a = 1; a <= 2; a++){
    			Card cardS = new Card(12,i,3);
    			deck.add(cardS);
    		}
    	}
    	for(int a = 1; a <= 4; a++){
    		Card cardV = new Card(13,0,4);
    		deck.add(cardV);
    	}
    	for(int a = 1; a <= 4; a++){
    		Card cardV = new Card(14,0,5);
    		deck.add(cardV);
    	}
    }
    public void shuffle(){
    	Random random = new Random();
    	for(int i = 0; i < 100000; i++){
    		int x = random.nextInt(deck.size()-1);
    		int y = random.nextInt(deck.size()-1);
    		Card card = deck.get(y);
    		deck.remove(y);
    		deck.add(x,card);
    	}
    }
    public boolean equal(ArrayList<Card> deeck,ArrayList<Card> deck){
    	for(int i = 0; i < deeck.size(); i++){
    		if(!deck.get(i).cardEqual(deeck.get(i),deck.get(i))){
    			return false;
    		}
    	}
    	return true;
    }
    public ArrayList<Card> getDeck(){
    	return deck;
    }
}