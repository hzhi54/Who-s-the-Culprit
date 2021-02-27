package code;

import java.awt.Color;

/**
 * This class will be use as a Room object. Room will be given a name for specific room
 * and also they are not walkable. Room tile also referred as the wall for which player
 * cannot walk over the wall to enter the room. 
 * 
 * @author ZhiWen Huang
 *
 */
public class RTile extends ATile{

	private String name;
	
	public RTile(){
		name = null;
	}
	
	//Room will be the color BLACK.
	@Override
	public Color getColor() {
		return Color.BLACK;
	}

	//Room is not walkable.
	@Override
	public boolean walkable() {
		return false;
	}
	
	//Gives a name for this room;
	@Override
	public void setName(String n){
		name = n;
	}
	
	//Return name.
	@Override
	public String getName(){
		return name;
	}

}
