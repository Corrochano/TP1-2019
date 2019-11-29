package tp.p2.p3.logic.objects;

import tp.p2.p3.logic.Game;
import tp.p2.p3.logic.Level;

public abstract class AlienShip extends EnemyShip {
	
	protected static int REMAINING_ALIENS = 0;
	private static boolean IS_IN_FINAL_ROW = false;;
	protected static int SHIPS_ON_BORDER;
	protected int cyclesToMove;

	public AlienShip(Game game, int x, int y, int live, int pointsIn) {
		super(game, x, y, live, pointsIn);
		REMAINING_ALIENS += 1;
		SHIPS_ON_BORDER = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() { // if(variable instanceof clase))
		// TODO Auto-generated method stub
		if(cyclesToMove == 0) {
//			Actualizar cyclesToMove
			Level level = this.game.getLevel();
			this.cyclesToMove = level.getNumCyclesToMoveOneCell();
//			Hacer el movimiento a la izquierda o a la derecha
			if(this.move == Move.LEFT) {
				this.y -= 1;
			}
			else if(this.move == Move.RIGHT) {
				this.y += 1;
			}
//			Actualizar IS_IN_FINAL_ROW
			if(this.x == 7)
				IS_IN_FINAL_ROW = true;
			
			if(this.y == 8 || this.y == 0) {
				SHIPS_ON_BORDER = REMAINING_ALIENS;
			}
		}
		
		else if (SHIPS_ON_BORDER > 0 && !IS_IN_FINAL_ROW) {
//			Aumentar la fila
			this.x += 1;
//			Cambiar el sentido del movimiento
			this.move = this.move.flip();
			
			SHIPS_ON_BORDER -= 1;
		}
		
		else {
			cyclesToMove--;
		}
	}

	public static boolean haveLanded() {
		// TODO Auto-generated method stub
		return IS_IN_FINAL_ROW; //¿?
	}

	public static boolean allDead() {
		// TODO Auto-generated method stub
		return REMAINING_ALIENS == 0;
	}

	public static String getRemainingAliens() {
		// TODO Auto-generated method stub
		return Integer.toString(REMAINING_ALIENS); // String.valueOf(REMAINING_ALIENS);
	}

	public void onDelete() {
		super.onDelete();
		REMAINING_ALIENS -= 1;
	}
	
	public void resetRemainingAliens() {
		REMAINING_ALIENS = 0;
	}
	
	@Override
	public boolean receiveShockWaveAttack(int damage) {
		this.getDamage(damage);
//		if(this.live <= 0) {
//			this.onDelete();
//		}
		return true;
	}
	
}
