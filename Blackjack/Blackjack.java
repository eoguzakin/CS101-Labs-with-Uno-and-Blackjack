import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blackjack implements ActionListener {
    JFrame frame;
    JButton hit;
    JButton stay;
    JButton playAgain;
    JLabel playerLabel;
    JLabel dealerLabel;
    JLabel title;
    JLabel status;
    JLabel resultad;
    JTextArea statusDisplay;
    JTextArea playerHander;
    JTextArea dealerHander;
    JTextArea resultDisplay;
    Deck deck = new Deck();
    Card[] playerHand = new Card[11];
    Card[] dealerHand = new Card[11];
    Card[] gameDeck = deck.getDeck();
    int deckIndex = 4;
    int playerIndex = 2;
    int dealerIndex = 2;
    int playerCards;
    int dealerCards;
    int hitOrStay = 0;
    int stateOfGame = 0;
    public Blackjack(){
        start();
    }
    public void GUIBlackjack(){
        frame = new JFrame("Blackjack");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(60,155,90));
        hit = new JButton("HIT");
        stay = new JButton("STAY");
        playAgain = new JButton("PLAY AGAIN");
        hit.setBounds(100,300,80,40);
        stay.setBounds(190,300,80,40);
        playAgain.setBounds(280,300,120,40);
        playerLabel = new JLabel("Your hand:");
        dealerLabel = new JLabel("Dealer hand:");
        title = new JLabel("BLACKJACK");
        status = new JLabel("Game State:");
        resultad = new JLabel("Results:");
        playerLabel.setFont(new Font("Serif",Font.BOLD,14));
        dealerLabel.setFont(new Font("Serif",Font.BOLD,14));
        title.setFont(new Font("Serif",Font.BOLD,21));
        status.setFont(new Font("Serif",Font.BOLD,14));
        resultad.setFont(new Font("Serif",Font.BOLD,14));
        playerLabel.setForeground(new Color(255,255,255));
        dealerLabel.setForeground(new Color(255,255,255));
        title.setForeground(new Color(255,255,255));
        status.setForeground(new Color(255,255,255));
        resultad.setForeground(new Color(255,255,255));
        playerLabel.setBounds(30,100,80,20);
        dealerLabel.setBounds(30,150,80,20);
        title.setBounds(180,20,131,80);
        status.setBounds(30,200,80,20);
        resultad.setBounds(30,250,80,20);
        playerHander = new JTextArea("");
        dealerHander = new JTextArea("");
        statusDisplay = new JTextArea("");
        resultDisplay = new JTextArea("");
        playerHander.setBounds(120,100,310,30);
        dealerHander.setBounds(120,150,310,30);
        statusDisplay.setBounds(120,200,310,30);
        resultDisplay.setBounds(120,250,310,30);
        playerHander.setEditable(false);
        dealerHander.setEditable(false);
        dealerHander.setVisible(false);
        dealerLabel.setVisible(false);
        status.setVisible(false);
        statusDisplay.setVisible(false);
        resultDisplay.setVisible(false);
        resultad.setVisible(false);
        hit.addActionListener(this);
        playerHander.setVisible(true);
        stay.addActionListener(this);
        playAgain.addActionListener(this);
        frame.add(hit);
        frame.add(stay);
        frame.add(playAgain);
        frame.add(playerLabel);
        frame.add(dealerLabel);
        frame.add(title);
        frame.add(status);
        frame.add(resultad);
        frame.add(playerHander);
        frame.add(dealerHander);
        frame.add(statusDisplay);
        frame.add(resultDisplay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == hit){
            playerHand[playerIndex] = gameDeck[deckIndex];
            playerCards += playerHand[playerIndex].getValue();
            playerIndex++;
            deckIndex++;
            playerHander.setText(deckToString(playerHand));
            hitOrStay = 1;
            determineResult(hitOrStay);
        }
        else if(e.getSource() == stay){
            while(dealerCards < 17){
                dealerHand[dealerIndex] = gameDeck[deckIndex];
                dealerCards = dealerCards + dealerHand[dealerIndex].getValue();
                dealerIndex++;
                deckIndex++;
            }
            hitOrStay = -1;
            determineResult(hitOrStay);
        }
        else if(e.getSource() == playAgain){
            dealerLabel.setVisible(false);
            dealerHander.setVisible(false);
            statusDisplay.setVisible(false);
            resultDisplay.setVisible(false);
            status.setVisible(false);
            resultad.setVisible(false);
            dealerHander.setText("");
            resultDisplay.setText("");
            statusDisplay.setText("");
            deck = new Deck();
            gameDeck = deck.getDeck();
            playerHand = new Card[11];
            dealerHand = new Card[11];
            stateOfGame = 0;
            distribute();
            playerHander.setText(deckToString(playerHand));
        }
    }
    public void distribute(){
        playerHand[0] = gameDeck[0];
        playerHand[1] = gameDeck[1];
        dealerHand[0] = gameDeck[2];
        dealerHand[1] = gameDeck[3];
        playerCards = playerHand[0].getValue() + playerHand[1].getValue();
        dealerCards = dealerHand[0].getValue() + dealerHand[1].getValue();
        playerHander.setText(deckToString(playerHand));
        dealerHander.setText(deckToString(dealerHand));
    }
    public void start(){
        GUIBlackjack();
        distribute();
        playerHander.setText(deckToString(playerHand));
    }
    public String deckToString(Card[] hand){
        String s = "";
        for(int a = 0; a < hand.length; a++){
            if(hand[a] != null){
                s = s + hand[a].toString() + ",";
            }
        }
        return s;
    }
    public void determineResult(int hitOrStay){
        String s = "Player: " + playerCards + " Dealer: " + dealerCards;
        if(playerCards == 21){
            statusDisplay.setText("Blackjack!! Congrats - You win!");
            stateOfGame = 1;
        }
        else if(playerCards > 21){
            statusDisplay.setText("Sorry - you lose");
            stateOfGame = -1;
        }
        else if(playerCards == dealerCards){
            statusDisplay.setText("Sorry - you lose");
            stateOfGame = -1;
        }
        else if(dealerCards > 21){
            statusDisplay.setText("Congrats - You win!");
            stateOfGame = 1;
        }
        else if(hitOrStay == -1){
            if(Math.abs(21-dealerCards) < Math.abs(21-playerCards)){
                statusDisplay.setText("Sorry - you lose");
                stateOfGame = -1;
            }
            else{
                statusDisplay.setText("Congrats - You win!");
                stateOfGame = 1;
            }
        }
        if(stateOfGame == 1 || stateOfGame == -1){
            dealerHander.setText(deckToString(dealerHand));
            dealerHander.setVisible(true);
            dealerLabel.setVisible(true);
            status.setVisible(true);
            statusDisplay.setVisible(true);
            resultad.setVisible(true);
            resultDisplay.setVisible(true);
            resultDisplay.setText(s);
        }
    }
}
