package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class ExplosiveShip extends AlienShip {

	public ExplosiveShip(Game game, int x, int y, int live, int pointsIn, int shipsOnBorder, Move move, int cyclesToMove) {
		super(game, x, y, live, pointsIn);
		SHIPS_ON_BORDER = shipsOnBorder;
		this.move = move;
		this.cyclesToMove = cyclesToMove;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "E[" + this.getLive() + "]";
	}
	
	@Override
	public void onDelete(){
		super.onDelete();
		this.game.removeObject(this);
		this.game.doExplosion(this.x, this.y);
	}

}
