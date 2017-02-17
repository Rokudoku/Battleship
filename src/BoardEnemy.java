/*
 * The Board created by the computer.
 * Randomly generates ship positions.
 */
public class BoardEnemy extends Board{
	
	public BoardEnemy() {
		super();
		setRandomPlacement(CARRIER);
	}
	
	private void setCarrier() {
		int size = 5;
		int direction = (int) (Math.random() * NUM_DIRECTIONS);
		int row = setRandomRow(direction, size);
		int column = setRandomColumn(direction, size);
		if (direction == RIGHT) {
			for (int i = 0; i < size; i++) {
				board[row][column+i] = CARRIER;
			}
		} else {
			for (int i = 0; i < size; i++) {
				board[row+i][column] = CARRIER;
			}
		}
	}
	
	private void setRandomPlacement(int ship) {
		int size = getShipSize(ship);
		int direction = (int) (Math.random() * NUM_DIRECTIONS);
		int row = setRandomRow(direction, size);
		int column = setRandomColumn(direction, size);
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
				if (board[row][column] == EMPTY) {
					System.out.print(" -  ");
				} else {
					System.out.print(" X  ");
				}
			}
			System.out.println("");
		}
	}
	
	public void testHP() {
		System.out.println("HP: " + getHitPoints(DESTROYER));
	}
}
