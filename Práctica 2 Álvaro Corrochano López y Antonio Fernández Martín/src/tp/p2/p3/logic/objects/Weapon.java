package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

public abstract class Weapon extends GameObject {
	protected Move move;
	public Weapon(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	public void performAttack() {
		
	}
	
	public void move() { // Utiliza un atributo move
		if(!this.isEnable()) {
			if(this.move == Move.DOWN) {
				this.x++;
				if(this.x > 7) {
					this.onDelete();
				}
			}
			else if(this.move == Move.UP) {
				this.x--;
				if(this.x < 0) {
					this.onDelete();
				}
			}
		}
	}

	@Override
	public boolean performAttack(GameObject other) { 
		if(this.x == other.getX() && this.y == other.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected abstract boolean isEnable();
}
