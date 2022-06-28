/**
 * @(#)Card.java
 *
 *
 * @author Oðuz Akýn
 * @version 1.00 2021/5/26
 */
public class Card {
	private int cardNum;
	private int cardCol;
	private int cardSpe;
    public Card(int cardNum, int cardCol, int cardSpe) {
    	this.cardNum = cardNum;
    	this.cardCol = cardCol;
    	this.cardSpe = cardSpe;
    }
    public int getCardNum(){
    	return cardNum;
    }
    public int getCardCol(){
    	return cardCol;
    }
    public int getCardSpe(){
    	return cardSpe;
    }
    public void setCardNum(int num){
    	cardNum = num;
    }
    public void setCardCol(int col){
    	cardCol = col;
    }
    public void setCardSpe(int spe){
    	cardSpe = spe;
    }
    public boolean equal(Card card, Card topCard){
    	if(card.cardSpe == 5)
    		return true;
    	else if(card.cardSpe == 4)
    		return true;
    	else if(card.cardNum < 10){
    		if(card.cardCol == topCard.cardCol){
    			return true;
    		}
    		else if(card.cardNum == topCard.cardNum){
    			return true;
    		}
    		return false;
    	}
    	else{
    		if(card.cardSpe == 1){
    			if(topCard.cardSpe == 1){
    				return true;
    			}
    			else if(card.cardCol == topCard.cardCol){
    				return true;
    			}
    			return false;
    		}
    		else if(card.cardSpe == 2){
    			if(topCard.cardSpe == 2){
    				return true;
    			}
    			else if(card.cardCol == topCard.cardCol){
    				return true;
    			}
    			return false;
    		}
    		else if(card.cardSpe == 3){
    			if(topCard.cardSpe == 5 || topCard.cardSpe == 3){
    				return true;
    			}
    			else if(card.cardCol == topCard.cardCol){
    				return true;
    			}
    			return false;
    		}
    	}
    	return false;
    }
    public boolean cardEqual(Card caard, Card card){
    	if(caard.cardCol == card.cardCol && card.cardNum == caard.cardNum && caard.cardSpe == card.cardSpe){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public String cardColourToString(){
    	String s = "";
    	
    	if(cardCol == 0){
    		s = "Black";
    	}
    	else if(cardCol == 1){
    		s = "Blue";
    	}
    	else if(cardCol == 2){
    		s = "Yellow";
    	}
    	else if(cardCol == 3){
    		s = "Red";
    	}
    	else if(cardCol == 4){
    		s = "Green";
    	}
    	return s;
    }
    public String cardToString(){
    	String s = "";
    	if(cardCol == 0){
    		if(cardNum == 13 && cardSpe == 4){
    			s = "Black Color Change";
    		}
    		else if(cardNum == 14 && cardSpe == 5){
    			s = "Black +4";
    		}
    	}
    	else if(cardCol == 1){
    		if(cardSpe == 1 && cardNum == 10){
    			s = "Blue Direction Change";
    		}
    		else if(cardSpe == 2 && cardNum == 11){
    			s = "Blue Pas";
    		}
    		else if(cardSpe == 3 && cardNum == 12){
    			s = "Blue +2";
    		}
    		else{
    			s = "Blue " + cardNum;
    		}
    	}
    	else if(cardCol == 2){
    		if(cardSpe == 1 && cardNum == 10){
    			s = "Yellow Direction Change";
    		}
    		else if(cardSpe == 2 && cardNum == 11){
    			s = "Yellow Pas";
    		}
    		else if(cardSpe == 3 && cardNum == 12){
    			s = "Yellow +2";
    		}
    		else{
    			s = "Yellow " + cardNum;
    		}
    	}
    	else if(cardCol == 3){
    		if(cardSpe == 1 && cardNum == 10){
    			s = "Red Direction Change";
    		}
    		else if(cardSpe == 2 && cardNum == 11){
    			s = "Red Pas";
    		}
    		else if(cardSpe == 3 && cardNum == 12){
    			s = "Red +2";
    		}
    		else{
    			s = "Red " + cardNum;
    		}
    	}
    	else if(cardCol == 4){
    		if(cardSpe == 1 && cardNum == 10){
    			s = "Green Direction Change";
    		}
    		else if(cardSpe == 2 && cardNum == 11){
    			s = "Green Pas";
    		}
    		else if(cardSpe == 3 && cardNum == 12){
    			s = "Green +2";
    		}
    		else{
    			s = "Green " + cardNum;
    		}
    	}
    	return s;
    }
    
}