package picross;

/**
 * MainMenuStartRange checks range of start button and does process to go to the stage selection menu
 * @version
 * @author 
 */
public class MainMenuStartRange implements MainMenuCondition{
	/**
	 * Callback from MainMenuCondition
	 */
	public boolean fulfill(int x, int y) {
		return (x > 300 && x < 724 && y > 450 && y < 500);
	}
	
	/**
	 * Callback from MainMenuCondition
	 */
	public void process(MainMenuController mainMenuController){
		// go stage selection
		new StageController(mainMenuController);
	}

	
	
	
////////////function for testing////////////////////////////////
	public String getName()
	{
		return "Start";
	}
}
