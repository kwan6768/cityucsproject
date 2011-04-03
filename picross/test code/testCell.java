package testpicross;

import junit.framework.TestCase;
import picross.Cell;

public class testCell extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1: no input (set up of bIsLSelect and bIsRSelect)
	public void testNoInput() 
	{
		Cell test = new Cell();
		assertEquals(test.IsLeftSelect(), false);
		assertEquals(test.IsRightSelect(),false);
	}
	// Test case 2: have input (set up of bIsLSelect and bIsRSelect)
	public void testHasInput() 
	{
		Cell test = new Cell(true);
		assertEquals(test.IsLeftSelect(), false);
	}
	
	// Test case 3: ans is yes (set up of bisAns)
	public void testAnsYes() 
	{
		Cell test = new Cell(true);
		assertEquals(test.IsAns(), true);
	}
	
	// Test case 4: ans is no (set up of bisAns)
	public void testAnsNo() 
	{
		Cell test = new Cell(false);
		assertEquals(test.IsAns(), false);
	}
	
	// Test case 5: (test function setLeftSelect() )
	public void test_setLeftSelect()
	{
		Cell test = new Cell(true);
		test.setLeftSelect(true);
		assertEquals(test.IsLeftSelect(), true);
	}
	
	// Test case 6: (test function setRightSelect() )
	public void test_setRightSelect()
	{
		Cell test = new Cell(true);
		test.setRightSelect(true);
		assertEquals(test.IsRightSelect(), true);
	}	
}
