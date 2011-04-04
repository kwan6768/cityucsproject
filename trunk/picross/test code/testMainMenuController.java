package testpicross;

import junit.framework.TestCase;
import picross.*;
import stub.*;

public class testMainMenuController extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	/*
	// Test case 1: no match any condition  (test process function)
	public void testNotMatch() 
	{
		MainMenuController test = new MainMenuController(new StubMainMenuUI());
		assertEquals(test.process(0, 0), "null");
	}
	// Test case 2: match Quit condition  (test process function)	
	public void testConditionQuit() 
	{
		MainMenuController test = new MainMenuController(new StubMainMenuUI());
		assertEquals(test.process(400, 600), "Quit");
	}
	// Test case 2: match Start condition  (test process function)		
	public void testConditionStart() 
	{
		MainMenuController test = new MainMenuController(new StubMainMenuUI());
		assertEquals(test.process(400, 470), "Start");
	}

	// Test case 3: match Tutor condition  (test process function)		
	public void testConditionTutor() 
	{
		MainMenuController test = new MainMenuController(new StubMainMenuUI());
		assertEquals(test.process(500, 550), "Tutor");
	}

	// Test case 4:( test setVisble() function)	
	public void testSetVisiable()
	{
		MainMenuController test = new MainMenuController(new StubMainMenuUI());
		assertEquals(test.getMainMenuUI().isVisible(),true);
		
		test.setVisible(false);
		
		assertEquals(test.getMainMenuUI().isVisible(),false);		
	}
	
	public void testDipose()
	{
		MainMenuController test = new MainMenuController(new StubMainMenuUI());
		
		test.dispose();
		assertEquals(test.getMainMenuUI().getState(),0);
	}
	*/
	
}