package testpicross;

import junit.framework.TestCase;
import picross.ChessController;

public class testChessController1 extends TestCase{

	public void setUp() {}

	public void tearDown() {}
	
	// Test case 1: 0 1 ,0 1(test the initCells function)
	public void testInitCells1() 
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, null, null);
		
		for(int i=0;i<ans1.length;i++)
		{
			for(int j=0;j<ans1[0].length;j++)
				assertEquals(test.getAllCells()[i][j].IsAns(),ans1[i][j]==1 ? true : false);
		}
		
	}
	
	// Test case 2: 1 0 1 ,1 1 1, 0 0 0(test the initCells function)	
	public void testInitCells2() 
	{
		int [][] ans2 = { {1,0,1},
				 {1,1,1},
				 {0,0,0}};
		
		ChessController test = new ChessController(10, ans2, null, null);
		
		for(int i=0;i<ans2.length;i++)
			for(int j=0;j<ans2[0].length;j++)
				assertEquals(test.getAllCells()[i][j].IsAns(),ans2[i][j]==1 ? true : false);
	}
	
	// Test case 3: 0 0 1 0 0, 0 0 1 0 0, 1 1 1 1 1, 0 0 1 0 0, 1 0 1 0 1(test the initCells function)	
	public void testInitCells3() 
	{
		int [][] ans3 = { {0, 0, 1, 0, 0},
				 {0, 0, 1, 0, 0},
				 {1, 1, 1, 1, 1},
				 {0, 0, 1, 0, 0},
				 {1, 0, 1, 0, 1}};
		
		ChessController test = new ChessController(10, ans3, null, null);
		
		for(int i=0;i<ans3.length;i++)
			for(int j=0;j<ans3[0].length;j++)
				assertEquals(test.getAllCells()[i][j].IsAns(),ans3[i][j]==1 ? true : false);
	}
	
	// Test case 4: 0 1 ,0 1(test the initTipsCells function  (the number of tipsCell))	
	public void testInitTipsCells1() 
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, null, null);
		
		assertEquals(test.getTopTipsCells().size(),2);
		assertEquals(test.getLeftTipsCells().size(),2);		
	}
	
	// Test case 5: 1 0 1 ,1 1 1, 0 0 0(test the initTipsCells function  (the number of tipsCell))	
	public void testInitTipsCells2() 
	{
		int [][] ans2 = { {1,0,1},
				 		{1,1,1},
				 		{0,0,0}};
		
		ChessController test = new ChessController(10, ans2, null, null);
		
		assertEquals(test.getTopTipsCells().size(),3);
		assertEquals(test.getLeftTipsCells().size(),4);		
	}
	// Test case 6:0 0 1 0 0, 0 0 1 0 0, 1 1 1 1 1, 0 0 1 0 0, 1 0 1 0 1(test the initTipsCells function  (the number of tipsCell))	
	public void testInitTipsCells3() 
	{
		int [][] ans3 = { {0, 0, 1, 0, 0},
				 {0, 0, 1, 0, 0},
				 {1, 1, 1, 1, 1},
				 {0, 0, 1, 0, 0},
				 {1, 0, 1, 0, 1}};
		
		ChessController test = new ChessController(10, ans3, null, null);
		
		assertEquals(test.getTopTipsCells().size(),7);
		assertEquals(test.getLeftTipsCells().size(),7);		
	}
	
	// Test case 7: 0 1 ,0 1(test the initTipsCells function  (the value of tipsCell))	
	public void testInitTipsCells4() 
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, null, null);
		
		assertEquals(test.getTopTipsCells().get(0).getTipsNum(),0);
		assertEquals(test.getTopTipsCells().get(1).getTipsNum(),2);
		assertEquals(test.getLeftTipsCells().get(0).getTipsNum(),1);		
		assertEquals(test.getLeftTipsCells().get(1).getTipsNum(),1);	
	}
	
	// Test case 8: 1 0 1 ,1 1 1, 0 0 0(test the initTipsCells function  (the number of tipsCell))	
	public void testInitTipsCells5() 
	{
		int [][] ans2 = { {1,0,1},
				 		{1,1,1},
				 		{0,0,0}};
		
		ChessController test = new ChessController(10, ans2, null, null);
		
		assertEquals(test.getTopTipsCells().get(0).getTipsNum(),2);
		assertEquals(test.getTopTipsCells().get(1).getTipsNum(),1);
		assertEquals(test.getTopTipsCells().get(2).getTipsNum(),2);
		assertEquals(test.getLeftTipsCells().get(0).getTipsNum(),1);
		assertEquals(test.getLeftTipsCells().get(1).getTipsNum(),1);
		assertEquals(test.getLeftTipsCells().get(2).getTipsNum(),3);
		assertEquals(test.getLeftTipsCells().get(3).getTipsNum(),0);
	}
	
	// Test case 9: 0 0 1 0 0, 0 0 1 0 0, 1 1 1 1 1, 0 0 1 0 0, 1 0 1 0 1(test the initTipsCells function  (the number of tipsCell))	
	public void testInitTipsCells6() 
	{
		int [][] ans3 = { {0, 0, 1, 0, 0},
				 {0, 0, 1, 0, 0},
				 {1, 1, 1, 1, 1},
				 {0, 0, 1, 0, 0},
				 {1, 0, 1, 0, 1}};
		
		ChessController test = new ChessController(10, ans3, null, null);
		
		assertEquals(test.getTopTipsCells().get(0).getTipsNum(),1);
		assertEquals(test.getTopTipsCells().get(1).getTipsNum(),1);
		assertEquals(test.getTopTipsCells().get(2).getTipsNum(),1);
		assertEquals(test.getTopTipsCells().get(3).getTipsNum(),5);
		assertEquals(test.getTopTipsCells().get(4).getTipsNum(),1);
		assertEquals(test.getTopTipsCells().get(5).getTipsNum(),1);
		assertEquals(test.getTopTipsCells().get(6).getTipsNum(),1);
		
		assertEquals(test.getLeftTipsCells().get(0).getTipsNum(),1);
		assertEquals(test.getLeftTipsCells().get(1).getTipsNum(),1);
		assertEquals(test.getLeftTipsCells().get(2).getTipsNum(),5);
		assertEquals(test.getLeftTipsCells().get(3).getTipsNum(),1);
		assertEquals(test.getLeftTipsCells().get(4).getTipsNum(),1);
		assertEquals(test.getLeftTipsCells().get(5).getTipsNum(),1);
		assertEquals(test.getLeftTipsCells().get(6).getTipsNum(),1);
	}

	// Test case 10: 0 1 ,0 1(test the restart function)
	public void testRestart1()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};

		ChessController test = new ChessController(10, ans1, null, null);
		
		test.getAllCells()[0][0].setRightSelect(true);
		test.getAllCells()[0][1].setLeftSelect(true);

		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);	
		
		test.restartGame(2, 2);
		
		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);			
		
	}

	// Test case 11: 1 0 1 ,1 1 1, 0 0 0(test the restart function)
	public void testRestart2()
	{
		int [][] ans2 = { {1,0,1},
				 {1,1,1},
				 {0,0,0}};
		
		ChessController test = new ChessController(10, ans2, null, null);
		
		test.getAllCells()[0][0].setRightSelect(true);
		test.getAllCells()[0][1].setLeftSelect(true);

		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),true);
		assertEquals(test.getAllCells()[0][1].IsLeftSelect(),true);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);	
		
		test.restartGame(3,3);
		
		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsRightSelect(),false);
		assertEquals(test.getAllCells()[0][0].IsLeftSelect(),false);		
		assertEquals(test.getAllCells()[0][1].IsRightSelect(),false);			
	}
	
	// Test case 12: 0 1 ,0 1(test the checkClear function)
	public void testcheckClear1()
	{
		int [][] ans1 = { {0, 1},
				 {0,1}};
		
		ChessController test = new ChessController(10, ans1, null, null);
		
		test.getAllCells()[0][0].setRightSelect(true);
		test.getAllCells()[0][1].setLeftSelect(true);

		assertEquals(test.checkClear(2,2),false);
		
		test.restartGame(2,2);
		
		test.getAllCells()[0][1].setLeftSelect(true);
		test.getAllCells()[1][1].setLeftSelect(true);
		
		assertEquals(test.checkClear(2,2),true);
	}	
	
	// Test case 12: 1 0 1 ,1 1 1, 0 0 0 (test the checkClear function)
	public void testcheckClear2()
	{
		int [][] ans2 = { {1,0,1},
				 {1,1,1},
				 {0,0,0}};
		
		ChessController test = new ChessController(10, ans2, null, null);
		

		
		test.getAllCells()[0][0].setRightSelect(true);
		test.getAllCells()[0][1].setLeftSelect(true);
		test.getAllCells()[1][1].setLeftSelect(true);
		test.getAllCells()[1][2].setLeftSelect(true);

		assertEquals(test.checkClear(2,2),false);
		
		test.restartGame(3,3);
		
		test.getAllCells()[0][0].setLeftSelect(true);
		test.getAllCells()[0][2].setLeftSelect(true);
		test.getAllCells()[1][0].setLeftSelect(true);
		test.getAllCells()[1][1].setLeftSelect(true);
		test.getAllCells()[1][2].setLeftSelect(true);
		
		assertEquals(test.checkClear(3,3),true);
	}		
	
	
}
