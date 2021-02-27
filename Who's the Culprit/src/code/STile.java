package code;

import java.awt.Color;

/**
 * This class will use as a Secret Passage object. The secret passage will not able 
 * to be walked on. Will be inside specific room and only few will appear.
 * 
 * @author ZhiWen Huang
 *
 */
public class STile extends ATile{

	private String name;
	
	//Secret Passage have the color DARK GRAY.
	@Override
	public Color getColor() {
		return Color.CYAN;
	}

	//Secret Passage is not walkable.
	@Override
	public boolean walkable() {
		return false;
	}

	//Give a the room name;
	@Override
	public void setName(String n) {
		name = n;
	}

	//Return name.
	@Override
	public String getName() {
		return name;
	}

}
