package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class Ovni extends EnemyShip{
	
	private static final int POINTS = 25;
	private static final int LIFE = 1;
	
	public Ovni(Game game) { // 0 y 8 parámetro
		super(game, 0, 8, LIFE, POINTS);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "O[" + this.getLive() + "]";
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
