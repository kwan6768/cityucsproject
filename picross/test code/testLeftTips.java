package testpicross;
import junit.framework.TestCase;
import java.util.Vector;
import picross.TipsCell;
import picross.ChessController;

import org.junit.Before;

public class testLeftTips extends TestCase {

	@Before
	public void setUp() throws Exception {
	}
	public boolean checkLeftTips(int cellRows, int cellCols, int[][] ans, Vector<TipsCell> leftTipsCells){
		int count = 0;
		
		for ( int row=0; row<cellRows; row++) {	 
			int tipsNum = 0;
			int countCol=1;
			for ( int col=cellCols-1; col>=0; col-- ) {
	    		if (ans[row][col]==1)
	    			tipsNum++; 
		
	    		if (tipsNum>0 && (ans[row][col] == 0 || col == 0)) {
	    			if(leftTipsCells.elementAt(count).getRow() != row+1 || leftTipsCells.elementAt(count).getCol()!= countCol++ || leftTipsCells.elementAt(count).getTipsNum() < 1)
	    				return false;
	    			tipsNum=0;
	    			count++;
	    		}
			}
		}
		return true;
	}
	public void testTipsTop3x3(){
		int [][] ans = { {0, 1, 0},
				 {1, 1, 1},
				 {0, 1, 0}};
		ChessController test = new ChessController(10,ans,null,null);
		assertEquals(checkLeftTips(3,3,ans,test.getLeftTipsCells()), true);
	}
	public void testTipsTop4x4(){
		int [][] ans = { {0, 0, 1, 0},
						 {1, 1, 1, 0},
						 {0, 1, 1, 1},
						 {1, 0, 0, 1}};
		ChessController test = new ChessController(10, ans, null,null);
		assertEquals(checkLeftTips(4,4,ans,test.getLeftTipsCells()), true);
	}
	public void testTipsTop5x5(){
		int [][] ans = { {0, 0, 1, 0, 1},
						 {1, 0, 1, 1, 0},
						 {0, 1, 1, 1, 0},
						 {0, 1, 0, 1, 1},
						 {1, 0, 1, 0, 0}};
		ChessController test = new ChessController(10, ans, null,null);
		assertEquals(checkLeftTips(5,5,ans,test.getLeftTipsCells()), true);
	}
}