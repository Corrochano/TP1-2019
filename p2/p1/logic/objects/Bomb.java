package tp.p2.p1.logic.objects;

public class Bomb {
	private int x;
	private int y;
	
	public Bomb(int xIn, int yIn) {
		this.setX(xIn);
		this.setY(yIn);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return ".";
	}
}
