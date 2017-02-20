package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTestExceptions {

	Board testBoard = new Board();

	// getBoardTile
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetBoardTile1() {
		testBoard.getBoardTile(7, 11);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetBoardTile2() {
		testBoard.getBoardTile(11111, 7);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetBoardTile3() {
		testBoard.getBoardTile(11200, 11);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetBoardTile4() {
		testBoard.getBoardTile(-1, 7);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetBoardTile5() {
		testBoard.getBoardTile(1, -11111111);
	}
	
	// getRadarTile
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetRadarTile1() {
		testBoard.getRadarTile(7, 11);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetRadarTile2() {
		testBoard.getRadarTile(11111, 7);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetRadarTile3() {
		testBoard.getRadarTile(11200, 11);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetRadarTile4() {
		testBoard.getRadarTile(-1, 7);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetRadarTile5() {
		testBoard.getBoardTile(1, -11111111);
	}
	
	// setBoardTile
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetBoardTile1() {
		testBoard.setBoardTile(7, 11, Board.PATROL_BOAT);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetBoardTile2() {
		testBoard.setBoardTile(11111, 7, Board.SUBMARINE);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetBoardTile3() {
		testBoard.setBoardTile(11200, 11, Board.DESTROYER);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetBoardTile4() {
		testBoard.setBoardTile(-1, 7, Board.BATTLESHIP);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetBoardTile5() {
		testBoard.setBoardTile(1, -11111111, Board.CARRIER);
	}
	
	// setRadarTile
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetRadarTile1() {
		testBoard.setRadarTile(7, 11, Board.PATROL_BOAT);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetRadarTile2() {
		testBoard.setRadarTile(11111, 7, Board.SUBMARINE);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetRadarTile3() {
		testBoard.setRadarTile(11200, 11, Board.DESTROYER);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetRadarTile4() {
		testBoard.setRadarTile(-1, 7, Board.BATTLESHIP);
	}	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetRadarTile5() {
		testBoard.setRadarTile(1, -11111111, Board.CARRIER);
	}
}
