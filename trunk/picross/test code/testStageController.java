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
	
	// Test case: answer is
	// {1, 2}
	// {1, 0}
	public void testStartGame1()
	{
		int ans[][] = {{1,2},
				       {1,0}};
		assertEquals(test.startGame(ans),false);
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
	public void testStartGame2()
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
		assertEquals(test.startGame(ans),true);
	}
	
	// Test case: answer is
	// {1, 0, 0}
	// {1, 0, 1}
	public void testStartGame3()
	{
		int ans[][] = {{1,0,0},
				       {1,0,1}};
		assertEquals(test.startGame(ans),true);
	}
	
	// test process using different x, y to verify if the function exist error
	// also, test if it coverage all for loop in process function
	public void testProcess1()
	{
		try{
			test.process(0, 0);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	public void testProcess2()
	{
		try{
			test.process(-150, -150);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	public void testProcess3()
	{
		try{
			test.process(450, 600);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	public void testProcess4()
	{
		try{
			test.process(500, 480);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	public void testProcess5()
	{
		try{
			test.process(600, 530);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	public void testProcess6()
	{
		try{
			test.process(999, 999);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	public void testDispose()
	{
		test.dispose();
		assertEquals(test.getStageUI(), null);
	}
}
