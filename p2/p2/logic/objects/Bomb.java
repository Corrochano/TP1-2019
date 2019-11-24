package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class Bomb extends Weapon {
	private DestroyerShip destroyer;
	private boolean enable;
	
	public Bomb(Game game, int x, int y, DestroyerShip destroy) { // Esto no tiene vida
		super(game, x, y, 1);
		setDestroyer(destroy);
		setEnable(false);
		this.move = Move.DOWN;
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
		if(this.isEnable()) { // Echar un ojo
			this.x = this.destroyer.getX() + 1;
			this.y = this.destroyer.getY();
			this.setEnable(false);
		}
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		this.x = -1;
		this.y = -1;
		this.destroyer.setCanShootBomb(true);
		this.setEnable(true);
	}

	public DestroyerShip getDestroyer() {
		return destroyer;
	}

	public void setDestroyer(DestroyerShip destroyer) {
		this.destroyer = destroyer;
	}

	protected boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	@Override
	public boolean receiveMissileAttack(int damage) {
		this.onDelete();
		return true;
	} 
	
	@Override
	public boolean performAttack(GameObject other) {	
		if(super.performAttack(other) && ((other instanceof UCMShipLaser) || (other instanceof UCMShip))) {
			this.onDelete();
			return other.receiveBombAttack(1);
		}
		else {
			return false;
		}
	}
	
}