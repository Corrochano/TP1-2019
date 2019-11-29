package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;

public class Ovni extends EnemyShip{
	
	private static final int POINTS = 25;
	private static final int LIFE = 1;
	private static final int INIT_X = 0;
	private static final int INIT_Y = 8;
	private boolean enable;
	
	public Ovni(Game game) { // 0 y 8 parámetro
		super(game, -2, -2, LIFE, POINTS);
		this.setEnable(false);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "O[" + this.getLive() + "]";
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		if(IExecuteRandomActions.canGenerateRandomOvni(game) && !this.isEnable()) {
			this.setEnable(true);
			this.x = INIT_X;
			this.y = INIT_Y + 1;
		}
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		super.onDelete();
		this.setEnable(false);
		this.live = LIFE;
		this.x = -2;
		this.y = -2;
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(this.isEnable()) {
			this.y -= 1;
			if(this.y < 0) {
				this.setEnable(false);
				this.x = -2;
				this.y = -2;
			}
		}
		
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
}
