package tests;
import static org.junit.Assert.*;

/**
 * This class mainly to test if dice function properly.
 * 
 * @author Jason Lin
 */

import org.junit.Test;
import code.Dice;
public class Dicetest {

	@Test
	public void Dicetest(){
		Dice dice = new Dice();
		dice.roll();
		assertTrue(dice.testDice());
		int i = dice.roll();
		assertFalse(i>6);
		assertFalse(i<=0);
	}
	
}
