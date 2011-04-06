package testpicross;

import junit.framework.TestCase;

import picross.ChessController;
import picross.Player;
import picross.ChessUI;



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
	
	// Test case: HP = 0, null pointer
	public void testDisplay1()
	{
		try {
			Player test = new Player(0);
			test.display(null);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	// Test case: HP = 0, not null pointer
	public void testDisplay2()
	{
		int ans[][] = {{1,0},{1,0}};
		
		try {
			Player test = new Player(0);
			test.display(new ChessUI(10, ans, null));
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	// Test case: HP = 3, not null pointer
	public void testDisplay3()
	{
		int ans[][] = {{1,0},{1,0}};
		
		try {
			Player test = new Player(3);
			test.display(new ChessUI(10, ans, null));
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	// Test case: HP = -2, not null pointer
	public void testDisplay4()
	{
		int ans[][] = {{1,0},{1,0}};
		
		try {
			Player test = new Player(-2);
			test.display(new ChessUI(10, ans, null));
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	
}
