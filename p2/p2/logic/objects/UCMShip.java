package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class UCMShip extends Ship {
	private int points;
	private boolean hasShockWave;
	private boolean canShootLaser;
	
	public UCMShip(Game game, int x, int y) {
		super(game, x, y, 3);
		setPoints(0);
	}

	
	public void setPoints(int in) {
		this.points = in;
	}
	
	public int getPoints() {
		return this.points;
	}
	
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
				+ "Points: " + this.points + "\n"
				+ "Shock Wave: ";
		 if(hasShockWave) {
			 ret += "YES\n";
		 }
		 else {
			 ret += "NO\n";
		 }
		 return ret;
	}
	
}
