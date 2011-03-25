package picross;

public class TutoController {
	private TutoUI tutoUI;
	private MainMenuController mainMenuController;
	public TutoController(MainMenuController mainMenuController) {
		tutoUI = new TutoUI(this);
		tutoUI.getCmd();
		
		this.mainMenuController = mainMenuController;
		mainMenuController.setVisible(false);
	}
	
	public void process(int x, int y) {
		// back to main menu
		mainMenuController.setVisible(true);
		tutoUI.dispose();
	}
}
