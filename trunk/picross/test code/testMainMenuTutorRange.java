package test;

import junit.framework.TestCase;
import picross.*;
import stub.*;

public class testMainMenuTutorRange extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1: no, not in condition  (test fulfill function)
	public void testNoInput1() 
	{
		MainMenuTutoRange test = new MainMenuTutoRange();
		assertEquals(test.fulfill(0, 0), false);
	}
	
	// Test case 2: no, x in condition  (test fulfill function)
	public void testNoInput2() 
	{
		MainMenuTutoRange test = new MainMenuTutoRange();
		assertEquals(test.fulfill(500, 0), false);
	}
	
	// Test case 3: no, y in condition  (test fulfill function)
	public void testNoInput3() 
	{
		MainMenuTutoRange test = new MainMenuTutoRange();
		assertEquals(test.fulfill(0, 500), false);
	}
	
	// Test case 3: yes, in condition  (test fulfill function)
	public void testNoInput4() 
	{
		MainMenuTutoRange test = new MainMenuTutoRange();
		assertEquals(test.fulfill(500, 550), true);
	}
	
	public void testProcess()
	{
		MainMenuTutoRange test = new MainMenuTutoRange();
		test.process(new StubMainMenuController());
	}
}