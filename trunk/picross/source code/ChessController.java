/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */
package picross;

import java.util.Vector;
/**
 * ChessController class is used to manage the game board.
 * @version Release 1.05 10 Mar 2011
 * @author Ben Chan, Steven Li, Ken Leung
 */

public class ChessController {
	
	/**  
	 * bClear Indicate if the game board is finished.
	 * */
	private boolean bClear;
	
	/**
	 * player Indicate the user playing
	 */
	private Player player;
	
	/**  
     * chessUI Store the chessUI instance.
     */
	private ChessUI chessUI;
	
	/**
	 * mainMenuController store the object of control class of main menu
	 */
	private MainMenuController mainMenuController;

    /**  
     * cells Store all of the cell.
     */
	private Cell[][] cells;
	
    /**  
     * topTipsCells Store the tips on the top of the game board.
     */
	private Vector<TipsCell> topTipsCells = new Vector<TipsCell>();
    /**  
     * leftTipsCells Store the tips on the left of the game board.
     */
	private Vector<TipsCell> leftTipsCells = new Vector<TipsCell>();
	
	/**
	 * pRow store the previous row user clicked
	 */
	private int pRow;
	
	/**
	 * pCol store the previous column user clicked
	 */
	private int pCol;
	
	/**
	 * isSelectedOnRC Indicate if the cell is right-clicked
	 */
	private boolean isSelectedOnRC;
	
	//private Vector<ChessCondition> conditions = new Vector<ChessCondition>();
	
	/**
	 * Construct a control class to control the screen and a game board by initialing cell's array, topTipsCells and leftTipsCells.
	 * @param cellSize Indicate the size of each cell which used for painting.
	 * @param ans Indicate the answer of the question.
	 * @param mainMenuController The object of control class of main menu
	 * @param stageController The object of control class of stage
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
			mainMenuController.setVisible(false);
		}
		
		if (stageController != null){
			stageController.dispose();
		}
		
		// set the hp of player as 5
		player = new Player(5);
		
	    cells = initCells(ans);		// init cell inside chess
	    initLeftTipsCells(ans, leftTipsCells);	// init left tips cell outside chess
	    initTopTipsCells(ans, topTipsCells);	// init top tips cell outside chess
	    
	    //createCondition(new ChessBackRange());
	    //createCondition(new ChessRestartRange());
	}
	
	/*
	public void createCondition(ChessCondition condition){
		conditions.add(condition);
	}
	*/
	
