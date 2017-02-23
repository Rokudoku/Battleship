package battleship;
/*
 * Contains the main() method that creates the game.
 */
public class RunGame {
	public static void main(String args[]) {
		Game g = new Game();
		while (g.getEnemyHitPoints() > 0) {
			System.out.println("===========================================");
			System.out.println("                Turn " + g.getTurns());
			System.out.println("===========================================");
			g.doPlayerTurn();
			System.out.println("Enemy HP: " + g.getEnemyHitPoints());
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("====== YOU WIN!!! ======");
		System.out.println("Turns: " + g.getTurns());
	}
}
