/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */
package picross;

import java.awt.Dimension;
import java.util.Vector;
/**
 *  
        
ChessController class is used to manage the game board.
 * @version      
        
Release 1.04 6 Mar 2011
 * @author          
        
Ben Chan, Steven Li, Ken Leung
 */
public class ChessController {
	
	/**  
    
	bClear Indicate the game board is finished.*/
	private boolean bClear;
	
	/**  
    
	chessUI Store the chessUI instance.*/
	private ChessUI chessUI;

    /**  
    
	cell Store all of the cell.*/
	private Cell[][] cells;
	
    /**  
    
	topTipsCells Store the tips on the top of the game board.*/
	private Vector<TopTipsCells> topTipsCells = new Vector<TopTipsCells>();
    /**  
    
	leftTipsCells Store the tips on the left of the game board.*/
	private Vector<LeftTipsCells> leftTipsCells = new Vector<LeftTipsCells>();
	
	/**
	 * pRow store the previous row user clicked
	 */
	private int pRow;
	
	/**
	 * pCol store the previous column user clicked
	 */
	private int pCol;
	
	private int hp;
	
    /**
     * Construct a control class to control the screen and a game board by initialing cell's array, topTipsCells and leftTipsCells.
     * @param cellRows Indicate the number of row of the game board.
     * @param cellCols Indicate the number of column of the game board.
     * @param ans Indicate the answer of the question.
     * @param cellSize Indicate the size of each cell which used for painting.
     * @param chessUI Indicate the UI to put the game board.
     */
	public ChessController(int cellRows, int cellCols, int[][] ans, int cellSize, ChessUI chessUI){
		this.chessUI = chessUI;
		
		bClear = false;
		pRow = -1;
		pCol = -1;
		hp = 5;
		
		// init cell inside chess
		cells = new Cell[cellRows][cellCols];
	    for ( int row=0; row<cellRows; row++) {
	    	for ( int col=0; col<cellCols; col++ ) {
	    		cells[row][col] = new Cell(ans[row][col]==1 ? true : false);
	    	}
	    }
	    
	    // init left tips cell outside chess
	    for ( int row=0; row<cellRows; row++) {
	    	int tipsNum = 0;
	    	int tipsRow = row + 1;
	    	int tipsCol = 1;
	    	boolean hvTips = false;
	    	
	    	for ( int col=cellCols-1; col>=0; col-- ) {
	    		if (ans[row][col]==1) {
	    			tipsNum++;
	    		} 
	    		
    			if (tipsNum>0 && (ans[row][col] == 0 || col == 0)) {
	    			LeftTipsCells tipsCell = new LeftTipsCells(tipsRow, tipsCol++, tipsNum);
	    			leftTipsCells.add(tipsCell);
	    			tipsNum = 0;
	    			hvTips = true;
    			}
	    	}
	    	
	    	if (!hvTips){
	    		LeftTipsCells tipsCell = new LeftTipsCells(tipsRow, 1, 0);
    			leftTipsCells.add(tipsCell);
	    	}
	    }
	    
	    
	 // init top tips cell outside chess
	    for ( int col=0; col<cellCols; col++) {
	    	int tipsNum = 0;
	    	int tipsRow = 1;
	    	int tipsCol = col + 1;
	    	boolean hvTips = false;
	    	
	    	for ( int row=cellRows-1; row>=0; row-- ) {
	    		if (ans[row][col]==1) {
	    			tipsNum++;
	    		} 
	    		
	    		if (tipsNum>0 && (ans[row][col] == 0 || row == 0)) {
	    			TopTipsCells tipsCell = new TopTipsCells(tipsRow++, tipsCol, tipsNum);
	    			topTipsCells.add(tipsCell);
	    			tipsNum = 0;
	    			hvTips = true;
	    		}
	    	}
	    	
	    	if (!hvTips){
	    		TopTipsCells tipsCell = new TopTipsCells(1, tipsCol, 0);
	    		topTipsCells.add(tipsCell);
	    	}
	    }
	}
	
