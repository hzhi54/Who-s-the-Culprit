package code;

import java.awt.Color;

/**
 * This class will be use for a hallway object. All hallways
 * will be walkable for the players to be on.
 * 
 * 
 * @author ZhiWen Huang
 *
 */
public class HTile extends ATile{

	//Hallways will be the color LIGHT GRAY.
	@Override
	public Color getColor() {
		return Color.LIGHT_GRAY;
	}

	//Hallways are walkable.
	@Override
	public boolean walkable() {
		return true;
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
