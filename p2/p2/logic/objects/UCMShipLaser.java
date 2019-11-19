package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class UCMShipLaser extends Weapon {
	private int x;
	private int y;
	private UCMShip ucmShip;
	
	public UCMShipLaser(Game game, int x, int y) {
		super(game, x, y, 0);
		setUcmShip(null); // ¿?
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
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	public UCMShip getUcmShip() {
		return ucmShip;
	}

	public void setUcmShip(UCMShip ucmShip) {
		this.ucmShip = ucmShip;
	}

}
