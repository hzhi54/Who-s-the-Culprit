package code;

import java.util.Random;

/**
 * This class is the Dice class, where it will generate a random integer between 1 - 6.
 * 
 * Player's movement are limited so we will be using the random integer created by the dice class as the limit
 * of the player's movement.
 * 
 * @author ZhiWen Huang
 *
 */
public class Dice {
	
	private Random ran;
	private int x;
	
	public Dice(){
		ran = new Random();
	}
	
	//Generate a random integer from 1-6.
	public int roll(){		
		x = ran.nextInt(6) + 1;
		return x;
	}
	
	public boolean testDice(){
		if(x < 7 && x > 0){
			return true;
		}
		return false;
	}
}
