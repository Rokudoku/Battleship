/*
 * The game board.
 * A superclass for BoardEnemy and BoardPlayer.
 * 
 * General appearance of the board: 
 *   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|   
 *   -----------------------------------------
 * A | - | - | - | - | - | - | X | - | - | - |
 * B | X | X | X | X | - | - | X | - | - | - |
 * C | - | - | - | - | - | - | X | - | X | X |
 * ...
 * OR
 *   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|   
 *   -----------------------------------------
 * A | -   -   -   -   -   -   X   -   -   -  
 * B | X   X   X   X   -   -   X   -   -   -  
 * C | -   -   -   -   -   -   X   -   X   X  
 * ...
 */
import java.util.Arrays;

public class Board {
	public final static int BOARD_HEIGHT = 10;
	public final static int BOARD_WIDTH = 10;
	
	public final static boolean EMPTY = false;
	public final static boolean SHIP  = true;
	
	// protected so they can be a part of the subclasses
	protected boolean[][] board = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
	// names of ships are based on their size (positions chosen in subclasses)
	protected Ship shipFive;
	protected Ship shipFour;
	protected Ship shipThreeOne;
	protected Ship shipThreeTwo;
	protected Ship shipTwo;
	
	public Board() {
		// initialize entire board with EMPTY
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			Arrays.fill(board[row], EMPTY);
		}
	}
	
	public String getRowLetter(int rowNumber) {
		// used for printing out side of the board
		String rowLetters[] = { "A", "B", "C", "D", "E",
								"F", "G", "H", "I", "J" };
		return rowLetters[rowNumber];
	}
	
	public boolean isValidTile(int row, int column) {
		return row >= 0 && row < BOARD_HEIGHT 
				&& column >= 0 && column < BOARD_WIDTH;
	}
}
