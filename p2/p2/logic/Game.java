package tp.p2.p2.logic;

import java.util.Random;

import tp.p2.p2.logic.GamePrinter;
import tp.p2.p2.logic.Level;
import tp.p2.p2.logic.lists.GameObjectBoard;
import tp.p2.p2.logic.objects.AlienShip;
import tp.p2.p2.logic.objects.GameObject;
import tp.p2.p2.logic.objects.IPlayerController;
import tp.p2.p2.logic.objects.Ovni;
import tp.p2.p2.logic.objects.UCMShip;
import tp.p2.p2.logic.objects.UCMShipLaser;

import java.util.Random;

public class Game implements IPlayerController{
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
	private int currentCycle;
	private Random rand;
	private Level level;
	GameObjectBoard board;
	private UCMShip player;
	private boolean doExit;
	private BoardInitializer initializer ;
	
	public Game (Level level, Random random){
		this. rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X / 2, DIM_Y - 1);
		board.add(player);
	}
	
	public Random getRandom() {
		return rand;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void reset() {
		initGame();
	}
		
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	public String positionToString(int x, int y) {
		return board.toString(x, y);
	}

	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public boolean aliensWin() {
		return !player.isAlive () || AlienShip.haveLanded();
	}
	
	private boolean playerWin () {
		return AlienShip.allDead();
	}
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	public boolean isOnBoard(int x, int y) {
		return x >= 0 && y >= 0 && x < DIM_X && y < DIM_Y;
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		return "Cycles: " + currentCycle + "\n" +
		player.stateToString() +
			"Remaining aliens: " + (AlienShip.getRemainingAliens()) + "\n";
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String toStringObjectAt(int i, int j) {
		return null; //Poner cada uno en su lista
//		for(int k = 0; k < this.bombList.getBombCount(); k++) {
//			if(this.bombList.getPosXBomb(k) == i && this.bombList.getPosYBomb(k) == j)
//				return bombList.toStringBomb(k);
//		}
//		
//		for(int k = 0; k < this.destroyerList.getDestroyerCount(); k++) {
//			if(this.destroyerList.getPosXDestroyer(k) == i && this.destroyerList.getPosYDestroyer(k) == j)
//				return destroyerList.toStringDestroyer(k);
//		}
//		
//		for(int k = 0; k < this.regularList.getRegularCount(); k++) {
//			if(this.regularList.getPosXRegular(k) == i && this.regularList.getPosYRegular(k) == j)
//				return regularList.toStringRegular(k);
//		}
//		
//		if(getLaser() != null)
//			if(this.laser.getX() == i && this.laser.getY() == j)
//				return laser.toString();
//		
//		if(getOvni() != null)
//			if(this.ovni.getX() == i && this.ovni.getY() == j)
//				return this.ovni.toString();
//		
//		if(this.ucmShip.getX() == i && this.ucmShip.getY() == j)
//			return ucmShip.toString();
//		return " ";
	}
	
	
	// toString()
	@Override
	public String toString() {
		GamePrinter gamePrinter = new GamePrinter(this, DIM_X ,DIM_Y);
		System.out.print(this.infoToString());
		System.out.println(gamePrinter.toString());
		return null;
	}
	
	
	
	// TODO implementar los métodos del interfaz IPlayerController
	
	@Override
	public boolean move(int numCells) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean shootLaser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shockWave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		this.player.setPoints(this.player.getPoints() + points);
	}

	@Override
	public void enableShockWave() {
		// TODO Auto-generated method stub
		this.player.setHasShockWave(true);
		
	}

	@Override
	public void enableMissile() {
		// TODO Auto-generated method stub
		this.player.setCanShootLaser(true);
	}
	
}