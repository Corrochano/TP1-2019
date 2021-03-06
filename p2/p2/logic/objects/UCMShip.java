package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class UCMShip extends Ship {
	//private int points;
	
	private static int SUPER_MISSILE_PRICE = 20;
	
	private boolean hasShockWave;
	private boolean canShootLaser;
	private int superMissile;
	
	public UCMShip(Game game, int x, int y) {
		super(game, x, y, 3);
		this.setCanShootLaser(true);
		this.setSuperMissile(0);
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
				+ "Super Missiles: "
				+ this.getSuperMissile() + "\n"
				+ "Possible Super Missiles: "
				+ this.game.getPoints()/20 + "\n"
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
		if(this.getHasShockWave()) {
			this.game.setShockwaveEnable(false);
			this.setHasShockWave(false);
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("resource")
	public boolean move(int numCells) {
		if(this.game.isOnBoard(this.getX(), this.getY() + numCells) && ((numCells == 1) || (numCells == -1)
				|| (numCells == 2) || (numCells == -2))) {
			this.setY(this.getY() + numCells);
			return true;
		}
		else {
			System.out.println("You can't move so far away.");
			System.out.println("Press Enter To Continue...");
			new java.util.Scanner(System.in).nextLine();
			return false;
		}
	}


	public int getSuperMissile() {
		return superMissile;
	}


	public void setSuperMissile(int superMissile) {
		this.superMissile = superMissile;
	}
	
	public void addSuperMissile() {
		if(this.game.getPoints() >= SUPER_MISSILE_PRICE) {
			this.superMissile += 1;
			this.game.setPoints(this.game.getPoints() - SUPER_MISSILE_PRICE);
		}
		else {
			System.out.println("You don't have enough points.");
			System.out.println("Press Enter To Continue...");
			new java.util.Scanner(System.in).nextLine();
		}
	}


	@SuppressWarnings("resource")
	public boolean shootSuperLaser(UCMShipLaser laser) {
		if(this.superMissile > 0) {
			if(this.getCanShootLaser()) {
				laser.enableSuperLaser();
				laser.setX(this.getX());
				laser.setY(this.getY());
				this.superMissile--;
				this.game.disableMissile();
				return true;
			}
			else {
				System.out.println("You have already shooted");
				System.out.println("Press Enter To Continue...");
		        new java.util.Scanner(System.in).nextLine();
				return false;
			}
		}
		else {
			System.out.println("You don't have SuperMissiles.");
			System.out.println("Press Enter To Continue...");
	        new java.util.Scanner(System.in).nextLine();
			return false;
		}
		
	}
	
}
