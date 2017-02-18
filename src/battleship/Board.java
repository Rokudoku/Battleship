package battleship;
/*
 * The game board.
 * A superclass for BoardEnemy and BoardPlayer.
 * 
 * Boards also contain a radar which shows the HIT/MISS state of the board.
 * The player's radar is connected to the enemy board and vice-versa.
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
	
	// tile states for radar
	public final static int MISS			= 0;	
	public final static int HIT_PATROL_BOAT = 1;	
	public final static int HIT_SUBMARINE   = 2;
	public final static int HIT_DESTROYER   = 3;
	public final static int HIT_BATTLESHIP  = 4;
	public final static int HIT_CARRIER     = 5;
	public final static int UNKNOWN			= 6;	// no shot fired yet
	
	// having only these directions help simplify finding a random spot
	public final static int RIGHT = 0;
	public final static int DOWN  = 1;
	public final static int NUM_DIRECTIONS = 2;
	
	// input error message
	public final static String INPUT_ERROR_MESSAGE = "Coordinate must "
			+ "contain: A-J followed by 1-10 (e.g. E3)";
	
	// protected so they can be a part of the subclasses
	protected int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
	protected int[][] radar = new int[BOARD_HEIGHT][BOARD_WIDTH];
	
	private int patrolBoatHP = 2;
	private int submarineHP  = 3;
	private int destroyerHP  = 3;
	private int battleshipHP = 4;
	private int carrierHP    = 5;
	
	public Board() {
		// initialize entire board with EMPTY and radar with UNKNOWN
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			Arrays.fill(board[row], EMPTY);
			Arrays.fill(radar[row], UNKNOWN);
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
		} else {
			for (int i = 0; i < size; i++) {
				if (!isValidTile(rowStart+i, columnStart)) {
					return false;
				}
			}
		}
		return true;
	}
	
	// returns the tile state
	// ** NOTE THAT 0-5 OF TILE STATE LINE UP WITH 0-5 OF RADAR STATE **
	// e.g. EMPTY == MISS, CARRIER == HIT_CARRIER
	// exception is 6, UNKNOWN which only exists in the radar
	public int getTile(int row, int column) {
		if (isValidTile(row, column)) {
			return board[row][column];
		} else {
			System.out.println("Attempted to get tile state of invalid tile");
			return 0;
		}
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
			return EMPTY;
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
	
	public void printRadar() {
		System.out.println("  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|");
		System.out.println("  -----------------------------------------");
		
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			System.out.print(this.getRowLetter(row) + " |");
			for (int column = 0; column < BOARD_WIDTH; column++) {
				switch(radar[row][column]) {
				case UNKNOWN:
					System.out.print(" -  ");
					break;
				case HIT_PATROL_BOAT:
					System.out.print(" P  ");
					break;
				case HIT_SUBMARINE:
					System.out.print(" S  ");
					break;
				case HIT_DESTROYER:
					System.out.print(" D  ");
					break;
				case HIT_BATTLESHIP:
					System.out.print(" B  ");
					break;
				case HIT_CARRIER:
					System.out.print(" C  ");
					break;
				case MISS:
					System.out.print(" X  ");
					break;
				default:
					System.out.print(" ?  ");
					break;
				}
			}
			System.out.println("");
		}
	}
}
