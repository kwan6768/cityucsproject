package picross;

/**
 * Player stores and manages the HP of the user
 * @version
 * @author Steven Li
 */
public class Player {
	/**
	 * maxHP store the maximum HP
	 */
	private int maxHP;
	
	/**
	 * curHP store the current HP
	 */
	private int curHP;
	
	/**
	 * Construct a player
	 * @param hp HP of user
	 */
	public Player(int hp) {
		maxHP = hp;
		curHP = hp;
	}
	
	/**
	 * Display the current HP
	 * Also, display "Game Over" if HP is 0
	 * @param chessUI The object of the boundary class of chess
	 */
	public void display(ChessUI chessUI){
		chessUI.displayHP(curHP);
		if (curHP == 0) {
			chessUI.displayGameOver();
		}
	}
	
	/**
	 * Decrease HP of the user
	 * @param hp The point of HP is decreased
	 */
	public void decreaseHP(int hp) {
		curHP -= hp;
	}
	
	/**
	 * Restore the current HP to the maximum HP
	 */
	public void restoreHP() {
		curHP = maxHP;
	}
	
	/**
	 * Check if player is alive
	 * @return
	 */
	public boolean isAlive() {
		return (curHP > 0);
	}
	
	
	////////////function for testing////////////////////////////////
	public int getMaxHP()
	{
		return this.maxHP;
	}
	
	public int getCurHP()
	{
		return this.curHP;
	}
}
