package testpicross;

import junit.framework.TestCase;
import picross.Cell;

public class testCell extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1: no input
	public void testNoInput() 
	{
		Cell test = new Cell();
		assertEquals(test.IsLeftSelect(), false);
	}
	// Test case 2: have input
	public void testHasInput() 
	{
		Cell test = new Cell();
		assertEquals(test.IsLeftSelect(), false);
	}
	
	// Test case 3: ans is yes
	public void testAnsYes() 
	{
		Cell test = new Cell(true);
		assertEquals(test.IsAns(), true);
	}
	
	// Test case 4: ans is no
	public void testAnsNo() 
	{
		Cell test = new Cell(false);
		assertEquals(test.IsAns(), false);
	}
	
	public void testLeftSelect()
	{
		Cell test = new Cell(true);
		test.setLeftSelect(true);
		assertEquals(test.IsLeftSelect(), true);
	}
}
