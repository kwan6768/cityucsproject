/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */
package picross;

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
	
	private Player player;
	
	/**  
     * chessUI Store the chessUI instance.
     */
	private ChessUI chessUI;
	
	private MainMenuController mainMenuController;

    /**  
    
	cell Store all of the cell.*/
	private Cell[][] cells;
	
    /**  
    
	topTipsCells Store the tips on the top of the game board.*/
	private Vector<TipsCell> topTipsCells = new Vector<TipsCell>();
    /**  
    
	leftTipsCells Store the tips on the left of the game board.*/
	private Vector<TipsCell> leftTipsCells = new Vector<TipsCell>();
	
	/**
	 * pRow store the previous row user clicked
	 */
	private int pRow;
	
	/**
	 * pCol store the previous column user clicked
	 */
	private int pCol;
	
	private boolean isSelectedOnRC;
	//private String pClickType;
	
	//private int hp;
	
    /**
     * Construct a control class to control the screen and a game board by initialing cell's array, topTipsCells and leftTipsCells.
     * @param cellRows Indicate the number of row of the game board.
     * @param cellCols Indicate the number of column of the game board.
     * @param ans Indicate the answer of the question.
     * @param cellSize Indicate the size of each cell which used for painting.
     * @param chessUI Indicate the UI to put the game board.
     */
	public ChessController(int cellSize, int[][] ans, MainMenuController mainMenuController, StageController stageController){
		bClear = false;
		isSelectedOnRC = false;
		pRow = -1;
		pCol = -1;
		
		this.mainMenuController = mainMenuController;
		chessUI = new ChessUI(cellSize, ans, this);
		chessUI.getCmd();
		
		if (mainMenuController != null) {
			//mainMenuUI.dispose();
			mainMenuController.setVisible(false);
		}
		
		if (stageController != null){
			stageController.dispose();
		}
		
		player = new Player(5);
		
		// init cell inside chess
		
	    cells = initCells(ans);
	    initLeftTipsCells(ans, leftTipsCells);	// init left tips cell outside chess
	    initTopTipsCells(ans, topTipsCells);	// init top tips cell outside chess
	    /*
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
	    			TipsCell tipsCell = new TipsCell(tipsRow, tipsCol++, tipsNum);
	    			leftTipsCells.add(tipsCell);
	    			tipsNum = 0;
	    			hvTips = true;
    			}
	    	}
	    	
	    	if (!hvTips){
	    		TipsCell tipsCell = new TipsCell(tipsRow, 1, 0);
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
	    			TipsCell tipsCell = new TipsCell(tipsRow++, tipsCol, tipsNum);
	    			topTipsCells.add(tipsCell);
	    			tipsNum = 0;
	    			hvTips = true;
	    		}
	    	}
	    	
	    	if (!hvTips){
	    		TipsCell tipsCell = new TipsCell(1, tipsCol, 0);
	    		topTipsCells.add(tipsCell);
	    	}
	    }
	    */
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
	 * @param clickType
	 */
	/*
	public void process(int x, int y, Dimension d, int cellRows, int cellCols, int cellStartX, int cellStartY, int cellSize, int menuX, String clickType){
		if (x > cellStartX && x < cellStartX + cellCols * cellSize && y > cellStartY && !bClear && player.isAlive()) {
			int row = (y-cellStartY)/cellSize;
			int col = (x-cellStartX)/cellSize;
			Cell cell = this.cells[row][col];
			boolean bIsClickSameCell = false;
			
			if (clickType == "LEFT") {
				if (!cell.IsAns()){
					// reduce player life
					player.decreaseHP(1);
					player.display(chessUI);
					
					//chessUI.display("PLAYER_HP", hp);
					chessUI.repaint();
				}
			}
			
			if (((clickType == "LEFT" || clickType == "LEFT_DRAG") && (pClickType == "LEFT" || pClickType == "LEFT_DRAG")) || clickType == pClickType) {
				if (row == pRow && col == pCol) {
					bIsClickSameCell = true;
				}
			}
			
			//if (row != pRow || col != pCol) {
			if (!bIsClickSameCell) {
				if (clickType == "LEFT" || clickType == "LEFT_DRAG") {
					if (!cell.IsLeftSelect()) {
						// check if it is ans
						if (cell.IsAns()){
							cell.setLeftSelect(true);
							
							// check clear
							bClear = checkClear(cellRows, cellCols);
						} else if (clickType == "LEFT_DRAG") {
							player.decreaseHP(1);
							player.display(chessUI);
							//chessUI.display("PLAYER", hp);
						}
						
						chessUI.display("CLICK_CELLS", cells);
						if (bClear) {
							chessUI.display("CLEAR");
						}
						chessUI.repaint();
					}
				} else if (clickType == "RIGHT") {
					cell.setRightSelect(!cell.IsRightSelect());
					chessUI.display("CLICK_CELLS", cells);
					chessUI.repaint();
				}
			}
			
			pClickType = clickType;
			pRow = row;
			pCol = col;
		} else if (x > menuX + 20 && x < d.width - 40 && y > 520 && y < 570 && clickType == "LEFT") {
			// restart button
			chessUI.display("RESTART", cells);
			player.restoreHP();
			player.display(chessUI);
			//chessUI.display("PLAYER_HP", hp);
			restartGame(cellRows, cellCols);
			chessUI.repaint();
		} else if (x > menuX + 20 && x < d.width - 40 && y > 660 && y < 710 && clickType == "LEFT") {
			// back button
			//System.exit( 0 );
			mainMenuController.setVisible(true);
			//chessUI.setVisible(false);
			chessUI.dispose();
		}
	}
	*/
	
	public boolean LCprocess(int x, int y, int cellRows, int cellCols, int menuX) {
		int screenW = chessUI.getSize().width;
		
		if (x > menuX + 20 && x < screenW - 40 && y > 520 && y < 570) {
			// restart button process
			chessUI.displayRestart(cells);
			player.restoreHP();
			player.display(chessUI);
			restartGame(cellRows, cellCols);
			chessUI.repaint();
			return true;
		} else if (x > menuX + 20 && x < screenW - 40 && y > 660 && y < 710) {
			// back button process
			mainMenuController.setVisible(true);
			chessUI.dispose();
			return true;
		} else {
			return false;
		}
		
	}
	
	public void LDprocess(int row, int col, int cellRows, int cellCols) {
		if (row >= 0 && col >= 0 && col < cellCols && !bClear && player.isAlive()) {
			Cell cell = this.cells[row][col];
			
			if (!cell.IsLeftSelect() && !isClickSameCell(row, col)) {
				if (cell.IsAns()){
					cell.setLeftSelect(true);
					
					// check clear
					bClear = checkClear(cellRows, cellCols);
					chessUI.displaySelectedCells(cells);
					if (bClear) {
						chessUI.displayClear();
					}
				} else {//if (!cell.IsAns()){
					// reduce player life
					player.decreaseHP(1);
					player.display(chessUI);
				}
				chessUI.repaint();
			}
			
			pRow = row;
			pCol = col;
		}
	}
	
	public void RCprocess(int row, int col, int cellCols) {
		if (row >= 0 && col >= 0 && col < cellCols && !bClear && player.isAlive()) {
			Cell cell = this.cells[row][col];
			isSelectedOnRC = cell.IsRightSelect();
		}
	}
	
	//public void RDprocess(int x, int y, int cellRows, int cellCols, int cellStartX, int cellStartY, int cellSize, int menuX) {
	public void RDprocess(int row, int col, int cellCols) {
		if (row >= 0 && col >= 0 && col < cellCols && !bClear && player.isAlive()) {
			Cell cell = this.cells[row][col];
			
			if (!cell.IsLeftSelect() && !isClickSameCell(row, col)) {
				//cell.setRightSelect(!cell.IsRightSelect());
				cell.setRightSelect(!isSelectedOnRC);
				chessUI.displaySelectedCells(cells);
				chessUI.repaint();
			}
			
			pRow = row;
			pCol = col;
		}
	}
	
	public void mouseReleaseProcess(){
		pRow = -1;
		pCol = -1;
	}
	
	private boolean isClickSameCell(int row, int col) {
		return (row == pRow && col == pCol);
	}
	
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
	public Vector<TipsCell> getTopTipsCells() {
		return topTipsCells;
	}

	/**
	 * Return the vector of all LeftTipsCells.
	 */
	public Vector<TipsCell> getLeftTipsCells() {
		return leftTipsCells;
	}
	
	public void displayHP(ChessUI chessUI) {
		player.display(chessUI);
	}
	
	private void initLeftTipsCells(int ans[][], Vector<TipsCell> tipsCells) {
		int cellCols = ans[0].length;
	    int cellRows = ans.length;
		
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
	    			TipsCell tCell = new TipsCell(tipsRow, tipsCol++, tipsNum);
	    			tipsCells.add(tCell);
	    			tipsNum = 0;
	    			hvTips = true;
    			}
	    	}
	    	
	    	if (!hvTips){
	    		TipsCell tipsCell = new TipsCell(tipsRow, 1, 0);
	    		tipsCells.add(tipsCell);
	    	}
	    }
	}
	
	private void initTopTipsCells(int ans[][], Vector<TipsCell> tipsCells) {
		int cellCols = ans[0].length;
	    int cellRows = ans.length;
	    
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
	    			TipsCell tCell = new TipsCell(tipsRow++, tipsCol, tipsNum);
	    			tipsCells.add(tCell);
	    			tipsNum = 0;
	    			hvTips = true;
	    		}
	    	}
	    	
	    	if (!hvTips){
	    		TipsCell tipsCell = new TipsCell(1, tipsCol, 0);
	    		tipsCells.add(tipsCell);
	    	}
	    }
	}
	
	private Cell[][] initCells(int ans[][]) {
		int cellCols = ans[0].length;
	    int cellRows = ans.length;
	    
		cells = new Cell[cellRows][cellCols];
	    for ( int row=0; row<cellRows; row++) {
	    	for ( int col=0; col<cellCols; col++ ) {
	    		cells[row][col] = new Cell(ans[row][col]==1 ? true : false);
	    	}
	    }
	    
	    return cells;
	}
	
	public Cell[][] getAllCells(){
		return this.cells;
		
	}
}
