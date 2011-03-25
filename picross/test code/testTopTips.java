package testpicross;
import junit.framework.TestCase;
import java.util.Vector;
import picross.TipsCell;
import picross.ChessController;

import org.junit.Before;

public class testTopTips extends TestCase {

	@Before
	public void setUp() throws Exception {
	}
	public boolean checkTopTips(int cellRows, int cellCols, int[][] ans, Vector<TipsCell> topTipsCells){
		int count = 0;
		
		for ( int col=0; col<cellCols; col++) {	 
			int tipsNum = 0;
			int countRow=1;
			for ( int row=cellRows-1; row>=0; row-- ) {
	    		if (ans[row][col]==1)
	    			tipsNum++; 
		
	    		if (tipsNum>0 && (ans[row][col] == 0 || row == 0)) {
	    			if(topTipsCells.elementAt(count).getRow() != countRow++ || topTipsCells.elementAt(count).getCol()!= col+1 || topTipsCells.elementAt(count).getTipsNum() < 1)
	    				return false;
	    			tipsNum=0;
	    			count++;
	    		}
			}
		}
		return true;
	}
	public void testTipsTop3x3(){
		int [][] ans = { {0, 0, 1},
						 {1, 0, 1},
						 {0, 1, 1}};
		ChessController test = new ChessController(10, ans, null,null);
		assertEquals(checkTopTips(3,3,ans,test.getTopTipsCells()), true);
	}
	public void testTipsTop4x4(){
		int [][] ans = { {0, 0, 1, 0},
						 {1, 0, 1, 0},
						 {0, 1, 1, 1},
						 {1, 0, 0, 1}};
		ChessController test = new ChessController(10, ans, null,null);
		assertEquals(checkTopTips(4,4,ans,test.getTopTipsCells()), true);
	}
	public void testTipsTop5x5(){
		int [][] ans = { {0, 0, 1, 0, 1},
						 {1, 0, 1, 0, 0},
						 {0, 1, 1, 1, 0},
						 {1, 0, 0, 1, 1},
						 {1, 0, 1, 0, 1}};
		ChessController test = new ChessController(10, ans, null,null);
		assertEquals(checkTopTips(5,5,ans,test.getTopTipsCells()), true);
	}

}
