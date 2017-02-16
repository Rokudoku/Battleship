/*
 * The Board created by the computer.
 * Randomly generates ship positions.
 */
public class BoardEnemy extends Board{

	public BoardEnemy() {
		super();
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
					System.out.print("| X ");
				}
			}
			System.out.println("");
		}
	}
}
