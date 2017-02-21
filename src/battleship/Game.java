package battleship;
/*
 * The class that sets up a new game.
 * The computer's board is always created and assigned random ship positions.
 * 
 * The class that manages the flow of the game.
 * Creates objects using other classes and receives/uses player input.
 */
import java.util.Scanner;

public class Game {
	// object for getting user input
	static Scanner scan = new Scanner(System.in);
	
	// input error message
	public final static String INPUT_ERROR_MESSAGE = "Coordinate must "
			+ "contain: A-J followed by 1-10 (e.g. E3)";
	
	private final Board boardComputer = new Board();
	
	public Game() {		
		boardComputer.setRandomShips();	// computer ships always random
		boardComputer.printBoard(); // FOR DEBUGGING PURPOSES!!!
	}
	
	public void printRadars() {
		boardComputer.printRadar();
	}
	
	private static String getInput() {
		System.out.println("Enter coordinate to fire at:");
		String userInput = scan.next();
		
		while (!isValidInput(userInput)) {
			System.out.println(INPUT_ERROR_MESSAGE);
			userInput = scan.next();
		}
		return userInput;
	}
	
	private static boolean isValidInput(String input) {
		return input.matches("^[A-Ja-j][1-9]$") || input.matches("[A-Ja-j]10");
	}
}
