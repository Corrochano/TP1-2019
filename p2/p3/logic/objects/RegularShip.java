package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

public class RegularShip extends AlienShip{
	
	private static final int POINTS = 5;
	private static final int LIFE = 2;
	
	public RegularShip(Game game, int x, int y) {
		super(game, x, y, LIFE, POINTS);
	}
	
	public String toString() {
		return "C[" + this.getLive() + "]";
	}
	
	@Override
	public void computerAction() { // ¿?
		// TODO Auto-generated method stub
		if(IExecuteRandomActions.canGenerateExplosiveShip(this.game)) {
			this.game.addObject(new ExplosiveShip(this.game, this.getX(), this.getY(), this.getLive(), 
					POINTS, SHIPS_ON_BORDER, this.move, this.cyclesToMove));
			REMAINING_ALIENS--;
			this.game.removeObject(this);
			this.game.reorderLaser();
		}
		
	}
	
}
