package picross;

/**
 * MainMenuQuitRange checks range of quit button and does process to quit main menu
 * @version Release 1.07 23 Mar 2011
 * @author Steven Li, Ben Chan
 */
public class MainMenuQuitRange implements MainMenuCondition{
	/**
	 * Callback from MainMenuCondition
	 */
	public boolean fulfill(int x, int y) {
		return (x > 300 && x < 724 && y > 570 && y < 620);
	}
	
	/**
	 * Callback from MainMenuCondition
	 */
	public void process(MainMenuController mainMenuController){
		mainMenuController.dispose();
	}
	
	////////////function for testing////////////////////////////////
	public String getName()
	{
		return "Quit";
	}
}