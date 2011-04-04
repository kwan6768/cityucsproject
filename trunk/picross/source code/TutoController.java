package picross;

/**
 * TutoController class is used to manage the tutorial board.
 * @version Release 1.08 1 Apr 2011
 * @author Steven Li, Ken Leung
 */
public class TutoController {
	/**
	 * tutoUI stores the object of tutorial user interface
	 */
	private TutoUI tutoUI;
	
	/**
	 * mainMenuController stores the object of the control class of main menu
	 */
	private MainMenuController mainMenuController;
	
	/**
	 * Construct TutoController
	 * @param mainMenuController Indicates the object of control class of main menu
	 */
	public TutoController(MainMenuController mainMenuController) {
		tutoUI = new TutoUI(this);
		tutoUI.getCmd();
		
		this.mainMenuController = mainMenuController;
		mainMenuController.setVisible(false);
	}
	
	/**
	 * Do process to determine if user go back main menu
	 * @param x x-coordinate of mouse cursor
	 * @param y y-coordinate of mouse cursor
	 */
	public void process(int x, int y) {
		// back to main menu
		if (x > 300 && x < 724 && y > 640 && y < 690) {
			mainMenuController.setVisible(true, this);
			//tutoUI.dispose();
		}
	}
	
	/**
	 * Dispose the screen of main menu and exit program
	 */
	public void dispose() {
		tutoUI.dispose();
	}
}
