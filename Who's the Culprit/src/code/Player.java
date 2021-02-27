package code;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the Player class. In this class, we treat a player object as our token of the game. Gui will only update when
 * the player moves to a different location. Player being treated as token, we given a name for specific player name and 
 * a token name. The token name is what will represent on the board, and the player name will represent on the command
 * panel. Each individual player also get it their own color. Color are determined by specific player name. Location is a 
 * way to change where we will set the tile on the board. We will start off the players on a specific tile according to 
 * the rules of the game Clue. 
 * 
 * @author ZhiWen Huang
 *
 */
public class Player {
	
	
	private Color color;
	private String name;
	private String token;
	private int x;
	private int y;
	private ATile onTile;
	private boolean onTurn;
	private Point location;
	private ArrayList<Card> handCard;
	
	public Player(Color c, String n, String t, int x, int y){
		location = new Point();
		color = c;
		name = n;
		token = t;
		this.x = x;
		this.y = y;
		onTurn = false;
		location.setLocation(y, x);
		handCard = new ArrayList<Card>();
		setTile(); // The tile it will be on the board.
	}
	
	public ArrayList<Card> getHand(){
		return handCard;
	}
	public Color getColor(){
		return color;
	}
	public String getName(){
		return name;
	}
	public String getToken(){
		return token;
	}
	public Point getLocation(){
		return location;
	}
	public ATile getTile(){
		return onTile;
	}	
	public void setTile(){
		onTile = ClueModel.board[location.x][location.y];
	}
	public void setTurn(boolean turn){
		onTurn = turn;
	}
	public boolean getTurn(){
		return onTurn;
	}
}
