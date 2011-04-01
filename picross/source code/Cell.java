/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */

package picross;
/**
 * Cell class is used to store the information of each square on the game board.
 * @version Release 1.04 6 Mar 2011
 * @author Ben Chan, Steven Li
 */

public class Cell {
	
    /**  
     * bIsAns Indicate the answer is true.
     */
	private boolean bIsAns;
	
    /**  
     * bIsLSelect Indicate the answer is selected by user.
     */
	private boolean bIsLSelect;
	
	/**
	 * bIsRSelect Indicate the cell is right-clicked by user
	 */
	private boolean bIsRSelect;
	
	
    /** 
     * Construct a cell which is not yet selected by user.
     */
	public Cell(){
		bIsLSelect = false;
	}
	
    /** 
     * Construct a cell which should be selected by user but not yet selected.
     * @param bIsAns Indicate whether the cell is answer. 
     */
	public Cell(boolean bIsAns){
		this.bIsAns = bIsAns;
		bIsLSelect = false;
		bIsRSelect = false;
	}
	
    /**
     * Set boolean to indicate whether the user has left-clicked the cell.
     */
	public void setLeftSelect(boolean bVal) {
		bIsLSelect = bVal;
		
		if (bIsLSelect)
			bIsRSelect = false;
	}
	
	/**
     * Set boolean to indicate whether the user has right-clicked the cell.
     */
	public void setRightSelect(boolean bVal) {
		if (!bIsLSelect) {
			bIsRSelect = bVal;
		}
	}
	
	/**
     * Return boolean to indicate whether the user has left-clicked the cell.
     */
	public boolean IsLeftSelect() {
		return bIsLSelect;
	}
	
	/**
     * Return boolean to indicate whether the user has right-clicked the cell.
     */
	public boolean IsRightSelect() {
		return bIsRSelect;
	}
	
    /**
     * Return boolean to indicate whether the cell is the answer.
     */
	public boolean IsAns(){
		return bIsAns;
	}
}
