package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

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
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		this.getDamage(damage);
//		if(this.live <= 0) {
//			this.onDelete();
//		}
		return true;
	} 
	
	
}
