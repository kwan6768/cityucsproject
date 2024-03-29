package picross;

/**
 * MainMenuTutoRange checks range of tuto button and does process to go to the tutorial menu
 * @version Release 1.07 23 Mar 2011
 * @author Steven Li, Ben Chan
 */
public class MainMenuTutoRange implements MainMenuCondition{
	/**
	 * Callback from MainMenuCondition
	 */
	public boolean fulfill(int x, int y) {
		return (x > 300 && x < 724 && y > 510 && y < 560);
	}
	
	/**
	 * Callback from MainMenuCondition
	 */
	public void process(MainMenuController mainMenuController){
		new TutoController(mainMenuController);
	}
	
	/*
////////////function for testing////////////////////////////////
	public String getName()
	{
		return "Tutor";
	}
	*/
}
