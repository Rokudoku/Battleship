package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTestSetGet {

	Board test = new Board();
	
	// board by itself
	@Test
	public void testBoard1() {
		assertEquals(Board.EMPTY, test.getBoardTile(0, 0));
		test.setBoardTile(0, 0, Board.PATROL_BOAT);
		assertEquals(Board.PATROL_BOAT, test.getBoardTile(0, 0));
	}
	@Test
	public void testBoard2() {
		assertEquals(Board.EMPTY, test.getBoardTile(9, 0));
		test.setBoardTile(9, 0, Board.SUBMARINE);
		assertEquals(Board.SUBMARINE, test.getBoardTile(9, 0));
	}
	@Test
	public void testBoard3() {
		assertEquals(Board.EMPTY, test.getBoardTile(0, 9));
		test.setBoardTile(0, 9, Board.DESTROYER);
		assertEquals(Board.DESTROYER, test.getBoardTile(0, 9));
	}
	@Test
	public void testBoard4() {
		assertEquals(Board.EMPTY, test.getBoardTile(9, 9));
		test.setBoardTile(9, 9, Board.BATTLESHIP);
		assertEquals(Board.BATTLESHIP, test.getBoardTile(9, 9));
	}
	@Test
	public void testBoard5() {
		assertEquals(Board.EMPTY, test.getBoardTile(5, 5));
		test.setBoardTile(5, 5, Board.CARRIER);
		assertEquals(Board.CARRIER, test.getBoardTile(5, 5));
		test.setBoardTile(5, 5, Board.EMPTY);	// back to EMPTY
		assertEquals(Board.EMPTY, test.getBoardTile(5, 5));
	}
	
	// radar by itself
	@Test
	public void testRadar1() {
		assertEquals(Board.UNKNOWN, test.getRadarTile(0, 0));
		test.setRadarTile(0, 0, Board.HIT_PATROL_BOAT);
		assertEquals(Board.HIT_PATROL_BOAT, test.getRadarTile(0, 0));
	}
	@Test
	public void testRadar2() {
		assertEquals(Board.UNKNOWN, test.getRadarTile(9, 0));
		test.setRadarTile(9, 0, Board.HIT_SUBMARINE);
		assertEquals(Board.HIT_SUBMARINE, test.getRadarTile(9, 0));
	}
	@Test
	public void testRadar3() {
		assertEquals(Board.UNKNOWN, test.getRadarTile(0, 9));
		test.setRadarTile(0, 9, Board.HIT_DESTROYER);
		assertEquals(Board.HIT_DESTROYER, test.getRadarTile(0, 9));
	}
	@Test
	public void testRadar4() {
		assertEquals(Board.UNKNOWN, test.getRadarTile(9, 9));
		test.setRadarTile(9, 9, Board.HIT_BATTLESHIP);
		assertEquals(Board.HIT_BATTLESHIP, test.getRadarTile(9, 9));
	}
	@Test
	public void testRadar5() {
		assertEquals(Board.UNKNOWN, test.getRadarTile(5, 5));
		test.setRadarTile(5, 5, Board.HIT_CARRIER);
		assertEquals(Board.HIT_CARRIER, test.getRadarTile(5, 5));
		test.setRadarTile(5, 5, Board.MISS);		// changed to MISS
		assertEquals(Board.MISS, test.getRadarTile(5, 5));
	}

}
