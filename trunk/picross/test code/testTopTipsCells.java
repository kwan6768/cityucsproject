package testpicross;


import junit.framework.TestCase;


import picross.TipsCell;

public class testTopTipsCells extends TestCase{


	public void setUp() throws Exception {}


	public void tearDown() throws Exception {}
	
	// Test case 1: test the input of Col
	public void testToptipsCellCol() 
	{
		TipsCell test = new TipsCell(1,2,3);
		assertEquals(test.getCol(), 2);
	}
	// Test case 2: test the input of Row	
	public void testToptipsCellRow() 
	{
		TipsCell test = new TipsCell(3,2,1);
		assertEquals(test.getRow(), 3);
	}
	// Test case 3: test the input of TipNum
	public void testToptipsCellTipNum() 
	{
		TipsCell test = new TipsCell(3,2,1);
		assertEquals(test.getTipsNum(), 1);
	}
	
}
