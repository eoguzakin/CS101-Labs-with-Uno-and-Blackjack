/**
 * @(#)Functions.java
 *
 *
 * @author 
 * @version 1.00 2021/5/26
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Functions {
	public Scanner input = new Scanner(System.in);
	Deck Gdeck = new Deck();
	ArrayList<Card> player = new ArrayList<Card>();
	ArrayList<Card> dealer = new ArrayList<Card>();
	ArrayList<Card> deck = Gdeck.getDeck();
	public Card topCard;
	private int whoplays = 0;
	private int cardRow = 0;
	private boolean cardrow = false;
    public Functions() {
    	decideTopCard();
    	distribute7();
    	game();
    }
    public ArrayList<Card> getPlayerDeck(){
    	return player;
    }
    public ArrayList<Card> getDealerDeck(){
    	return dealer;
    }
    public void decideTopCard(){
    	for(int i = 0; i < deck.size(); i++){
    		Card card = deck.get(i);
    		if(card.getCardSpe() == 0){
    			topCard = card;
    			deck.remove(i);
    			break;
    		}
    	}
    }
    public void distribute7(){
    	for(int i = 0; i < 14; i++){
    		if(i%2==0){
    			player.add(deck.get(i));
    			deck.remove(i);
    		}
    		else{
    			dealer.add(deck.get(i));
    			deck.remove(i);
    		}
    	}
    }
    public void deckToString(){
    	for(int i = 0; i < deck.size(); i++){
    		System.out.println(deck.get(i).cardToString());
    	}
    }
    public void playerToString(){
    	for(int i = 0; i < player.size(); i++){
    		System.out.print(player.get(i).cardToString() + " | ");
    	}
    	System.out.println("");
    }
    public void dealerToString(){
    	for(int i = 0; i < dealer.size(); i++){
    		System.out.print(dealer.get(i).cardToString() + " | ");
    	}
    	System.out.println("");
    }
    public void addCard(ArrayList<Card> d, int x){
    	for(int i = 0; i < x; i++){
    		d.add(deck.get(i));
    		deck.remove(i);
    	}
    }
    public void displayTopCard(){
    	System.out.println("Top card is: " + topCard.cardToString());
    }
    public void playP(){
    	informPlayer();
    	int choice;
    	int playerState = 0;
    	playerToString();
    	System.out.print("Please enter your card choice(-1 to take a card): ");
    	choice = input.nextInt();
    	if(choice == -1){
    		if(cardRow > 0){
    			rowTriplet(player);
    		}
    		else{
    			addCard(player,1);
    			System.out.println(player.get(player.size()-1).cardToString() + " is added to your deck.");
    		}
    	}
    	else{
    		int whiles = 0;
    		Card playerC = player.get(choice);
    		while(!playerC.equal(playerC,topCard)){
    			System.out.print("Your card cannot be played! Select again: ");
    			choice = input.nextInt();
    			if(choice > -1 && choice < player.size()){
    				playerC = player.get(choice);
    				if(playerC.equal(playerC,topCard)){
    					player.remove(choice);
    					topCard = playerC;
    					rowTriplet(player);
    					whiles++;
    				}
    			}
    			else if(choice == -1){
    				System.out.println(deck.get(0).cardToString() + " is added to your deck.");
    				addCard(player,1);
    				whiles++;
    				break;
    			}
    		}/**/
    		if(whiles == 0){
    				playerC = player.get(choice);
    				player.remove(choice);
    				topCard = playerC;
    				rowTriplet(player);
    		}
    		if(topCard.getCardSpe() == 4){
    			System.out.print("State your colour choice(blue = 1, yellow = 2, red = 3, green = 4): ");
    			int cChoice = input.nextInt();
    				topCard.setCardSpe(0);
    				topCard.setCardCol(cChoice);
    				rowTriplet(player);
    		}
    		if(topCard.getCardSpe() == 5){
    			System.out.print("State your colour choice(blue = 1, yellow = 2, red = 3, green = 4): ");
    			int cChoice = input.nextInt();
    				topCard.setCardSpe(0);
    				topCard.setCardCol(cChoice);
    				rowTriplet(player);
    		}
    		playerState++;
    		if(playerState == 1){
    			if(topCard.getCardSpe() == 1 || topCard.getCardSpe() == 2){
    				displayTopCard();
    				playP();
    			}
    		}
    	}
    	if(player.size() == 1){
    		System.out.println("UNO!");
    	}
    	rowTriplet(player);
    }
    public void rowContinuoum(){
    	if(topCard.getCardSpe() == 5 && cardrow){
    		cardRow = cardRow + 4;
    	}
    	else if(topCard.getCardSpe() == 3 && cardrow){
    		cardRow = cardRow + 2;
    	}
    }
    public void rowAdder(ArrayList<Card> deeck, int row){
    	if(!cardrow && cardRow > 0){
    		for(int i = 0; i < row; i++){
    			System.out.print(deeck.get(i).cardToString() + " | ");
    		}
    		if(Gdeck.equal(deeck,player)){
    			System.out.println("are added to your deck as the " + row + " card row ends.");
    		}
    		addCard(deeck,row);
    		cardRow = 0;
    	}
    }
    public void rowDecider(ArrayList<Card> deck){
    	int x = 0;
    	for(int i = 0; i < deck.size(); i++){
    		Card card = deck.get(i);
    		if(card.getCardSpe() == 3 || card.getCardSpe() == 5){
    			x++;
    		}
    	}
    	if(x == 0){
    		cardrow = false;
    	}
    	else{
    		cardrow = true;
    	}
    }
    public void rowTriplet(ArrayList<Card> deck1){
    	rowDecider(deck1);
    	rowContinuoum();
    	rowAdder(deck1,cardRow);
    }
    public void playD(){
    	int dealerState = 0;
    	for(int i = 0; i < dealer.size(); i++){
    		Card dealerD = dealer.get(i);
    		if(dealerD.equal(dealerD, topCard)){
    			topCard = dealerD;
    			dealer.remove(i);
    			System.out.println("Dealer plays: " + topCard.cardToString());
    			dealerState++;
    			break;
    		}
    	}
    	if(dealer.size() == 1){
    		System.out.println("Dealer says UNO!");
    	}
    	if(dealerState == 0 && (topCard.getCardSpe() == 5 || topCard.getCardSpe() == 3)){
    		rowTriplet(dealer);
    	}
    	else if(dealerState == 1){
    		if(topCard.getCardSpe() == 5){
    			determineColour();
    		}
    		else if(topCard.getCardSpe() == 4){
    			determineColour();
    		}
    		else if(topCard.getCardSpe() == 1 || topCard.getCardSpe() == 2){
    			playD();
    		}
    	}
    	else if(dealerState == 0 && cardRow == 0){
    		if(topCard.getCardSpe()==0){
    			addCard(dealer,1);
    			System.out.println("Dealer takes a card from the deck.");
    		}
    	}
    	else if(topCard.getCardSpe() == 4 || topCard.getCardSpe() == 5){
    		determineState(dealer);
    	}
    	rowTriplet(dealer);
    }
    public void determineColour(){
    	Random random = new Random();
    	int rd = random.nextInt(3);
    	rd++;
    	if(topCard.getCardSpe() == 4 || topCard.getCardSpe() == 5){
    		int cChoice = rd;
    		topCard.setCardCol(cChoice);
    		System.out.println("Dealer says " + topCard.cardColourToString());
    	}
    }
    public void determineState(ArrayList<Card> deck){
    	if(topCard.getCardSpe() == 3){
    		cardRow = cardRow + 2;
    	}
    	else if(topCard.getCardSpe() == 5){
    		cardRow = cardRow + 4;
    	}
    	else{
    		addCard(deck,cardRow);
    		cardRow = 0;
    	}
    	System.out.println("card row is: " + cardRow);
    }
    public void informPlayer(){
    	System.out.println("Dealer has " + dealer.size() + " cards.");
    }
    public void game(){
    	int stateOfGame = 1;
    	do{
	    	do{
	    	displayTopCard();
	    	playP();
	    	playD();
	    	}while(player.size()!=0 && dealer.size()!=0);
	    	if(player.size() == 0){
	    		System.out.println("Congrats you won!");
	    	}
	    	else{
	    		System.out.println("Sorry you lost!");
	    	}
	    	System.out.println("Do you want to play again?(yes:1,no:-1)");
	    	stateOfGame = input.nextInt();
    	}while(stateOfGame == 1);
    	System.out.println("Bye!");
    }
    
}