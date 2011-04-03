package test;

import junit.framework.TestCase;
import picross.*;
import stub.*;

public class testMainMenuStartRange extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1: no, not in condition  (test fulfill function)
	public void testNoInput1() 
	{
		MainMenuStartRange test = new MainMenuStartRange();
		assertEquals(test.fulfill(0, 0), false);
	}
	
	// Test case 2: no, x in condition  (test fulfill function)
	public void testNoInput2() 
	{
		MainMenuStartRange test = new MainMenuStartRange();
		assertEquals(test.fulfill(400, 0), false);
	}
	
	// Test case 3: no, y in condition  (test fulfill function)
	public void testNoInput3() 
	{
		MainMenuStartRange test = new MainMenuStartRange();
		assertEquals(test.fulfill(0, 470), false);
	}
	
	// Test case 3: yes, in condition  (test fulfill function)
	public void testNoInput4() 
	{
		MainMenuStartRange test = new MainMenuStartRange();
		assertEquals(test.fulfill(400, 470), true);
	}
	
	public void testProcess()
	{
		MainMenuStartRange test = new MainMenuStartRange();
		test.process(new StubMainMenuController());
	}
}