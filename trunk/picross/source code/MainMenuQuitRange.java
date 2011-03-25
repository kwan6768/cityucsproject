package picross;

public class MainMenuQuitRange implements MainMenuCondition{
	public boolean fulfill(int x, int y) {
		if (x > 300 && x < 724 && y > 570 && y < 620){
			return true;
		} else {
			return false;
		}
	}
	
	public void process(MainMenuController mainMenuController){
		mainMenuController.dispose();
	}
}