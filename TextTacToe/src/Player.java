/**
 * 
 * @author JGreeny
 *
 * The Player class holds basic information about the player.
 * Each player has a name, a game piece (X or O), and a score.
 * 
 * Players' score are per game, and do not carry over from game to game.
 *
 */

public class Player {
	String name;
	int score;
	char gamePiece;
	
	public Player(char piece) {
		gamePiece = piece;
		score = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public char getGamePiece() {
		return gamePiece;
	}
	
	public void setGamePiece(char piece) {
		gamePiece = piece;
	}
}
