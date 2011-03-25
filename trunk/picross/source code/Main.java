/*
 * @(#)Cell.java        Release 1.04 2011/3/6
 *
 * 
 */
package picross;


/**
 *  
        
Chess class is used to store the information of each question.
 *
 * @version      
        
Release 1.04 6 Mar 2011
 * @author          
        
Ben Chan, Steven Li, Ken Leung
 */

/*
private int[][] ans = { {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		*/

/*
private int[][] ans = { {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
						{0, 1, 1, 1, 0, 1, 1, 1, 0, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
						{0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
						{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
						{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
						{0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
						{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}};
*/	

public class Main {
	/**
     * 
	Start the game and initiate some parameters..
     */
	public static void main(String args[]) {
		//Game game = new Game();
		//Main main = new Main();
		/*
		int[][] ans = { {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
				{0, 1, 1, 1, 0, 1, 1, 1, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
				{0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
				{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
				{0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}};
		int max;
		  
		//cellSize = 60;
		int cellCols = ans[0].length;
	    int cellRows = ans.length;
	    
	    if (cellCols > cellRows)
	    	max = cellCols;
	    else
	    	max = cellRows;
	
	    max = 768 / (max+(int)Math.ceil((double)max / 2.0));
	    int cellSize = max;
	    
	    ChessUI chessUI = new ChessUI(cellRows, cellCols, cellSize, ans);
		chessUI.getCmd();
		*/
		MainMenuUI mainMenuUI = new MainMenuUI();
		mainMenuUI.getCmd();
		
	}
}
