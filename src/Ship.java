/*
 * Ship objects.
 * Can be 2-5 tiles in size.
 * Ships start at a single x/y origin and go either down or right.
 */
public class Ship {
	public final static int RIGHT = 1;
	public final static int DOWN = 2;
	
	private final int xOrigin;
	private final int yOrigin;
	private final int size;

	public Ship(int xOrigin, int yOrigin, int size) {
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.size = size;
	}
	
	public int getX() {
		return xOrigin;
	}
	
	public int getY() {
		return yOrigin;
	}
	
	public int getSize() {
		return size;
	}
}
