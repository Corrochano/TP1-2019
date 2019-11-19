package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class Bomb extends Weapon {
//	private int x;
//	private int y;
	private DestroyerShip destroyer;
	
	public Bomb(Game game, int x, int y) { // Esto no tiene vida
		super(game, x, y, 0);
		setDestroyer(null);
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

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	public DestroyerShip getDestroyer() {
		return destroyer;
	}

	public void setDestroyer(DestroyerShip destroyer) {
		this.destroyer = destroyer;
	}
}
