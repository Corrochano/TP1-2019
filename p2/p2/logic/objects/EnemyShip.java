package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public abstract class EnemyShip extends Ship{
	protected int points;
	protected Move move;
	
	public EnemyShip(Game game, int x, int y, int live, int pointsIn) {
		super(game, x, y, live);
		 this.points = pointsIn;
		 this.move = Move.LEFT;
		// TODO Auto-generated constructor stub
	}
	
	public void onDelete() {
		this.game.receivePoints(this.points);
	}
	
	
	
	
}
