package picross;

import java.util.Vector;

/**
 * MainMenuController is used to control main menu
 * @author LI HO YIN
 *
 */
public class MainMenuController implements MainMenuConditionCreator{
	/**
	 * mainMenuUI indicates boundary class of main menu
	 */
	private MainMenuUI mainMenuUI;
	/**
	 * conditions stores the conditions of the main menu
	 */
	private Vector<MainMenuCondition> conditions = new Vector<MainMenuCondition>();
	
	/**
	 * Constructs MainMenuController
	 * @param mainMenuUI The object of boundary class of main menu
	 */
	public MainMenuController(MainMenuUI mainMenuUI){
		this.mainMenuUI = mainMenuUI;
		
		createCondition(new MainMenuStartRange());
		createCondition(new MainMenuTutoRange());
		createCondition(new MainMenuQuitRange());
	}

	/**
	 * Callback from MainMenuConditionCreator
	 */
	public void createCondition(MainMenuCondition condition){
		conditions.add(condition);
	}
	

	

	
	/**
	 * Set the visibility of the screen of main menu
	 * @param bVal Visibility
	 */
	public void setVisible(boolean bVal){
		mainMenuUI.setVisible(bVal);
	}
	

	
	
	/**
	 * Do process under fulfillment of the condition(s)
	 * @param x x-coordinate of mouse cursor
	 * @param y y-coordinate of mouse cursor
	 */

	public void process(int x, int y) {
		for (int i=0; i<conditions.size(); i++){
			if (conditions.get(i).fulfill(x, y)) {
				conditions.get(i).process(this);
			}
		}
	}
	

	
	/**
	 * Dispose the screen of main menu and exit program
	 */

	public void dispose() {
		mainMenuUI.dispose();
		System.exit(0);
	}

	
	
///////////////////////////////function for testing////////////////////////////////
/*
 	public String process(int x, int y) {
		for (int i=0; i<conditions.size(); i++){
			if (conditions.get(i).fulfill(x, y)) {
				  return conditions.get(i).getName();		 
			}
		}
		
		return "null";
	}
 	
 	public MainMenuUI getMainMenuUI()
 	{
 		return this.mainMenuUI;
 	}
 		
	public void dispose() {
		mainMenuUI.dispose();
	}
	
*/	
}
