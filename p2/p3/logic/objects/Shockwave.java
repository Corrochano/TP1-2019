package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

public class Shockwave extends Weapon {

	private boolean enable;
	
	public Shockwave(Game game) {
		super(game, -1, -1, 1);
		this.setEnable(true);
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		this.setEnable(true);
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
	public boolean performAttack(GameObject other) {
		if(!this.isEnable()) {
			return other.receiveShockWaveAttack(1);
		}
		else {
			return false;
		}
	}

	/**
	 * @return the enableS
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
