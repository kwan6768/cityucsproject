package testpicross;

import junit.framework.TestCase;
import picross.StageController;


public class testStageController extends TestCase{
	private StageController test;
	public void setUp() 
	{
		test = new StageController(null);
	}

	public void tearDown() {}
	
	// Test case: answer is
	// {1, 0}
	// {1, 0, 1}
	public void testValidateAns1()
	{
		int ans[][] = {{1,0},
				       {1,0,1}};
		assertEquals(test.testValidateAns(ans),false);
	}
	
	// Test case: answer is
	// {1, 0, 0}
	// {1, 0, 1}
	public void testValidateAns2()
	{
		int ans[][] = {{1,0,0},
				       {1,0,1}};
		assertEquals(test.testValidateAns(ans),true);
	}
	
	// Test case: answer is
	// {1, 0, 0}
	// {1, 0}
	public void testValidateAns3()
	{
		int ans[][] = {{1,0,0},
				       {1,0}};
		assertEquals(test.testValidateAns(ans),false);
	}
	
	// Test case: answer is
	// {1, 2}
	// {1, 0}
	public void testValidateAns4()
	{
		int ans[][] = {{1,2},
				       {1,0}};
		assertEquals(test.testValidateAns(ans),false);
	}
	
	// Test case: answer is
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
	// {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1}
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}
	// {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
	// {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
	// {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}
	// {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}
	// {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
	// {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
	// {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}
	public void testValidateAns5()
	{
		int[][] ans = { {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
						{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
						{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
						{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
						{0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}};
		assertEquals(test.testValidateAns(ans),true);
	}
}
