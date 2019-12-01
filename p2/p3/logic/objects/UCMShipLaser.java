package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

public class UCMShipLaser extends Weapon {
	//private UCMShip ucmShip;
	private int damage;
	private boolean isSuperLaser;
	
	public UCMShipLaser(Game game, int x, int y) {
		super(game, x, y, 1);
		this.move = Move.UP;
		this.damage = 1;
		this.setSuperLaser(false);
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
		
		if(this.isSuperLaser()) {
			this.damage = 1;
			this.setSuperLaser(false);
		}
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
			boolean ret = other.receiveMissileAttack(this.damage);
			this.onDelete();
			return ret;
		}
		else {
			return false;
		}
	}
	
	@Override
	protected boolean isEnable() {
		return this.game.getMissileEnable();
	}

	public boolean isSuperLaser() {
		return isSuperLaser;
	}

	public void setSuperLaser(boolean isSuperLaser) {
		this.isSuperLaser = isSuperLaser;
	}

	public void enableSuperLaser() {
		this.setSuperLaser(true);
		this.damage = 2;
	}
	
	@Override
	public String stringify() {
		String ret;
		if(!isEnable()) {
			if(this.isSuperLaser()) {
				ret = "X: ";
			}
			else {
				ret = "M: ";
			}
			ret += Integer.valueOf(this.x)
					+", "
					+ Integer.valueOf(this.y)
					+ "\n";
			return ret;
		}
		else {
			return null;
		}
	}
	
}
