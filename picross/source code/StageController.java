package picross;

import java.util.Vector;

/**
 * StageController class is used to manage the selection stage board.
 * @version Release 1.08 1 Apr 2011
 * @author Steven Li, Ben Chan, Ken Leung
 */
public class StageController implements StageConditionCreator{
	/**
	 * stageUI indicates the user interface of stage.
	 */
	private StageUI stageUI;
	
	/**
	 * mainMenuController store the object of control class of main menu.
	 */
	private MainMenuController mainMenuController;
	
	/**
	 * conditions stores the conditions of the stage.
	 */
	private Vector<StageCondition> conditions = new Vector<StageCondition>();
	
	/**
	 * Constructs StageController
	 * @param mainMenuController The object of control class of main menu.
	 */
	public StageController(MainMenuController mainMenuController) {
		stageUI = new StageUI(this);
		stageUI.getCmd();
		
		if (mainMenuController != null){
			this.mainMenuController = mainMenuController;
			mainMenuController.setVisible(false);
		}
		
		createCondition(new StageRange1());
		createCondition(new StageRange2());
		createCondition(new StageRange3());
	}
	
	/**
	 * Callback from StageConditionCreator
	 */
	public void createCondition(StageCondition condition) {
		conditions.add(condition);
	}
	
	/**
	 * Callback from StageConditionCreator
	 */
	public void process(int x, int y) {
		// back to main menu
		for (int i=0; i<conditions.size(); i++) {
			if (conditions.get(i).fulfill(x, y)){
				conditions.get(i).process(this);
			}
		}
	}
	
	/**
	 * Start the game of the answer on Chess user interface.
	 * @param ans Indicate the answer of the question.
	 */
	public boolean startGame(int ans[][]) {
		if (validateAns(ans)){
			int max;
			int cellCols = ans[0].length;
		    int cellRows = ans.length;
		    
		    if (cellCols > cellRows)
		    	max = cellCols;
		    else
		    	max = cellRows;
		    
		    max = 768 / (max+(int)Math.ceil((double)max / 2.0));
		    int cellSize = max;
		    
		    new ChessController(cellSize, ans, mainMenuController, this);
		    return true;
		} else {
			stageUI.displayError();
			stageUI.repaint();
			return false;
		}
	}
	
	/**
	 * Validate the answer.
	 * The integer array must be square.
	 * The value must be 1 or 0.
	 * @param ans Indicate the answer of the question.
	 */
	private boolean validateAns(int ans[][]) {
		int col = ans[0].length;
	    int row = ans.length;
	    
	    for (int i=1; i<row; i++) {
	    	
	    	if (ans[i].length != col) {
	    		return false;
	    	}
	    }
	    
	    for (int i=0; i< row; i++) {
	    	for (int j=0; j<col; j++) {
	    		if (ans[i][j] != 0 && ans[i][j] != 1) {
	    			return false;
	    		}
	    	}
	    }
		return true;
	}
	
	/**
	 * Dispose the screen of main menu and exit program
	 */
	public void dispose() {
		stageUI.dispose();
		stageUI = null;
	}
	
	// test function
	public boolean testValidateAns(int ans[][])
	{
		return validateAns(ans);
	}
	
	public StageUI getStageUI()
	{
		return stageUI;
	}
}
