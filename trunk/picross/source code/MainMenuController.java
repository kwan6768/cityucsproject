package picross;

import java.util.Vector;

public class MainMenuController implements MainMenuConditionCreator{
	private MainMenuUI mainMenuUI;
	//private ChessController chessController;
	private Vector<MainMenuCondition> conditions = new Vector<MainMenuCondition>();
	
	public MainMenuController(MainMenuUI mainMenuUI){
		this.mainMenuUI = mainMenuUI;
		
		createCondition(new MainMenuStartRange());
		createCondition(new MainMenuTutoRange());
		createCondition(new MainMenuQuitRange());
	}
	
	public void createCondition(MainMenuCondition condition){
		conditions.add(condition);
	}
	
	public void process(int x, int y) {
		for (int i=0; i<conditions.size(); i++){
			if (conditions.get(i).fulfill(x, y)) {
				conditions.get(i).process(this);
			}
		}
	}
	
	public void dispose() {
		mainMenuUI.dispose();
		System.exit(0);
	}
	
	public void setVisible(boolean bVal){
		mainMenuUI.setVisible(bVal);
	}
	
	/*
	public void startGame(int cellRows, int cellCols, int cellSize, int ans[][]) {
		chessController = new ChessController(cellRows, cellCols, cellSize, ans, this);
	}
	*/
}
