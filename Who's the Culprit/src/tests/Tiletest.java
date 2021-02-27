package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import code.ATile;
import code.DTile;
import code.Empty;
import code.HTile;
import code.RTile;
import code.STile;

/**
 * Test methods for the tiles.
 * 
 * @author Darren Chu
 *
 */
public class Tiletest {

	
	@Test
	public void testTiles(){
		
		DTile door = new DTile();
		assertEquals(door.getColor(),Color.PINK);
		assertTrue(door.walkable());
		
		Empty e = new Empty();
		assertEquals(e.getColor(),Color.GRAY);
		assertFalse(e.walkable());
		
		HTile hallway = new HTile();
		assertEquals(hallway.getColor(),Color.LIGHT_GRAY);
		assertTrue(hallway.walkable());
		
		RTile room = new RTile();
		assertEquals(room.getColor(),Color.BLACK);
		assertFalse(room.walkable());
		room.setName("Lounge");
		assertEquals(room.getName(),"Lounge");
		
		STile secret = new STile();
		assertEquals(secret.getColor(),Color.CYAN);
		assertFalse(secret.walkable());
		
		
		
	}
}
