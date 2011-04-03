package stub;

import picross.MainMenuController;
import stub.StubMainMenuUI;


public class StubMainMenuController extends MainMenuController{

	public StubMainMenuController() {
		super(new StubMainMenuUI());
	}

	public void dispose() {
	}

}
