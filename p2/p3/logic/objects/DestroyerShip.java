package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

public class DestroyerShip extends AlienShip{
	
	private static final int POINTS = 10;
	private static final int LIFE = 1;
	private int number;
	
	public DestroyerShip(Game game, int x, int y, int number) {
		super(game, x, y, LIFE, POINTS);
		this.number = number;
	}
	
	public String toString() {
		return "D[" + this.getLive() + "]";
	}
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String stringify() {
		return "D: "
				+ Integer.valueOf(this.x)
				+", "
				+ Integer.valueOf(this.y)
				+"; "
				+ Integer.valueOf(this.live)
				+"; "
				+ Integer.valueOf(this.cyclesToMove)
				+ "; "
				+ this.move.toString()
				+ " - "
				+ Integer.valueOf(this.number)
				+ "\n";
	}

	public int getNumber() {
		return this.number;
	}
	
	
}
