package testpicross;

import junit.framework.TestCase;
import picross.ChessController;
import picross.MainMenuController;
import picross.MainMenuUI;

public class testChessController2 extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1: 0 1 ,0 1(test the "back" of LCprocess function)
	public void testLCprocess1() 
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, new MainMenuController(new MainMenuUI()), null);
		
		test.getAllCells()[0][0].setRightSelect(true);
		test.getAllCells()[0][1].setLeftSelect(true);

		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);	
		
		test.LCprocess(800, 700, 2, 2, 768);
		
		assertEquals(test.getChessUI(),null);
	}		

	// Test case 2: 1 0 1 ,1 1 1, 0 0 0(test the "back" of LCprocess function)
	public void testLCprocess2() 
	{
		int [][] ans2 = { {1,0,1},
		 		{1,1,1},
		 		{0,0,0}};

		ChessController test = new ChessController(10, ans2, new MainMenuController(new MainMenuUI()), null);
		
		test.getAllCells()[0][0].setRightSelect(true);
		test.getAllCells()[0][1].setLeftSelect(true);

		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);	
		
		test.LCprocess(800, 700, 2, 2, 768);
		
		assertEquals(test.getChessUI(),null);
	}	
	
	// Test case 3: 0 1 ,0 1(test the "Restart" of LCprocess function)
	public void testLCprocess3() 
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, new MainMenuController(new MainMenuUI()), null);
		
		test.getAllCells()[0][0].setRightSelect(true);
		test.getAllCells()[0][1].setLeftSelect(true);

		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);	
		
		test.LCprocess(800, 550, 2, 2, 768);
		
		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);		
	}			
	
	// Test case 4: 0 1 ,0 1 select is Ans(test the "Restart" of LDprocess function)
	public void testLDprocess1()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, new MainMenuController(new MainMenuUI()), null);
		
		test.LDprocess(0, 1, 2, 2);
		
		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);
	}
	
	// Test case 5: 0 1 ,0 1 select isn't Ans (test the "Restart" of LDprocess function)
	public void testLDprocess2()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, new MainMenuController(new MainMenuUI()), null);
		
		test.LDprocess(0, 0, 2, 2);
		
		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getPlayer().getCurHP(),4);
	}
	
	// Test case 6: 0 1 ,0 1 select is selected (test the "Restart" of LDprocess function)	
	public void testLDprocess3()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, new MainMenuController(new MainMenuUI()), null);

		test.LDprocess(0, 1, 2, 2);
		
		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);
		
		test.LDprocess(0, 1, 2, 2);

		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);

	}
	
	public void testRCprocessRDprocess1()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, null, null);
		
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		
		test.RCprocess(0,0,2,2);
		test.RDprocess(0,0,2,2);
		
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		
	}
	
	public void testRCprocessRDprocess2()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, null, null);
		
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		
		test.getAllCells()[0][0].setRightSelect(true);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		
		test.RCprocess(0,0,2,2);
		test.RDprocess(0,0,2,2);
		
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		
	}
	
	// check function checkClear, it is ran in LDprocess
	// if the game is clear, the RCprocess should not make the cell being right clicked
	public void testCheckClear1()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, null, null);
		test.LDprocess(0,1,2,2);
		test.LDprocess(1,1,2,2);
		test.RCprocess(0,0,2,2);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
	}
	
	public void testLCprocess4()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		int max;
		int cellCols = ans1[0].length;
	    int cellRows = ans1.length;
	    
	    max = cellRows;
	    
	    max = 768 / (max+(int)Math.ceil((double)max / 2.0));
	    int cellSize = max;
	    ChessController test = new ChessController(cellSize, ans1, null, null);
	    int menuX = test.getChessUI().getMenuX();
	    assertEquals(test.LCprocess(300,300,2,2, menuX),false);
	}
}
