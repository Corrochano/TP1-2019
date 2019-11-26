package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class UCMShipLaser extends Weapon {
	//private UCMShip ucmShip;
	
	public UCMShipLaser(Game game, int x, int y) {
		super(game, x, y, 1);
		this.move = Move.UP;
	//	setUcmShip(null); // ¿?
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
		return "oo";
	}

	@Override
	public void computerAction() { // ¿?
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		this.x = -7;
		this.y = -7;
		this.game.enableMissile();
	}

//	public UCMShip getUcmShip() {
//		return ucmShip;
//	}
//
//	public void setUcmShip(UCMShip ucmShip) {
//		this.ucmShip = ucmShip;
//	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.onDelete();
		return true;
	}
	
	@Override
	public boolean performAttack(GameObject other) {
		if(super.performAttack(other) && ((other instanceof EnemyShip) || (other instanceof Bomb))){
			this.onDelete();
			return other.receiveMissileAttack(1);
		}
		else {
			return false;
		}
	}
	
	@Override
	protected boolean isEnable() {
		return this.game.getMissileEnable();
	}
}
