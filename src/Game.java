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
	}
}
