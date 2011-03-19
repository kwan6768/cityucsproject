
/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */

package picross;
/**
 *  
        
TopTipsCells is used to store the tip cells on the top.
 *
 * @version      
        
Release 1.04 6 Mar 2011
 * @author          
        
Ben Chan
 */

public class TopTipsCells extends TipsCell{
	/**  
    Construct the top tip cell.
    
    @param row The row of the tip cell
    @param col The column of the tip cell
    @param tipsNum The tip number of the tip cell
    */
	public TopTipsCells(int row, int col, int tipsNum) {
		super(row, col, tipsNum);
		// TODO Auto-generated constructor stub
	}
}
