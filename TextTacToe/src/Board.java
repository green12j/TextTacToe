/**
 * 
 * @author JGreeny
 *
 * The Board class provides a basic 'board' for the game to be played on.
 * The board is structured with a 3x3 array of characters.
 * 
 * This class gives us a means of clearing the board, checking the winning state of the board,
 * printing the board, and placing pieces on the board.
 *
 */

public class Board {
	private char board[][];

	public Board() {
		board = new char[3][3];
		clearBoard();
	}
	
	public boolean isWin() {
		return ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]) && (board[0][2] != ' ')) ||
				((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]) && (board[1][2] != ' ')) ||
				((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]) && (board[2][2] != ' ')) ||
				((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]) && (board[2][0] != ' ')) ||
				((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]) && (board[2][1] != ' ')) ||
				((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]) && (board[2][2] != ' ')) ||
				((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[2][2] != ' ')) ||
				((board[2][0] == board[1][1]) && (board[1][1] == board[0][2]) && (board[0][2] != ' '));
	}
	
	public void printBoard() {
		System.out.printf("%c | %c | %c\n", board[0][0],board[0][1],board[0][2]);
		System.out.println("---------");
		System.out.printf("%c | %c | %c\n", board[1][0],board[1][1],board[1][2]);
		System.out.println("---------");
		System.out.printf("%c | %c | %c\n", board[2][0],board[2][1],board[2][2]);
	}
	
	public void placeGamePiece(char piece, int location) {
		board[(int) Math.ceil(location / 3.0) - 1][(location - 1) % 3] = piece;
	}
	
	public void clearBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
}
