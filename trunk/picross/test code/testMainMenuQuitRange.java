package testpicross;

import junit.framework.TestCase;
import picross.*;

public class testMainMenuQuitRange extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1: no, not in condition  (test fulfill function)
	public void testNoInput1() 
	{
		MainMenuQuitRange test = new MainMenuQuitRange();
		assertEquals(test.fulfill(0, 0), false);
	}
	
	// Test case 2: no, x in condition  (test fulfill function)
	public void testNoInput2() 
	{
		MainMenuQuitRange test = new MainMenuQuitRange();
		assertEquals(test.fulfill(400, 0), false);
	}
	
	// Test case 3: no, y in condition  (test fulfill function)
	public void testNoInput3() 
	{
		MainMenuQuitRange test = new MainMenuQuitRange();
		assertEquals(test.fulfill(0, 600), false);
	}
	
	// Test case 3: yes, in condition  (test fulfill function)
	public void testNoInput4() 
	{
		MainMenuQuitRange test = new MainMenuQuitRange();
		assertEquals(test.fulfill(400, 600), true);
	}
	
	public void testProcess()
	{
		MainMenuQuitRange test = new MainMenuQuitRange();
		test.process(new MainMenuController(new MainMenuUI()));
	}
}