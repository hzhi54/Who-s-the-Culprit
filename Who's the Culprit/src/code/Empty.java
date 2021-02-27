package code;

import java.awt.Color;

/**
 * This class is used as a empty tile object where we will not going to use the space. Just a blank
 * space.
 * 
 * @author ZhiWen Huang
 *
 */
public class Empty extends ATile{

	//Represent as GRAY.
	@Override
	public Color getColor() {
		return Color.GRAY;
	}

	//Cannot be use move.
	@Override
	public boolean walkable() {
		return false;
	}

	//Does nothing
	@Override
	public void setName(String n) {
	}
	
	//Does nothing
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
