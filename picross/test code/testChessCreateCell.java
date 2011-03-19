package testpicross;

import junit.framework.TestCase;
import picross.Cell;
import picross.ChessController;

public class testChessCreateCell extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// function for valid ans correct input to cells
	public boolean checkequal(Cell[][] cell, int[][] ans,int row, int col)
	{
		boolean equal = true;
		
		for(int i=0; i<row ; i++)
		{
			for(int j=0; j<col; j++)
			{	

				if(cell[i][j].IsAns()==true && ans[i][j]==0)
					equal = false;
				else if (cell[i][j].IsAns()==false && ans[i][j]==1)
					equal = false;
			}
		}
		
		return equal;
	}
	// Test case 1: 5 x 5
	public void test55() 
	{	
		int [][] ans = { {0, 0, 1, 0, 0},
						 {0, 0, 1, 0, 0},
						 {1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0},
						 {0, 0, 1, 0, 0}};
		
		ChessController test = new ChessController(5,5,ans,1,null);
		
		assertEquals(checkequal(test.getAllCells(),ans,5,5),true);
			
		
	}
	
	public void test22() 
	{	
		
		int [][] ans = { {0, 0},
				 		 {1, 0}};
		
		ChessController test = new ChessController(2,2,ans,1,null);
		
		assertEquals(checkequal(test.getAllCells(),ans,2,2),true);
			
		
	}
	
	
	// Test case 1: 6 x 6
	public void test66() 
	{	
		
		int [][] ans = { {0, 0, 1, 0, 0, 1},
						 {0, 0, 1, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 1},
						 {0, 0, 1, 0, 0, 1},
						 {0, 0, 1, 0, 0, 1}};
		
		ChessController test = new ChessController(6,6,ans,1,null);
		
		assertEquals(checkequal(test.getAllCells(),ans,6,6),true);
			
		
	}	
	// Test case 1: 5 x 6
	public void test56() 
	{	
		
		int [][] ans = { {0, 0, 1, 0, 0, 1},
						 {0, 0, 1, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 1},
						 {0, 0, 1, 0, 0, 1}};
		
		ChessController test = new ChessController(5,6,ans,1,null);
		assertEquals(checkequal(test.getAllCells(),ans,5,6),true);
	}	
	
	
}