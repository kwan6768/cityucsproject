package picross;

public class Player {
	private int maxHP;
	private int curHP;
	
	public Player(int hp) {
		maxHP = hp;
		curHP = hp;
	}
	
	public void display(ChessUI chessUI){
		chessUI.displayHP(curHP);
		if (curHP == 0) {
			chessUI.displayGameOver();
		}
	}
	
	public void decreaseHP(int hp) {
		curHP -= hp;
	}
	
	public void restoreHP() {
		curHP = maxHP;
	}
	
	public boolean isAlive() {
		return (curHP > 0);
	}
}
