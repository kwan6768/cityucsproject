package testpicross;

import junit.framework.TestCase;
import picross.ChessController;


public class testClear extends TestCase{
	ChessController test;
	
	public void setAllTrue(ChessController test)
	{
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
				test.getAllCells()[i][j].setLeftSelect(true);
		}
	}
	
	public void setHalfTrue(ChessController test)
	{
		for(int j=0;j<2;j++)
			test.getAllCells()[0][j].setLeftSelect(true);
	}
	
	
	
	
	public boolean checkAllZero(ChessController test)
	{
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
					if(test.getAllCells()[i][j].IsLeftSelect()==true)
						return false;
			}
		}
		
		return true;
	}


	public void setUp() {
		
		int [][] ans = { {1, 1},
						 {1, 1}};
		
		test = new ChessController(2, 2, ans, 1, null);
	}

	public void tearDown() {}
	
	public void testAllSelected() 
	{	
		setAllTrue(test);
		assertEquals(test.checkClear(2, 2), true);
	}
	
	public void testHalfSelected()
	{
		setHalfTrue(test);
		assertEquals(test.checkClear(2, 2), false);
	}
	
	public void testNonSelected()
	{
		assertEquals(test.checkClear(2, 2), false);
	}
}
