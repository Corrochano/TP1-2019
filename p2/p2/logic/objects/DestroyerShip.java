package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class DestroyerShip extends AlienShip{
	
	private static final int POINTS = 10;
	private static final int LIFE = 1;
	
	private boolean canShootBomb;
	
	public DestroyerShip(Game game, int x, int y) {
		super(game, x, y, LIFE, POINTS);
		this.canShootBomb = true;
		
	}
	
	public String toString() {
		return "D[" + this.getLive() + "]";
	}
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && this.isCanShootBomb()) {
			this.canShootBomb = false;
		}
	}

	public boolean isCanShootBomb() {
		return canShootBomb;
	}

	public void setCanShootBomb(boolean in) {
		this.canShootBomb = in;
	}
	
}
