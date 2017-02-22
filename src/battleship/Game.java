package battleship;
/*
 * The class that sets up a new game.
 * The computer's board is always created and assigned random ship positions.
 * 
 * The class that manages the flow of the game.
 * Creates objects using other classes and receives/uses player input.
 */
import java.util.Scanner;
import java.util.LinkedList;

public class Game {
	// object for getting user input
	static Scanner scan = new Scanner(System.in);
	
	// input error message
	private final static String INPUT_ERROR_MESSAGE = "Coordinate must "
			+ "contain: A-J followed by 1-10 (e.g. E3)";
	
	// the tiles the player/enemy have already shot at
	// contains the tile coordinates in the for of <A-J><1-10> (e.g. E3)
	private LinkedList<String> shotTilesEnemy = new LinkedList<String>();
	private LinkedList<String> shotTilesPlayer = new LinkedList<String>();
	
	private final Board boardEnemy = new Board();
	
	public Game() {		
		boardEnemy.setRandomShips();	// computer ships always random
		boardEnemy.printBoard(); // FOR DEBUGGING PURPOSES!!!
	}
	
	public void printRadars() {
		boardEnemy.printRadar();
	}
	
	public String getPlayerInput() {
		System.out.println("Enter coordinate to fire at:");
		String userInput = scan.next();
		
		while (!isValidInput(userInput)) {
			System.out.println(INPUT_ERROR_MESSAGE);
			userInput = scan.next();
		}
		
		userInput = userInput.substring(0, 1).toUpperCase() 
				+ userInput.substring(1);	// capitalize first letter
		
		shotTilesPlayer.add(userInput);
		return userInput;
	}
	
	private static boolean isValidInput(String input) {
		return input.matches("^[A-Ja-j][1-9]$") || input.matches("[A-Ja-j]10");
	}
}
