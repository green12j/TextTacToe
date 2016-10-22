/**
 * 
 * @author JGreeny
 * 
 * This program simulates the classic Tic-Tac-Toe game in a text form.
 * 
 * This game currently only supports two players, no player vs AI!
 * 
 * Once the game is started, the two players will each enter their name into
 * the console. The players will take turns placing X's and O's into the 3x3 grid
 * by choosing a number (1 through 9) that corresponds to the space they would
 * like to play in. Once 1) the board is full or 2) a player places three of 
 * their pieces in a row, the current match will end and the winner (if there
 * is one) will be determined.
 * 
 * Each "game" can last as long as the players are willing to play, and consists
 * of multiple matches. The game will keep score of the number of individual
 * matches each player wins until they choose to end the game.
 *
 * After each turn, an updated board will display in the console so the players
 * can see where the pieces are at and which spots are open.
 * 
 * After each match the players will be presented with a prompt with 3 options:
 * 		1) Continue the current game (starting a new match).
 * 		2) Start a new game (erase the players' scores and start over).
 * 		3) Exit the game (terminate the program).
 * 
 * The 3x3 grid is arranged in this manner:
 * 		1 | 2 | 3
 * 		---------
 * 		4 | 5 | 6
 * 		---------
 * 		7 | 8 | 9
 * To play in a square, the player simply enters the corresponding number.
 * 
 */

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		
		Player player1 = new Player('X');
		Player player2 = new Player('O');
		
		Board b1 = new Board();
		
		boolean newGame = true,
				stillPlaying = true,
				win;
		
		int answer = 0;
		
		System.out.println("Welcome to Text-Tac-Toe!");
		System.out.println("Player 1 is X, player 2 is O.");
		
		do {
			if (newGame) {
				//Initialize player 1
				System.out.print("What is the first player's name?: ");
				player1 = new Player('X');
				player1.setName(userIn.nextLine());
				
				//Initialize player 2
				System.out.print("What is the second player's name?: ");
				player2 = new Player('O');
				player2.setName(userIn.nextLine());
				
				newGame = false;
			}
			
			b1.clearBoard();
			win = false;
			
			for(int i = 0; i < 9; i++){
				//Player 1 moves on even turns
				if(i % 2 == 0) {
					b1.printBoard();
					System.out.printf("%s, enter your move: ", player1.name);
					b1.placeGamePiece(player1.gamePiece, userIn.nextInt());
					if(b1.isWin()) {
						player1.setScore(player1.getScore() + 1);
						System.out.printf("%s wins!\n", player1.getName());
						win = true;
						break;
					}
				}
				
				//Player 2 moves on odd turns
				else {
					b1.printBoard();
					System.out.printf("%s, enter your move: ", player2.name);
					b1.placeGamePiece(player2.gamePiece, userIn.nextInt());
					if(b1.isWin()) {
						player2.setScore(player2.getScore() + 1);
						System.out.printf("%s wins!\n", player2.getName());
						win = true;
						break;
					}
				}
			}
			
			if(!win)
				System.out.println("Looks like this one was a tie!");
			
			//Display players' scores
			System.out.printf("Score is %s:%d | %s:%d\n", player1.getName(),
					player1.getScore(), player2.getName(), player2.getScore());
			
			//Menu to quit, play again, start new game
			System.out.print("Press 1 to play another match.\n" +
							   "Press 2 to start a new game.\n" +
							   "Press 3 to quit playing.\n" +
							   "Enter your answer: ");
			
			answer = userIn.nextInt();
			userIn.nextLine();
			switch(answer) {
			case 1:	break;
			case 2: newGame = true;
					break;
			case 3:	stillPlaying = false;
					break;
			}
		} while(stillPlaying);
		
		userIn.close();
	}
}
