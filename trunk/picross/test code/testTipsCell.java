package testpicross;

import junit.framework.TestCase;
import picross.TipsCell;

public class testTipsCell extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1:0 0 0 (set up of tipsNum, col and row)
	public void testConstructor() 
	{
		TipsCell test = new TipsCell(0,0,0);
		assertEquals(test.getRow(),0);
		assertEquals(test.getCol(),0);
		assertEquals(test.getTipsNum(),0);
	}

	// Test case 2:1 2 3 (set up of tipsNum, col and row)
	public void testConstructor2() 
	{
		TipsCell test = new TipsCell(1,2,3);
		assertEquals(test.getRow(),1);
		assertEquals(test.getCol(),2);
		assertEquals(test.getTipsNum(),3);
	}
	
}
