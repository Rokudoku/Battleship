/*
 * The class that manages the flow of the game.
 * Creates objects using other classes and receives/uses player input.
 */
public class Game {
	public static void main(String[] args) {
		BoardEnemy boardComputer = new BoardEnemy();
		boardComputer.printBoard();
		boardComputer.testHP();
		boardComputer.reduceHitPoints(Board.DESTROYER);
		boardComputer.printRadar();
		boardComputer.testHP();
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
