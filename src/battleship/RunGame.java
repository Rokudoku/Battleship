package battleship;
/*
 * Contains the main() method that creates the game.
 */
public class RunGame {
	public static void main(String args[]) {
		Game g = new Game();
		g.printRadars();
		String result = g.getPlayerInput();
		System.out.println(result);
	}
}