	/**
	 * The process of game on mouse left click
	 * @param x The y-axis of mouse cursor
	 * @param y The x-axis of mouse cursor
	 * @param cellRows The total cell rows of the chess
	 * @param cellCols The total cell columns of the chess
	 * @param menuX The x-coordinate of menu
	 */
	public boolean LCprocess(int x, int y, int cellRows, int cellCols, int menuX) {
		int screenW = chessUI.getSize().width;
		
		/*
		for (int i=0; i<conditions.size(); i++) {
			if (conditions.get(i).fulfill(x, y, menuX, screenW)){
				conditions.get(i).process(this);
			}
		}
		*/
		
		if (x > menuX + 20 && x < screenW - 40 && y > 520 && y < 570) {
			//restart button process
			chessUI.displayRestart(cells);
			player.restoreHP();
			player.display(chessUI);
			restartGame(cellRows, cellCols);
			chessUI.repaint();
			return true;
		} else if (x > menuX + 20 && x < screenW - 40 && y > 660 && y < 710) {
			// back button process
			mainMenuController.setVisible(true, this);
			//chessUI.dispose();
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * The process of game on mouse left draft
	 * @param row The chess row under mouse cursor 
	 * @param col The chess column under mouse cursor
	 * @param cellRows The total cell rows of the chess
	 * @param cellCols The total cell columns of the chess
	 */
	public void LDprocess(int row, int col, int cellRows, int cellCols) {
		if (row >= 0 && row < cellRows && col >= 0 && col < cellCols && !bClear && player.isAlive()) {
			// check clear
			
			Cell cell = this.cells[row][col];
					
			if (!cell.IsLeftSelect() && !isClickSameCell(row, col)) {
				if (cell.IsAns()){
					cell.setLeftSelect(true);
					
					bClear = checkClear(cellRows, cellCols);
					
					chessUI.displayClear(bClear);
					chessUI.displaySelectedCells(cells);
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
		/*
		if (row >= 0 && row < cellRows && col >= 0 && col < cellCols && !bClear && player.isAlive()) {
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
		*/
	}
	
	/**
	 * The process of game on mouse right click
	 * @param row The chess row under mouse cursor 
	 * @param col The chess column under mouse cursor
	 * @param cellCols The total cell columns of the chess
	 */
	public void RCprocess(int row, int col, int cellRows, int cellCols) {
		if (row >= 0 && row < cellRows && col >= 0 && col < cellCols && !bClear && player.isAlive()) {
			Cell cell = this.cells[row][col];
			isSelectedOnRC = cell.IsRightSelect();
		}
		
		RDprocess(row, col, cellRows, cellCols);
	}
	
	/**
	 * The process of game on mouse right draft
	 * @param row The chess row under mouse cursor 
	 * @param col The chess column under mouse cursor
	 * @param cellCols The total cell columns of the chess
	 */
	public void RDprocess(int row, int col, int cellRows, int cellCols) {
		if (row >= 0 && row < cellRows && col >= 0 && col < cellCols && !bClear && player.isAlive()) {
			
			Cell cell = cells[row][col];
			
			if (!cell.IsLeftSelect() && !isClickSameCell(row, col)) {
				cell.setRightSelect(!isSelectedOnRC);
				//cell.setRightSelect(!cell.IsRightSelect());
				chessUI.displaySelectedCells(cells);
				chessUI.repaint();
			}
			
			pRow = row;
			pCol = col;
		}
	}
	
	/**
	 * The process of game on releasing mouse click
	 */
	public void mouseReleaseProcess(){
		pRow = -1;
		pCol = -1;
	}
	
	/**
	 * Check if the cell the user click is the answer
	 * @param row The chess row under mouse cursor 
	 * @param col The chess column under mouse cursor
	 */
	private boolean isClickSameCell(int row, int col) {
		return (row == pRow && col == pCol);
	}
	
	/**
	 * Restart the game by deselecting all the cell and 
	 * @param cellRows The total rows of cells
	 * @param cellCols The total columns of cells
	 */
	private void restartGame(int cellRows, int cellCols) {
		for (int row = 0; row < cellRows; row++){
			for (int col = 0; col < cellCols; col++) {
				cells[row][col].setLeftSelect(false);
				cells[row][col].setRightSelect(false);
			}
		}
		bClear = false;
	}
	
	/**
	 * Check if the game is clear
	 * @param cellRows The total rows of cells
	 * @param cellCols The total columns of cells
	 */
	private boolean checkClear(int cellRows, int cellCols) {
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
	
	/**
	 * Display HP on the screen
	 * @param chessUI The object of boundary class of chess
	 */
	public void displayHP(ChessUI chessUI) {
		player.display(chessUI);
	}
	
	/**
	 * Init all the left tips cells
	 * @param ans The answer of the stage
	 * @param tipsCells The cells of left tips
	 */
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
	
	/**
	 * Init all the top tips cells
	 * @param ans The answer of the stage
	 * @param tipsCells The cells of top tips
	 */
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
	
	/**
	 * Init all the cells inside the chess
	 * @param ans The answer of the stage
	 */
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
	
	/**
	 * Dispose the screen of main menu and exit program
	 */
	public void dispose() {
		chessUI.dispose();
		chessUI = null;
	}

//////////////////////////////////////function add for testing///////////////////////////////////////
	public Cell[][] getAllCells(){
		return this.cells;
		
	}

	public ChessUI getChessUI()
	{
		return this.chessUI;
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
	
	public void testRestartGame(int cellRows, int cellCols)
	{
		restartGame(cellRows, cellCols);
	}
	
	public boolean testCheckClear(int cellRows, int cellCols) {
		return checkClear(cellRows, cellCols);
	}
}
