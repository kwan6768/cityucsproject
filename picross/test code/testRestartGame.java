package testpicross;

import junit.framework.TestCase;
import picross.ChessController;

public class testRestartGame extends TestCase{
	
	ChessController test;
	
	public void setAllTrue(ChessController test)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
				test.getAllCells()[i][j].setLeftSelect(true);
		}
	}
	
	public void setHalfTrue(ChessController test)
	{
		for(int i=0;i<5/2;i++)
		{
			for(int j=0;j<5/2;j++)
				test.getAllCells()[i][j].setLeftSelect(true);
		}
	}
	
	
	
	
	public boolean checkAllZero(ChessController test)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
					if(test.getAllCells()[i][j].IsLeftSelect()==true)
						return false;
			}
		}
		
		return true;
	}


	public void setUp() {
		
		int [][] ans = { {1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1}};
		
		test = new ChessController(1,ans,null,null);
		
	}

	public void tearDown() {}
	
	public void testAllSelected() 
	{	
		setAllTrue(test);
		test.restartGame(5, 5);
		assertEquals(checkAllZero(test),true);
	}
	
	public void testHalfSelected()
	{
		setHalfTrue(test);
		test.restartGame(5, 5);
		assertEquals(checkAllZero(test),true);
	}
	
	public void testNonSelected()
	{
		test.restartGame(5, 5);
		assertEquals(checkAllZero(test),true);
	}
	
	
	

}