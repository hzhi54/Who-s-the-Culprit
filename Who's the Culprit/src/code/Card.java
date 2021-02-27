package code;

import java.util.ArrayList;
/**
 * 
 * 
 * @author ZhiWen Huang
 * @author Weiyang Chen
 *
 */
public class Card {

	
	public static int characterCards = 6;
	public static int roomCards = 9;
	public static int weaponCards = 6;
	public static int totalCards = 21;
	
	private int type;
	private int rep;
	private ArrayList<String> cList;
	private ArrayList<String> wList;
	private ArrayList<String> rList;
	private String cardToken;
	private String cardName;
	
	public Card(int cardType, int cardRepresent){
		giveNames();
		type = cardType;
		rep = cardRepresent;
		giveCardToken();
		giveCardRep(cardRepresent);
	}
	
	public void giveNames(){
		//Character names
		cList = new ArrayList<String>();
		cList.add("Miss Scarlet");
		cList.add("Professor Plum");
		cList.add("Mr Green");
		cList.add("Mrs White");
		cList.add("Mrs Peacock");
		cList.add("Col Mustard");
	
		//Weapon names
		wList = new ArrayList<String>();
		wList.add("Plutonium Rod");
		wList.add("Necklace");
		wList.add("Extend O Glove");
		wList.add("Poisoned Donut");
		wList.add("Saxophone");
		wList.add("Slingshot");
		
		//Room names
		rList = new ArrayList<String>();
		rList.add("The Android's Dungeon");
		rList.add("The Frying Dutchman");
		rList.add("The Simpson House");
		rList.add("Springfield Retirement Castle");
		rList.add("Burns Manor");
		rList.add("Nuclear Power Plant");
		rList.add("Krustylu Studios");
		rList.add("Barney's Bowl-A-Rama");
		rList.add("Kwik-E-Mart");
	}
	
	public void giveCardToken(){
		if(type == 0){
			cardToken = "Character";
		}
		if(type == 1){
			cardToken = "Room";
		}
		if(type ==2){
			cardToken = "Weapon";
		}
	}
	
	public void giveCardRep(int rep){
		if(type == 0){
			if(rep >= 0 && rep <= characterCards){
				for(int i = 0; i < characterCards; i++){
					if(rep == i){
						cardName = cList.get(i);
					}
				}
			}
		}
		if(type == 2){
			if(rep >= 0 && rep <= weaponCards){
				for(int i = 0; i < weaponCards; i++){
					if(rep == i){
						cardName = wList.get(i);
					}
				}
			}
		}
		if(type == 1){
			if(rep >= 0 && rep <= roomCards){
				for(int i = 0; i < roomCards; i++){
					if(rep == i){
						cardName = rList.get(i);
					}
				}
			}
		}
	}
	
	public int getType(){
		return type;
	}
	
	public int getRep(){
		return rep;
	}
	
	public String getName(){
		return cardName;
	}
	
	public String getToken(){
		return cardToken;
		}

}
