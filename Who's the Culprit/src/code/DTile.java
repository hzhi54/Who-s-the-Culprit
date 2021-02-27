package code;

import java.awt.Color;

/**
 * This class will be use as a door for the board. Our game mechanism
 * is that we want the player to decided rather if they want to enter the
 * room or not. So we let door to be walkable.
 * 
 * @author ZhiWen Huang
 *
 */
public class DTile extends ATile{

	private String name;
	
	public DTile(){
		name = null;
	}
	//Door color will be pink.
	@Override
	public Color getColor() {
		return Color.PINK;
	}

	//Door will be walkable.
	@Override
	public boolean walkable() {
		return true;
	}

	//Does nothing
	@Override
	public void setName(String n) {
		name = n;
	}

	//Does nothing
	@Override
	public String getName() {
		return name;
	}

}
