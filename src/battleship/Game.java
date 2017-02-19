package battleship;
/*
 * The class that manages the flow of the game.
 * Creates objects using other classes and receives/uses player input.
 */
public class Game {
	
	// input error message
	public final static String INPUT_ERROR_MESSAGE = "Coordinate must "
			+ "contain: A-J followed by 1-10 (e.g. E3)";
	
	public Game() {
		Board boardComputer = new Board();
		boardComputer.printBoard();
		boardComputer.setRandomShips();
		boardComputer.printBoard();
		boardComputer.printRadar();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		System.out.println(isValidInput("E4"));
		System.out.println(isValidInput("B10"));
		System.out.println(isValidInput("B11"));
		System.out.println(isValidInput("MM"));
		System.out.println(isValidInput("M8"));
		System.out.println(isValidInput("4E"));
		System.out.println(isValidInput("88"));
		System.out.println(isValidInput("J1"));
	}
	
	private static boolean isValidInput(String input) {
		return input.matches("^[A-Ja-j][1-9]$") || input.matches("[A-Ja-j]10");
	}
}
