package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Card;

/**
 * @author weiyang chen
 */
public class Cardtest {

	@Test
	public void testCardToken(){
		Card character = new Card(0,0);
		assertEquals(character.getToken(),"Character");
		
		Card room = new Card(1,0);
		assertEquals(room.getToken(),"Room");
		
		Card weapon = new Card(2,0);
		assertEquals(weapon.getToken(),"Weapon");
		
		Card OutofOrder = new Card(3,0);
		assertFalse(OutofOrder.equals(weapon));
		assertFalse(OutofOrder.equals(room));
		assertFalse(OutofOrder.equals(character));
		
	}
	
	@Test
	public void testCardName(){
		//Card Character
		Card missScarlet = new Card(0,0);
		assertEquals(missScarlet.getName(),"Miss Scarlet");
		
		Card professorPlum = new Card(0,1);
		assertEquals(professorPlum.getName(),"Professor Plum");
		
		Card mrGreen = new Card(0,2);
		assertEquals(mrGreen.getName(),"Mr Green");
		
		Card mrsWhite = new Card(0,3);
		assertEquals(mrsWhite.getName(),"Mrs White");
		
		Card mrsPeacock = new Card(0,4);
		assertEquals(mrsPeacock.getName(),"Mrs Peacock");
		
		Card colMustard = new Card(0,5);
		assertEquals(colMustard.getName(),"Col Mustard");
		

		//Card Weapon
		Card plutoniumRod = new Card(2,0);
		assertEquals(plutoniumRod.getName(),"Plutonium Rod");
		
		Card necklace = new Card(2,1);
		assertEquals(necklace.getName(),"Necklace");
		
		Card extendOGlove = new Card(2,2);
		assertEquals(extendOGlove.getName(),"Extend O Glove");
		
		Card poisonedDonut = new Card(2,3);
		assertEquals(poisonedDonut.getName(),"Poisoned Donut");
		
		Card saxophone = new Card(2,4);
		assertEquals(saxophone.getName(),"Saxophone");
		
		Card slingshot = new Card(2,5);
		assertEquals(slingshot.getName(),"Slingshot");
		
		
		//Card Room Test
		Card theAndroidsDungeon = new Card(1,0);
		assertEquals(theAndroidsDungeon.getName(),"The Android's Dungeon");
		
		Card theFryingDutchman = new Card(1,1);
		assertEquals(theFryingDutchman.getName(),"The Frying Dutchman");
		
		Card theSimpsonHouse = new Card(1,2);
		assertEquals(theSimpsonHouse.getName(),"The Simpson House");
		
		Card springfieldRetirementCastle = new Card(1,3);
		assertEquals(springfieldRetirementCastle.getName(),"Springfield Retirement Castle");
		
		Card burnsManor = new Card(1,4);
		assertEquals(burnsManor.getName(),"Burns Manor");
		
		Card nuclearPowerPlant = new Card(1,5);
		assertEquals(nuclearPowerPlant.getName(),"Nuclear Power Plant");
		
		Card krustyluStudios = new Card(1,6);
		assertEquals(krustyluStudios.getName(),"Krustylu Studios");
		
		Card barneysBowlARama = new Card(1,7);
		assertEquals(barneysBowlARama.getName(),"Barney's Bowl-A-Rama");
		
		Card kwikEMart = new Card(1,8);
		assertEquals(kwikEMart.getName(),"Kwik-E-Mart");
		
	}
	
}
