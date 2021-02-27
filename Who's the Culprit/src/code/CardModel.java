package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class will be all the functionalities for the cards.
 * This includes the
 * 	-Deck
 * 	-Player's hand
 * 	-Envelope
 * 	-A shuffled deck
 * 	-Suggested cards
 * 
 * This class does not have any graphic interfaces. All the GUI will be in the gui.Gui. This class is where the
 * data will be made and how each card being represented. Methods will be specific for each individual function.
 * 
 * In order to not get messed up with the ClueModel class which contains the board, this class will be also be instantiated
 * in the gui.Gui class.
 * 
 * @author ZhiWen Huang
 *
 */
public class CardModel {

	private ArrayList<Card> deck;
	private ArrayList<Card> uniDeck;
	private ArrayList<Card> envelope;
	private ArrayList<Card> shuffled;
	
	public CardModel(){
		makeDeck();
		makeEnvelope();
		shuffleDeck();
		dealCards();
	}
	
	//Creates an ordered deck. Character,Room,Weapon.
	public void makeDeck(){
		deck = new ArrayList<Card>();
		uniDeck = new ArrayList<Card>();
		for(int c = 0; c < Card.characterCards; c++){
			deck.add(new Card(0,c));
			uniDeck.add(new Card(0,c));
		}
		for(int r = 0; r < Card.roomCards; r++){
			deck.add(new Card(1,r));
			uniDeck.add(new Card(1,r));
		}
		for(int w = 0; w < Card.weaponCards; w++){
			deck.add(new Card(2,w));
			uniDeck.add(new Card(2,w));
		}
	}
	
	//Creates the envelope. Character,Room,Weapon.
	public void makeEnvelope(){
		envelope = new ArrayList<Card>();
		Random ran = new Random();
		Card character = deck.get(ran.nextInt(Card.characterCards));
		Card room = deck.get(ran.nextInt(Card.characterCards)+Card.roomCards);
		Card weapon = deck.get(ran.nextInt(Card.characterCards)+Card.roomCards+Card.weaponCards);
		envelope.add(character);
		envelope.add(room);
		envelope.add(weapon);
		deck.remove(character);
		deck.remove(room);
		deck.remove(weapon);
	}
	
	// Shuffled the deck.
	public void shuffleDeck(){
		shuffled = new ArrayList<Card>();
		for(int i = 0; i < deck.size(); i++){
			shuffled.add(deck.get(i));
		}
		Collections.shuffle(shuffled);
	}
	
	// Deals the card to player's hand.
	public void dealCards(){
		for(Player player: ClueModel.playerList){
			while(player.getHand().size() != 3){
				player.getHand().add(shuffled.get(0));
				shuffled.remove(0);
			}
		}
	}
	
	public ArrayList<Card> getUni(){
		return uniDeck;
	}
	public ArrayList<Card> getDeck(){
		return deck;
	}
	
	public ArrayList<Card> getEnvelope(){
		return envelope;
	}
	
}
