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
		System.out.println("===========================================");
		boardEnemy.printBoard(); // FOR DEBUGGING PURPOSES!!!
		System.out.println("===========================================");
		boardEnemy.printRadar();
		boardEnemy.printHealth();
		System.out.println("===========================================");
	}
	
	public void doPlayerTurn() {
		// get the user input string (e.g. E3)
		System.out.println("Enter coordinate to fire at:");
		String userInput = getPlayerInput();
		
		// userInput[0] will always be the letter
		int row = convertLetterToRow(userInput.charAt(0));

		// "10" needs to be accounted for, so ending substring will be converted
		int column = convertNumberToColumn(userInput.substring(1));
		
		// change the state of the ENEMY radar (linked to enemy board)
		// this would be equal to the state of the board as I made the constants line up
		// e.g. EMPTY(board) == MISS(radar), BATTLESHIP(board) = HIT_BATTLESHIP(radar)
		int state = boardEnemy.getBoardTile(row, column);
		boardEnemy.setRadarTile(row, column, state);
		
		// announce the hit/miss
		makeAnnouncement(state);
		
		// show the radar/health
		System.out.println("===========================================");
		boardEnemy.printRadar();
		boardEnemy.printHealth();
	}
	
	private String getPlayerInput() {
		String userInput = scan.next();
		
		// keep asking until input is valid
		while (!isValidInput(userInput)) {
			System.out.println(INPUT_ERROR_MESSAGE);
			userInput = scan.next();
		}
		
		userInput = userInput.substring(0, 1).toUpperCase() 
				+ userInput.substring(1);	// capitalize first letter
		
		shotTilesPlayer.add(userInput);		// add to the shotTiles list
		return userInput;
	}
	
	private static boolean isValidInput(String input) {
		return input.matches("^[A-Ja-j][1-9]$") || input.matches("[A-Ja-j]10");
	}
	
	private static int convertLetterToRow(char letter) {
		switch (letter) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		case 'D':
			return 3;
		case 'E':
			return 4;
		case 'F':
			return 5;
		case 'G':
			return 6;
		case 'H':
			return 7;
		case 'I':
			return 8;
		case 'J':
			return 9;
		default:
			System.out.println("Error: could not convert letter to row.");
			return -1;
		}
	}
		
	private static int convertNumberToColumn(String letter) {
		switch (letter) {
		case "1":
			return 0;
		case "2":
			return 1;
		case "3":
			return 2;
		case "4":
			return 3;
		case "5":
			return 4;
		case "6":
			return 5;
		case "7":
			return 6;
		case "8":
			return 7;
		case "9":
			return 8;
		case "10":
			return 9;
		default:
			System.out.println("Error: could not convert number to column.");
			return -1;
		}
	}
	
	private void makeAnnouncement(int state) {
		switch (state) {
		case Board.MISS:
			System.out.println("Miss.");
			break;
		case Board.HIT_PATROL_BOAT:
			System.out.println("Hit. Patrol boat(2).");
			break;
		case Board.HIT_SUBMARINE:
			System.out.println("Hit. Submarine(3).");
			break;
		case Board.HIT_DESTROYER:
			System.out.println("Hit. Destroyer(3).");
			break;
		case Board.HIT_BATTLESHIP:
			System.out.println("Hit. Battleship(4).");
			break;
		case Board.HIT_CARRIER:
			System.out.println("Hit. Carrier(5).");
			break;
		default:
			System.out.println("Error: Unknown tile shot");
			break;
		}
	}
}