	/**
	 * The process to change the value of the cell based on user input, provide restart and exit option.
	 * @param x The y-axis of mouse cursor
	 * @param y The x-axis of mouse cursor
	 * @param d The dimension of the windows
	 * @param cellRows
	 * @param cellCols
	 * @param cellStartX
	 * @param cellStartY
	 * @param cellSize
	 * @param menuX
	 * @param bClickType
	 */
	public void process(int x, int y, Dimension d, int cellRows, int cellCols, int cellStartX, int cellStartY, int cellSize, int menuX, String bClickType){
		
		
		if (x > cellStartX && x < cellStartX + cellCols * cellSize && y > cellStartY && !bClear && hp > 0) {
			int row = (y-cellStartY)/cellSize;
			int col = (x-cellStartX)/cellSize;
			Cell cell = this.cells[row][col];
			
			if (bClickType == "LEFT") {
				if (!cell.IsAns()){
					// reduce player life
					
					if (--hp == 0)
						chessUI.display("GAME_OVER");
					
					//chessUI.display("PLAYER_HP", hp);
					chessUI.repaint();
				}
			}
			
			if (row != pRow || col != pCol) {
				
				
				if (bClickType == "LEFT" || bClickType == "LEFT_DRAG") {
					if (!cell.IsLeftSelect()) {
						// check if it is ans
						if (cell.IsAns()){
							cell.setLeftSelect(true);
							
							// check clear
							bClear = checkClear(cellRows, cellCols);
						} else if (bClickType == "LEFT_DRAG") {
							hp--;
							//chessUI.display("PLAYER", hp);
						}
						
						chessUI.display("CLICK_CELLS", cells);
						if (bClear) {
							chessUI.display("CLEAR");
						}
						chessUI.repaint();
					}
				} else if (bClickType == "RIGHT") {
					cell.setRightSelect(!cell.IsRightSelect());
					chessUI.display("CLICK_CELLS", cells);
					chessUI.repaint();
				}
			}
			
			pRow = row;
			pCol = col;
		} else if (x > menuX + 20 && x < d.width - 40 && y > 520 && y < 570) {
			// restart button
			chessUI.display("RESTART", cells);
			hp =5;
			//chessUI.display("PLAYER_HP", hp);
			restartGame(cellRows, cellCols);
			chessUI.repaint();
		} else if (x > menuX + 20 && x < d.width - 40 && y > 660 && y < 710) {
			// quit button
			System.exit( 0 );
		}
	}
	
	/*
	public void process() {
		chessUI.display("PLAYER", hp);
	}
	*/
	
	/**
	 * Unselect all the cell and restart the game
	 * @param cellRows The total rows of cells
	 * @param cellCols The total columns of cells
	 */
	public void restartGame(int cellRows, int cellCols) {
		for (int row = 0; row < cellRows; row++){
			for (int col = 0; col < cellCols; col++) {
				cells[row][col].setLeftSelect(false);
				cells[row][col].setRightSelect(false);
			}
		}
		bClear = false;
	}
	
	/**
	 * Unselect all the cell and restart the game
	 * @param cellRows The total rows of cells
	 * @param cellCols The total columns of cells
	 * @return
	 */
	public boolean checkClear(int cellRows, int cellCols) {
		for (int row = 0; row < cellRows; row++){
			for (int col = 0; col < cellCols; col++) {
				if (cells[row][col].IsAns()){
					if (!cells[row][col].IsLeftSelect()){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Return the vector of all TopTipsCells.
	 */
	public Vector<TopTipsCells> getTopTipsCells() {
		return topTipsCells;
	}

	/**
	 * Return the vector of all LeftTipsCells.
	 */
	public Vector<LeftTipsCells> getLeftTipsCells() {
		return leftTipsCells;
	}
	
	public int getHp() {
		return hp;
	}
	
	public Cell[][] getAllCells(){
		return this.cells;
		
	}
}
