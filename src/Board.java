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
	public final static int BOARD_WIDTH  = 10;

	// tile states
	public final static int EMPTY       = 0;
	public final static int PATROL_BOAT = 1;	// 2 tiles
	public final static int SUBMARINE   = 2;	// 3 tiles
	public final static int DESTROYER   = 3;	// 3 tiles
	public final static int BATTLESHIP  = 4;	// 4 tiles
	public final static int CARRIER     = 5;	// 2 tiles
	
	// protected so they can be a part of the subclasses
	protected int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];	
	
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
		// return false if it is already full
		if (board[row][column] != EMPTY) {
			return false;
		}
		// otherwise return true if it is within the bounds
		return row >= 0 && row < BOARD_HEIGHT 
				&& column >= 0 && column < BOARD_WIDTH;
	}
}
