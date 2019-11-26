package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class UCMShip extends Ship {
	//private int points;
	private boolean hasShockWave;
	private boolean canShootLaser;
	
	public UCMShip(Game game, int x, int y) {
		super(game, x, y, 3);
		this.setCanShootLaser(true);
		//setPoints(0);
	}

	
//	public void setPoints(int in) {
//		this.points = in;
//	}
	
//	public int getPoints() {
//		return this.points;
//	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		if(this.getLive() > 0) {
			return "^__^";
		}
		else {
			return "!xx!";
		}
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	public String stateToString() {
		// TODO Auto-generated method stub
		String ret;
		 ret = "Life: " + this.live + "\n" 
				+ "Points: " + this.game.getPoints() + "\n"
				+ "Shock Wave: ";
		 if(hasShockWave) {
			 ret += "YES\n";
		 }
		 else {
			 ret += "NO\n";
		 }
		 return ret;
	}


	public boolean getCanShootLaser() {
		return canShootLaser;
	}


	public void setCanShootLaser(boolean canShootLaser) {
		this.canShootLaser = canShootLaser;
	}

	public boolean getHasShockWave() {
		return hasShockWave;
	}


	public void setHasShockWave(boolean hasShockWave) {
		this.hasShockWave = hasShockWave;
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	
	public boolean shootLaser(UCMShipLaser laser) {
		// TODO Auto-generated method stub
		if(this.getCanShootLaser()) {
			laser.setX(this.getX());
			laser.setY(this.getY());
			this.game.disableMissile();
			return true;
		}
		else {
			return false;
		}
	}

	public boolean shockWave() {
		// TODO Auto-generated method stub
		if(this.getHasShockWave()) {
			this.game.setShockwaveEnable(false);
			this.setHasShockWave(false);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean move(int numCells) {
		// TODO Auto-generated method stub
		if(this.game.isOnBoard(this.getX(), this.getY() + numCells)) {
			this.setY(this.getY() + numCells);
			return true;
		}
		else {
			return false;
		}
	}
	
}
