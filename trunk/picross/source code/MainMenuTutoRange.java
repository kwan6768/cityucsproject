package picross;

public class MainMenuTutoRange implements MainMenuCondition{
	public boolean fulfill(int x, int y) {
		if (x > 300 && x < 724 && y > 510 && y < 560){
			return true;
		} else {
			return false;
		}
	}
	
	public void process(MainMenuController mainMenuController){
		//mainMenuUI.dispose();
		//new TutoController
		new TutoController(mainMenuController);
	}
}