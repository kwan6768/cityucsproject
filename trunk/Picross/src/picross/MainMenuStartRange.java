package picross;

public class MainMenuStartRange implements MainMenuCondition{
	public boolean fulfill(int x, int y) {
		if (x > 300 && x < 724 && y > 450 && y < 500){
			return true;
		} else {
			return false;
		}
	}
}
