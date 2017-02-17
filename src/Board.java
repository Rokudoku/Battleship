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
	
	// having only these directions help simplify finding a random spot
	public final static int RIGHT = 0;
	public final static int DOWN = 1;
	public final static int NUM_DIRECTIONS = 2;
	
	// protected so they can be a part of the subclasses
	protected int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
	
	private int patrolBoatHP = 2;
	private int submarineHP  = 3;
	private int destroyerHP  = 3;
	private int battleshipHP = 4;
	private int carrierHP    = 5;
	
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
	
	// check if ship can be placed
	public boolean isValidPlacement(int rowStart, int columnStart,
									int direction, int size) {
		if (direction == RIGHT) {
			for (int i = 0; i < size; i++) {
				if (!isValidTile(rowStart, columnStart+i)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int getShipSize(int ship) {
		switch(ship) {
		case PATROL_BOAT:
			return 2;
		case SUBMARINE:
			return 3;
		case DESTROYER:
			return 3;
		case BATTLESHIP:
			return 4;
		case CARRIER:
			return 5;
		default:
			System.out.println("getShipSize received invalid ship");
			return 0;
		}
	}
	
	public int getHitPoints(int ship) {
		switch(ship) {
		case PATROL_BOAT:
			return patrolBoatHP;
		case SUBMARINE:
			return submarineHP;
		case DESTROYER:
			return destroyerHP;
		case BATTLESHIP:
			return battleshipHP;
		case CARRIER:
			return carrierHP;
		default:
			System.out.println("getHitPoints received invalid ship");
			return 0;
		}
	}
	
	public void reduceHitPoints(int ship) {
		switch(ship) {
		case PATROL_BOAT:
			patrolBoatHP -= 1;
			break;
		case SUBMARINE:
			submarineHP -= 1;
			break;
		case DESTROYER:
			destroyerHP -= 1;
			break;
		case BATTLESHIP:
			battleshipHP -= 1;
			break;
		case CARRIER:
			carrierHP -= 1;
			break;
		default:
			System.out.println("reduceHitPoints received invalid ship");
			break;
		}
	}
}
