package picross;

public class MainMenuController {
	private MainMenuUI mainMenuUI;
	
	public MainMenuController(MainMenuUI mainMenuUI){
		this.mainMenuUI = mainMenuUI;
	}
	
	public void process(int x, int y) {
		MainMenuCondition conditions[] = {new MainMenuStartRange(),
										  new MainMenuTutoRange(),
										  new MainMenuQuitRange()};
		boolean bFulfill[] = new boolean[conditions.length];
		
		for (int i=0; i<conditions.length; i++){
			bFulfill[i] = conditions[i].fulfill(x, y); 
		}
		
		if (bFulfill[0] == true) {
			// start game
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
		    mainMenuUI.dispose();
			
		} else if (bFulfill[1] == true) {
			// tuto
		} else if (bFulfill[2] == true) {
			// quit
			System.exit(0);
		}
	}
}
