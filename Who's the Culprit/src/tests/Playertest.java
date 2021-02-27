package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.tools.DocumentationTool.Location;

import org.junit.Test;

import code.ClueModel;
import code.HTile;
import code.Player;

/**
 * Test method for player
 * 
 * @author Darren Chu
 */

public class Playertest {
	
	@Test
	public void testPlayer(){
		ClueModel model = new ClueModel();
		
		Player scarlet = model.getList().get(0);
		assertEquals(scarlet.getColor(),Color.RED);
		assertEquals(scarlet.getName(),"Scarlet");
		assertEquals(scarlet.getToken(),"A");
		assertEquals(scarlet.getLocation().y,0);
		assertEquals(scarlet.getLocation().x,5);
		assertEquals(scarlet.getTile(),model.getTile(0, 5));
		assertTrue(scarlet.getTurn());
		
		
		Player plum = model.getList().get(1);
		assertEquals(plum.getColor(),Color.ORANGE);
		assertEquals(plum.getName(),"Plum");
		assertEquals(plum.getToken(),"B");
		assertEquals(plum.getLocation().y,16);
		assertEquals(plum.getLocation().x,0);
		assertEquals(plum.getTile(),model.getTile(16, 0));
		assertFalse(plum.getTurn());
		
		
		Player green = model.getList().get(2);
		assertEquals(green.getColor(),Color.GREEN);
		assertEquals(green.getName(),"Green");
		assertEquals(green.getToken(),"C");
		assertEquals(green.getLocation().y,24);
		assertEquals(green.getLocation().x,7);
		assertEquals(green.getTile(),model.getTile(24, 7));
		assertFalse(green.getTurn());
		
		
		Player white = model.getList().get(3);
		assertEquals(white.getColor(),Color.WHITE);
		assertEquals(white.getName(),"White");
		assertEquals(white.getToken(),"D");
		assertEquals(white.getLocation().y,14);
		assertEquals(white.getLocation().x,23);
		assertEquals(white.getTile(),model.getTile(14, 23));
		assertFalse(white.getTurn());
		
		
		Player peacock = model.getList().get(4);
		assertEquals(peacock.getColor(),Color.BLUE);
		assertEquals(peacock.getName(),"Peacock");
		assertEquals(peacock.getToken(),"E");
		assertEquals(peacock.getLocation().y,9);
		assertEquals(peacock.getLocation().x,23);
		assertEquals(peacock.getTile(),model.getTile(9, 23));
		assertFalse(peacock.getTurn());
		
		
		Player mustard = model.getList().get(5);
		assertEquals(mustard.getColor(),Color.YELLOW);
		assertEquals(mustard.getName(),"Mustard");
		assertEquals(mustard.getToken(),"F");
		assertEquals(mustard.getLocation().y,0);
		assertEquals(mustard.getLocation().x,18);
		assertEquals(mustard.getTile(),model.getTile(0, 18));
		assertFalse(mustard.getTurn());
	}

}
