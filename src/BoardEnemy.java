/*
 * The Board created by the computer.
 * Randomly generates ship positions.
 */
public class BoardEnemy extends Board{
	
	public BoardEnemy() {
		super();
		setRandomPlacement(CARRIER);
		setRandomPlacement(BATTLESHIP);
		setRandomPlacement(DESTROYER);
		setRandomPlacement(SUBMARINE);
		setRandomPlacement(PATROL_BOAT);
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
		} while (!isValidPlacement(row, column, direction, size));
		
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
	
	private static int setRandomRow(int direction, int size) {
		// eliminates option of selecting a row where ship would go off board
		if (direction == RIGHT) {
			return (int) (Math.random() * BOARD_HEIGHT);
		} else {
			return (int) (Math.random() * (BOARD_WIDTH - size + 1));
		}
	}
	
	private static int setRandomColumn(int direction, int size) {
		// eliminates option of selecting a column where ship would go off board
		if (direction == RIGHT) {
			return (int) (Math.random() * (BOARD_HEIGHT - size + 1));
		} else {
			return (int) (Math.random() * BOARD_WIDTH);
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
	}
	
	public void testHP() {
		System.out.println("HP: " + getHitPoints(DESTROYER));
	}
}
