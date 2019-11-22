package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class Bomb extends Weapon {
	private DestroyerShip destroyer;
	private boolean enable;
	
	public Bomb(Game game, int x, int y, DestroyerShip destroy) { // Esto no tiene vida
		super(game, x, y, 0);
		setDestroyer(destroy);
		setEnable(false);
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
		if(isEnable()) {
			return ".";
		}
		else {
			return " ";
		}
		
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		//this.destroyer.computerAction();
		if(!this.isEnable()) {
			this.x = this.destroyer.getX() + 1;
			this.y = this.destroyer.getY();
			this.setEnable(true);
		}
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		this.destroyer.setCanShootBomb(true);
		this.setEnable(true);
	}

	public DestroyerShip getDestroyer() {
		return destroyer;
	}

	public void setDestroyer(DestroyerShip destroyer) {
		this.destroyer = destroyer;
	}

	boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
