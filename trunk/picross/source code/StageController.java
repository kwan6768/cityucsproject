package picross;

public class StageController {
	private StageUI stageUI;
	private MainMenuController mainMenuController;
	public StageController(MainMenuController mainMenuController) {
		stageUI = new StageUI(this);
		stageUI.getCmd();
		
		this.mainMenuController = mainMenuController;
		mainMenuController.setVisible(false);
	}
	
	public void process(int x, int y) {
		// back to main menu
		//mainMenuController.setVisible(true);
		//tutoUI.dispose();
		
		// start stage game
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
	    
	    //ChessUI chessUI = new ChessUI(cellRows, cellCols, cellSize, ans);
	    
	    //chessUI.getCmd();
	    //mainMenuUI.dispose();
	    //mainMenuController.startGame(cellRows, cellCols, cellSize, ans);
	    new ChessController(cellSize, ans, mainMenuController, this);
	}
	
	private boolean validateAns(int ans[][]) {
		return false;
	}
	
	public void dispose() {
		stageUI.dispose();
	}
}
