package battleship;
/*
 * The game board. Deals with the state of the tiles on the board and the 
 * states of the ships.
 * 
 * Boards also contain a radar which shows the HIT/MISS state of the board.
 * The player uses the radar of the enemy board and vice-versa.
 */
import java.util.Arrays;

public class Board {
	
	public final static int BOARD_HEIGHT = 10;
	public final static int BOARD_WIDTH  = 10;

	// tile states for board
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
	
	// having only these directions help simplify finding a valid placement
	// pretty much same as vertical/horizontal but more specific with origin
	public final static int RIGHT = 0;
	public final static int DOWN  = 1;
	public final static int NUM_DIRECTIONS = 2;
	
	// the board and radar are represented as multidimensional arrays
	private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
	private int[][] radar = new int[BOARD_HEIGHT][BOARD_WIDTH];
	
	private int patrolBoatHP = 2;
	private int submarineHP  = 3;
	private int destroyerHP  = 3;
	private int battleshipHP = 4;
	private int carrierHP    = 5;
	
	public Board() {
		// Board objects are initialized with an empty board and a clear radar
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			Arrays.fill(board[row], EMPTY);
			Arrays.fill(radar[row], UNKNOWN);
		}
	}	
	
	// returns the tile state of the board tile
	public int getBoardTile(int row, int column) {
		return board[row][column];
	}	
	
	// returns the tile state of the radar tile
	public int getRadarTile(int row, int column) {
		return radar[row][column];
	}
	
	// sets the tile state of the board tile
	public void setBoardTile(int row, int column, int state) {
		board[row][column] = state;
	}
	
	// sets the tile state of the radar tile
	public void setRadarTile(int row, int column, int state) {
		radar[row][column] = state;
	}
	
	private boolean isValidBoardTile(int row, int column) {
		// return false if it is already full
		if (board[row][column] != EMPTY) {
			return false;
		}
		// otherwise return true if it is within the bounds
		return row >= 0 && row < BOARD_HEIGHT 
				&& column >= 0 && column < BOARD_WIDTH;
	}
	
	// check if ship can be placed across the span of tiles
	private boolean isValidShipPlacement(int rowStart, int columnStart,
									int direction, int size) {
		if (direction == RIGHT) {
			for (int i = 0; i < size; i++) {
				if (!isValidBoardTile(rowStart, columnStart+i)) {
					return false;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (!isValidBoardTile(rowStart+i, columnStart)) {
					return false;
				}
			}
		}
		return true;
	}
	
	// randomly assign the ships to valid positions on the board
	public void setRandomShips() {
		// decrementing size order so that if collisions occur we check less spaces
		for (int ship = CARRIER; ship >= PATROL_BOAT; ship--) {
			setRandomPlacement(ship);
		}
	}
	
	private void setRandomPlacement(int ship) {
		int size = getShipSize(ship);
		int direction = (int) (Math.random() * NUM_DIRECTIONS);
		int row;
		int column;
		
		// look for a valid placement
		do {
			row = setRandomRow(direction, size);
			column = setRandomColumn(direction, size);
		} while (!isValidShipPlacement(row, column, direction, size));
		
		// place ships onto board
		if (direction == RIGHT) {
			for (int i = 0; i < size; i++) {
				board[row][column+i] = ship;
			}
		} else {
			for (int i = 0; i < size; i++) {
				board[row+i][column] = ship;
			}
		}
	}
	
	private int setRandomRow(int direction, int size) {
		// eliminates option of selecting a row where ship would go off board
		if (direction == RIGHT) {
			return (int) (Math.random() * BOARD_HEIGHT);
		} else {
			return (int) (Math.random() * (BOARD_WIDTH - size + 1));
		}
	}
	
	private int setRandomColumn(int direction, int size) {
		// eliminates option of selecting a column where ship would go off board
		if (direction == RIGHT) {
			return (int) (Math.random() * (BOARD_HEIGHT - size + 1));
		} else {
			return (int) (Math.random() * BOARD_WIDTH);
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
	
	public void printBoard() {
		System.out.println("  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|");
		System.out.println("  -----------------------------------------");
		
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			System.out.print(this.getRowLetter(row) + " |");
			for (int column = 0; column < BOARD_WIDTH; column++) {
				switch(board[row][column]) {
				case EMPTY:
					System.out.print(" -  ");
					break;
				case PATROL_BOAT:
					System.out.print(" P  ");
					break;
				case SUBMARINE:
					System.out.print(" S  ");
					break;
				case DESTROYER:
					System.out.print(" D  ");
					break;
				case BATTLESHIP:
					System.out.print(" B  ");
					break;
				case CARRIER:
					System.out.print(" C  ");
					break;
				default:
					System.out.print(" ?  ");
					break;
				}
			}
			System.out.println("");
		}
		System.out.println("  -----------------------------------------");
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
		System.out.println("  -----------------------------------------");
	}
	
	// for printing out the left side of the board/radar
	private String getRowLetter(int rowNumber) {
		String rowLetters[] = { "A", "B", "C", "D", "E",
								"F", "G", "H", "I", "J" };
		return rowLetters[rowNumber];
	}
	
	//
	// |-------|-------|-------|-------|-------|
	// | P = 2 | S = 3 | D = 3 | B = 4 | C = 5 |
	// |-------|-------|-------|-------|-------|
	//
	public void printHealth() {
		//System.out.println("  |-------|-------|-------|-------|-------|");
		System.out.println("  | P = " + patrolBoatHP + " | S = " + 
				submarineHP + " | D = " + destroyerHP + " | B = " + 
				battleshipHP + " | C = " + carrierHP + " |");		
		System.out.println("  -----------------------------------------");		
	}
}
