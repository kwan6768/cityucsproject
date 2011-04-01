/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */

package picross;
/**
 *  
        
ChessUI is used to be the interface to interact with user.
 *
 * @version      
        
Release 1.04 6 Mar 2011
 * @author          
        
Ben Chan, Steven Li, Ken Leung
 */
public class TipsCell {
	
	/**  
	 * row Indicate the y-axis of the cell.
	 * */
	int row;
	/**  
	 * col Indicate the s-axis of the cell.
	 */
	int col;
	/**  
	 * tipsNum Indicate the tips number of the cell.
	 */
	int tipsNum;
	/**
	 * bIsLSelect Indicate whether the cell is selected.
	 */
	boolean bIsLSelect;
	
	/**
	 * Construct the tip cell.
	 * @param row The row of the tip cell
	 * @param col The column of the tip cell
	 * @param tipsNum The tip number of the tip cell
	 */
	public TipsCell(int row, int col, int tipsNum) {
		this.row = row;
		this.col = col;
		this.tipsNum = tipsNum;
		bIsLSelect = false;
	}
	
	/**
     * Return the row of a cell .
     */
	public int getRow() {
		return row;
	}
	
	/**
     * Return the col of a cell .
     */
	public int getCol() {
		return col;
	}
	
	/**
     * Return the tip number of a cell .
     */
	public int getTipsNum() {
		return tipsNum;
	}
}
