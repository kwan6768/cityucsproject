package picross;

interface MainMenuCondition {
	public boolean fulfill(int x, int y);
	public void process(MainMenuController mainMenuController);
}

