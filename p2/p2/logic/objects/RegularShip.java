package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class RegularShip extends AlienShip{
	
	private static final int POINTS = 5;
	private static final int LIFE = 2;
	
	public RegularShip(Game game, int x, int y) {
		super(game, x, y, LIFE, POINTS);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "C[" + this.getLive() + "]";
	}
	
	@Override
	public void computerAction() { // ¿?
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
}
