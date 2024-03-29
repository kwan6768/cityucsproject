package picross;

/**
 * MainMenuCondition is the interface of all main menu conditions
 * @version Release 1.07 23 Mar 2011
 * @author Steven Li 
 */

interface MainMenuCondition {
	/**
	 * Check if the parameters fulfill the condition
	 * @param x The x-coordinate of mouse cursor
	 * @param y The y-coordinate of mouse cursor
	 */
	public boolean fulfill(int x, int y);
	
	/**
	 * Do process on the condition
	 * @param mainMenuController The object of the control class of main menu
	 */
	public void process(MainMenuController mainMenuController);
	/*
////////////function for testing////////////////////////////////	
	public String getName();
	*/
	
}

