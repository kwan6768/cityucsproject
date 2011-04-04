package picross;

/**
 * StageCondition is the interface of all stage selection menu conditions
 * @version Release 1.08 1 Apr 2011
 * @author Ben Chan
 */
public interface StageCondition {

	/**
	 * Check if the parameters fulfill the condition
	 * @param x The x-coordinate of mouse cursor
	 * @param y The y-coordinate of mouse cursor
	 */
	public boolean fulfill(int x, int y);
	
	/**
	 * Do process on the condition of stage selection menu
	 * @param mainMenuController The object of the control class of main menu
	 */
	public void process(StageController stageController);
}
