package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public class Shockwave extends Weapon {

	private boolean enable;
	
	public Shockwave(Game game, int x, int y) {
		super(game, x, y, 1);
		this.setEnable(true);
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

	@Override
	public String toString() {
		return "";
	}

	@Override
	public void performAttack() {
		
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
