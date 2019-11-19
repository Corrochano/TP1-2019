package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public abstract class EnemyShip extends Ship{
	protected int points;
	public EnemyShip(Game game, int x, int y, int live, int pointsIn) {
		super(game, x, y, live);
		 this.points = pointsIn;
		// TODO Auto-generated constructor stub
	}
	
	public int getPoints() {
		return points;
	}
	
	
	
	
}
