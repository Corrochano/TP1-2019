package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;
import tp.p2.p2.logic.lists.BombList;

public class DestroyerShip extends AlienShip{
	
	private static final int POINTS = 10;
	private static final int LIFE = 1;
	
	private boolean canShootBomb;
	
	public DestroyerShip(Game game, int x, int y) {
		super(game, x, y, LIFE, POINTS);
		setCanShootBomb(true);
	}


	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

//	public Bomb getBomb() {
//		return bomb;
//	}
//
//	public void setBomb(Bomb bomb) {
//		this.bomb = bomb;
//	}
	
	public String toString() {
		return "D[" + this.getLive() + "]";
	}
	
//	public void createBomb(BombList bombListIn) {
//		this.bomb = new Bomb(this.x, this.y);
//		bombListIn.addBomb(this.bomb);
//	}
//	
//	public int getBombX() {
//		return this.bomb.getX();
//	}
//	
//	public int getBombY() {
//		return this.bomb.getY();
//	}
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}


	public boolean isCanShootBomb() {
		return canShootBomb;
	}


	public void setCanShootBomb(boolean canShootBomb) {
		this.canShootBomb = canShootBomb;
	}
	
}
