package testpicross;

import junit.framework.TestCase;
import picross.ChessController;

public class Unmark extends TestCase{

	private ChessController test;
	int [][] ans1 = {{0,1},
					 {0,1}};
	
	public void setUp() 
	{
		int max;
		int cellCols = ans1[0].length;
	    int cellRows = ans1.length;
	    
	    if (cellCols > cellRows)
	    	max = cellCols;
	    else
	    	max = cellRows;
	    
	    max = 768 / (max+(int)Math.ceil((double)max / 2.0));
	    int cellSize = max;
		test = new ChessController(cellSize, ans1, null, null);
	}

	public void tearDown() {}
	
	// Test case: right click cell twice
	// if it is not clicked at the beginning, the result should be no cross(IsRightSelect = false) after right clicking twice
	public void test_right_click_cell_twice_at_the_same_place() 
	{
		test.RCprocess(0, 0, 2, 2);
		test.mouseReleaseProcess();
		test.RCprocess(0, 0, 2, 2);
		test.mouseReleaseProcess();
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
	}
	
	// Test case: right drag all cells
	public void test_right_drag_all_cells()
	{
		for (int row = 0; row < ans1.length; row++){
			for (int col = 0; col < ans1[0].length; col++) {
				test.RDprocess(row, col, 2, 2);
				assertEquals(test.getAllCells()[row][col].IsRightSelect(),true);
			}
		}
	}
	
	// Test case: right drag some cells(1).
	// If the first drag cell is right selected, the drag action will turn the cells to be not right selected until released mouse click 
	public void test_right_drag_cancel_mark_cross()
	{
		// right click 2 cells
		test.RCprocess(0, 0, 2, 2);
		test.RCprocess(1, 0, 2, 2);
		
		// test drag
		test.RCprocess(0, 0, 2, 2);
		test.RDprocess(0, 1, 2, 2);
		test.RDprocess(1, 0, 2, 2);
		test.RDprocess(1, 1, 2, 2);
		
		// Since the 1st drag cells is already right selected, the drag action should be to cancel right selection of the cell
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);
		assertEquals(test.getAllCells()[1][0].IsRightSelect(),false);
		assertEquals(test.getAllCells()[1][1].IsRightSelect(),false);
	}
	
	// Test case: right drag some cells(2). 
	// If the first drag cell is not right selected, the drag action will set the cells right selected until released mouse click 
	public void test_right_drag_mark_cross()
	{
		// right click 2 cells
		test.RCprocess(1, 0, 2, 2);
		test.RCprocess(1, 1, 2, 2);
		
		// test drag
		
		test.RCprocess(0, 0, 2, 2);
		test.RDprocess(0, 1, 2, 2);
		test.RDprocess(1, 0, 2, 2);
		test.RDprocess(1, 1, 2, 2);
		
		// Since the 1st drag cells is already right selected, the drag action should be to cancel right selection of the cell
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),true);
		assertEquals(test.getAllCells()[1][0].IsRightSelect(),true);
		assertEquals(test.getAllCells()[1][1].IsRightSelect(),true);
	}
	
	// Test case: right click outside the chess a little
	public void test_right_click_outside_chess()
	{
		//int row = (y-cellStartY)/cellSize;
		//int col = (x-cellStartX)/cellSize;
		int cellStartY = test.getChessUI().getCellStartY();
		int cellStartX = test.getChessUI().getCellStartX();
		int cellSize = test.getChessUI().getCellSize();
		int x = 210;
		int y = 354;
		
		// test these 2 formula(copyed from ChessUI)
		int row = test.getChessUI().testCalRowByUsingY(y, cellStartY, cellSize);
		int col = test.getChessUI().testCalRowByUsingX(x, cellStartX, cellSize);
		
		test.RCprocess(row, col, 2, 2);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);
		assertEquals(test.getAllCells()[1][0].IsRightSelect(),false);
		assertEquals(test.getAllCells()[1][1].IsRightSelect(),false);
	}
}
