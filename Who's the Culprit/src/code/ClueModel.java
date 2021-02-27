package code;

import java.awt.Color;
import java.util.ArrayList;

/**
 * This is where all the game data will be written. This is the main class that describes how the game 
 * will work. Everything here is written to determine how the game will be played out.
 * 
 * 
 * @author ZhiWen Huang
 * @author Darren Chu
 *
 */
public class ClueModel {

	public static int ROW = 24;
	public static int COL = 25;
	public static ATile[][] board = new ATile[ROW][COL];
	public static ArrayList<Player> playerList;
	private CardModel model;
	private Observer observer;
	
	public ClueModel(){
		observer = null;
		createBoard();
		createPlayer();
		model = new CardModel();
	}
	
	/*
	 * This is the method where we creates the board.
	 * Since the map of the board  have some interesting patterns,
	 * rooms, doors, secret passages will be assign individually.
	 * Hallways will be the outline of the entire board. There 
	 * are also some empty spaces in the map of the board. That will
	 * also be assign individually.
	 * 
	 */
	public void createBoard(){
		
		//Hallway
		for(int i = 0; i < COL; i++){
			for(int j = 0; j < ROW; j++){
				board[j][i] = new HTile();
			}
		}
		
		//Left Side:
		//Room 1
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 4; j++){
				board[j][i] = new RTile();
				board[j][i].setName("The Android's Dungeon");
			}
		}
		
		//Room 2
		for(int i = 0; i < 7; i++){
			for(int j = 6; j < 11; j++){
				board[j][i] = new RTile();
				board[j][i].setName("The Frying Dutchman");
			}
		}
		
		//Room 3
		for(int i = 0; i < 6; i++){
			for(int j = 12; j < 17 ; j++){
				board[j][i] = new RTile();
				board[j][i].setName("The Simpson House");
			}
		}
		
		//Room 4
		for(int i = 0; i < 6; i++){
			for(int j = 19 ; j < 24; j++){
				board[j][i] = new RTile();
				board[j][i].setName("Springfield Retirement Castle");
			}
		}
		
		//Middle:
		//Room 5
		for(int i = 9; i < 15; i++){
			for(int j = 0; j < 7; j++){
				board[j][i] = new RTile();
				board[j][i].setName("Burns Manor");
			}
		}
		
		//Room 6
		for(int i = 8; i < 16; i++){
			for(int j = 17; j < 24; j++){
				board[j][i] = new RTile();
				board[j][i].setName("Nuclear Power Plant");
			}
		}
		
		//Right Side:
		//Room 7
		for(int i = 17; i < 25; i++){
			for(int j = 0; j < 6; j++){
				board[j][i] = new RTile();
				board[j][i].setName("Krustylu Studios");
			}
		}
		
		//Room 8
		for(int i = 16; i < 25; i++){
			for(int j = 9; j < 16; j++){
				board[j][i] = new RTile();
				board[j][i].setName("Barney's Bowl-A-Rama");
			}
		}
		//Room 9
		for(int i = 18; i < 25; i++){
			for(int j = 18; j < 24; j++){
				board[j][i] = new RTile();
				board[j][i].setName("Kwik-E-Mart");
			}
		}
		
		//Room 1 doors
		board[3][5] = new DTile();
		board[3][5].setName("The Android's Dungeon");
		
		//Room 2 doors
		board[8][6] = new DTile();
		board[10][3] = new DTile();
		board[8][6].setName("The Frying Dutchman");
		board[10][3].setName("The Frying Dutchman");;
		
		//Room 3 doors
		board[12][1] = new DTile();
		board[15][5] = new DTile();
		board[12][1].setName("The Simpson House");
		board[15][5].setName("The Simpson House");
		
		//Room 4 door
		board[19][4] = new DTile();
		board[19][4].setName("Springfield Retirement Castle");
		
		//Room 5 doors
		board[4][9] = new DTile();
		board[6][11] = new DTile();
		board[6][12] = new DTile();
		board[4][9].setName("Burns Manor");
		board[6][11].setName("Burns Manor");
		board[6][12].setName("Burns Manor");
		
		//Room 6 doors
		board[17][9] = new DTile();
		board[17][14] = new DTile();
		board[19][8] = new DTile();
		board[19][15] = new DTile();
		board[17][9].setName("Nuclear Power Plant");
		board[17][14].setName("Nuclear Power Plant");
		board[19][8].setName("Nuclear Power Plant");
		board[19][15].setName("Nuclear Power Plant");
		
		//Room 7 door
		board[5][18] = new DTile();
		board[5][18].setName("Krustylu Studios");
		
		//Room 8 door
		board[9][17] = new DTile();
		board[12][16] = new DTile();
		board[9][17].setName("Barney's Bowl-A-Rama");
		board[12][16].setName("Barney's Bowl-A-Rama");
		
		//Room 9 door
		board[18][19] = new DTile();
		board[18][19].setName("Kwik-E-Mart");
		
		//Deleted tiles && replacing tiles
		for(int i = 9; i < 14; i++){
			for(int j = 8; j < 15; j++){
				board[j][i] = new Empty();
			}
		}
		board[0][6] = new Empty();
		board[0][8] = new Empty();
		board[0][15] = new Empty();
		board[0][17] = new Empty();
		board[4][0] = new Empty();
		board[6][0] = new Empty();
		board[10][0] = new Empty();
		board[11][0] = new Empty();
		board[17][0] = new Empty();
		board[19][0] = new Empty();
		board[22][6] = new Empty();
		board[23][6] = new Empty();
		board[23][7] = new Empty();
		board[23][8] = new Empty();
		board[23][15] = new Empty();
		board[23][16] = new Empty();
		board[23][17] = new Empty();
		board[22][17] = new Empty();
		board[23][9] = new HTile();
		board[22][9] = new HTile();
		board[22][8] = new HTile();
		board[22][7] = new HTile();
		board[23][14] = new HTile();
		board[22][14] = new HTile();
		board[22][15] = new HTile();
		board[22][16] = new HTile();
		board[6][24] = new Empty(); 
		board[8][24] = new Empty(); 
		board[16][24] = new Empty(); 
		board[18][24] = new Empty(); 
		
		//Secret Passage
		board[0][0] = new STile();
		board[23][24] = new STile();
		board[23][0] = new STile();
		board[0][24] = new STile();
	}
		
	/*
	 * This method mainly to create the players. There are total of 6 players with unquie name, color,
	 * token, and their starting position on the board.
	 */
	public void createPlayer(){
		playerList = new ArrayList<Player>();
		Player scarlet = new Player(Color.RED,"Scarlet","A",0,5); //Scarlet
	scarlet.setTurn(true);
		Player plum = new Player(Color.ORANGE,"Plum","B",16,0); //Plum
		Player green = new Player(Color.GREEN,"Green","C",24,7); //Green
		Player white = new Player(Color.WHITE,"White","D",14,23); //White
		Player peacock = new Player(Color.BLUE,"Peacock","E",9,23); //Peacock
		Player mustard = new Player(Color.YELLOW,"Mustard","F",0,18); //Mustard
		playerList.add(scarlet);
		playerList.add(plum);
		playerList.add(green);
		playerList.add(white);
		playerList.add(peacock);
		playerList.add(mustard);
	}

	public ArrayList<Player> getList(){
		return playerList;
	}
	
	public void setObserver(Observer obs){
		observer = obs;
	}
	
	//Call update whenever the Gui made a change.
	public void makeChange(){
		if(observer != null){
			observer.update();
		}
	}

	// Method which get the next player turn.
	public Player getNextPlayer(Player current) {
		if(playerList.indexOf(current) == 0){
			return playerList.get(1);
		}
		if(playerList.indexOf(current) == 1){
			return playerList.get(2);
		}
		if(playerList.indexOf(current) == 2){
			return playerList.get(3);
		}
		if(playerList.indexOf(current) == 3){
			return playerList.get(4);
		}
		if(playerList.indexOf(current) == 4){
			return playerList.get(5);
		}
		if(playerList.indexOf(current) == 5){
			return playerList.get(0);
		}
		return null;
	}

	public ATile getTile(int x, int y){
		return board[y][x];
	}
	
	public CardModel getCardModel(){
		return model;
	}
}
