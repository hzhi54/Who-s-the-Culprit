package code;

import java.awt.Color;

/**
 * This is an abstract class for the tiles I will be using for the board.
 * In this class, there will be abstract methods so that each different tile
 * will have a define the methods individually.
 * 
 * @author ZhiWen Huang
 */
public abstract class ATile {
	
	//Assign a color for the tile.
	public abstract Color getColor();
	
	//Assign true if tile is walkable.
	public abstract boolean walkable();

	//Assign a name for room tile only.
	public abstract void setName(String n);

	//Return name.
	public abstract String getName();
	
}
