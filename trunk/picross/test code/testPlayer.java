package testpicross;

import junit.framework.TestCase;
import picross.Player;;



public class testPlayer extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1:5 (set up of maxHP, curHP)
	public void testConstructor() 
	{
		Player test = new Player(5);
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),5);
	}

	// Test case 2: -1 (test the function of descreaseHP() )
	public void testdecreaseHP1() 
	{
		Player test = new Player(5);
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),5);
		
		test.decreaseHP(1);
		
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),4);
		
	}
	
	// Test case 3: -2 (test the function of descreaseHP() )
	public void testdecreaseHP2() 
	{
		Player test = new Player(5);
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),5);
		
		test.decreaseHP(1);
		
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),4);
		
	}
	
	// Test case 4: -2 (test the function of restoreHP() )
	public void testRestoreHP() 
	{
		Player test = new Player(5);
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),5);
		
		test.decreaseHP(1);
		
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),4);
		
		test.restoreHP();
		
		assertEquals(test.getMaxHP(),5);
		assertEquals(test.getCurHP(),5);
		
	}
	// Test case 5: yes (test the function of isAlive() )
	public void testIsAlive1() 
	{
		Player test = new Player(1);
		assertEquals(test.getMaxHP(),1);
		assertEquals(test.getCurHP(),1);
		
		assertEquals(test.isAlive(),true);	
	}
	
	// Test case 6: no (test the function of isAlive() )
	public void testIsAlive2() 
	{
		Player test = new Player(1);
		assertEquals(test.getMaxHP(),1);
		assertEquals(test.getCurHP(),1);
		
		test.decreaseHP(1);
		
		assertEquals(test.isAlive(),false);	
	}
	
	
	
	
}
