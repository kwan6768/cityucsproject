package picross;

/**
 * StageRange2 checks range of stage 2 button(10x10) and does process to start stage 2(10x10) game
 * @version Release 1.08 1 Apr 2011
 * @author Ben Chan
 */
public class StageRange2 implements StageCondition{
	/**
	 * Callback from MainMenuCondition
	 */
	public boolean fulfill(int x, int y) {
		return (x > 300 && x < 724 && y > 510 && y < 560);
	}
	
	/**
	 * Callback from MainMenuCondition
	 */
	public void process(StageController stageController){
		int[][] ans = { {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
						{0, 1, 1, 1, 0, 1, 1, 1, 0, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
						{0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
						{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
						{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
						{0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
						{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}};
		stageController.startGame(ans);
	}
}