package picross;

/**
 * StageRange1 checks range of stage 1 button(5x5) and does process to start stage 1(5x5) game
 * @version Release 1.08 1 Apr 2011
 * @author Ben Chan
 */
public class StageRange1 implements StageCondition{
	/**
	 * Callback from MainMenuCondition
	 */
	public boolean fulfill(int x, int y) {
		return (x > 300 && x < 724 && y > 450 && y < 500);
	}
	
	/**
	 * Callback from MainMenuCondition
	 */
	public void process(StageController stageController){
		int[][] ans = { {0, 0, 1, 0, 0},
						{0, 1, 1, 1, 0},
						{1, 1, 1, 1, 1},
						{0, 0, 1, 0, 0},
						{0, 0, 1, 0, 0}};
		stageController.startGame(ans);
	}
}