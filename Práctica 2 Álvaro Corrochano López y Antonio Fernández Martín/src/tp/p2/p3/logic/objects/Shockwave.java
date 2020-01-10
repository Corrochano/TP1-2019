package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

public class Shockwave extends Weapon {

	private boolean enable;
	
	public Shockwave(Game game) {
		super(game, -15, -12, 1);
		this.setEnable(true);
	}

	@Override
	public void computerAction() {
		
	}

	@Override
	public void onDelete() {
		this.setEnable(true);
	}

	@Override
	public void move() {
		
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
	
	@Override
	public String stringify() {
		return null;
	}
	
}
