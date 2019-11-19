package tp.p2.p2.logic.objects;

import tp.p2.p2.logic.Game;

public abstract class AlienShip extends EnemyShip {
	
	protected static int REMAINING_ALIENS = 0;
	private static boolean IS_IN_FINAL_ROW;
	private static int SHIPS_ON_BORDER;
	protected int cyclesToMove;

	public AlienShip(Game game, int x, int y, int live, int pointsIn) {
		super(game, x, y, live, pointsIn);
		REMAINING_ALIENS += 1;
		SHIPS_ON_BORDER = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(cyclesToMove == 0) {
//			Actualizar cyclesToMove
//			Hacer el movimiento a la izquierda o a la derecha
//			Actualizar IS_IN_FINAL_ROW
		}
		
		if(IS_IN_FINAL_ROW) { // ¿O else if?
			SHIPS_ON_BORDER = REMAINING_ALIENS;
		}
		
		if (SHIPS_ON_BORDER > 0 && !IS_IN_FINAL_ROW) {
//			Aumentar la fila
//			Cambiar el sentido del movimiento
//			SHIPS_ON_BORDER -= 1;
		}
		
		else {
			cyclesToMove--;
		}
	}

	public static boolean haveLanded() {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean allDead() {
		// TODO Auto-generated method stub
		return REMAINING_ALIENS == 0;
	}

	public static String getRemainingAliens() {
		// TODO Auto-generated method stub
		return Integer.toString(REMAINING_ALIENS); // String.valueOf(REMAINING_ALIENS);
	}

}
