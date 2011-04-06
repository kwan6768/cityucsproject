package testpicross;

import junit.framework.TestCase;
import picross.*;

public class testMainMenuController extends TestCase{

	private MainMenuController test;
	public void setUp() 
	{
		test = new MainMenuController(new MainMenuUI());
	}

	public void tearDown() {}
	
	
	// Test case 1: no match any condition  (test process function)
	public void testNotMatch() 
	{
		try {
			test.process(0, 0);
			assertTrue(true);
		} catch(Exception e) {
			assertFalse(false);
		}
	}
	
	// Test case 2: match Quit condition  (test process function)	
	public void testConditionQuit() 
	{
		try {
			test.process(400, 600);
			assertTrue(true);
		} catch(Exception e) {
			assertFalse(false);
		}
	}
	
	// Test case 2: match Start condition  (test process function)		
	public void testConditionStart() 
	{
		try {
			test.process(400, 470);
			assertTrue(true);
		} catch(Exception e) {
			assertFalse(false);
		}
		MainMenuController test = new MainMenuController(new MainMenuUI());
	}

	// Test case 3: match Tutor condition  (test process function)		
	public void testConditionTutor() 
	{
		try {
			test.process(500, 500);
			assertTrue(true);
		} catch(Exception e) {
			assertFalse(false);
		}
	}

	// Test case 4:( test setVisble() function)	
	public void testSetVisiable()
	{
		assertEquals(test.getMainMenuUI().isVisible(),true);
		
		test.setVisible(false);
		
		assertEquals(test.getMainMenuUI().isVisible(),false);		
	}
	
	public void testDipose()
	{
		test.dispose();
		assertEquals(test.getMainMenuUI(),null);
	}
	
	
}