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
	public final static int DIM_X = 8;
	public final static int DIM_Y = 9;
	private int currentCycle;
	private Random rand;
	private Level level;
	GameObjectBoard board;
	private UCMShip player;
	private boolean doExit;
	private BoardInitializer initializer ;
	private int points;
	
	public Game (Level level, Random random){
		this. rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	
	public void initGame () {
		currentCycle = 0;
		this.points = 0;
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_X - 1, DIM_Y / 2);
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
		return positionToString(i, j);
	}
	
	
	// toString()
	@Override
	public String toString() {
		String ret;
		GamePrinter gamePrinter = new GamePrinter(this, DIM_X ,DIM_Y);
		ret = infoToString();
		ret += gamePrinter.toString();
		return ret;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	// TODO implementar los métodos del interfaz IPlayerController
	
	@Override
	public boolean move(int numCells) {
		// TODO Auto-generated method stub
		if(this.isOnBoard(this.player.getX(), this.player.getY() + numCells)) {
			this.player.setY(this.player.getY() + numCells);
			return true;
		}
		else {
			//System.out.println("You can´t move so far away.");
			return false;
		}
	}
	
	public void list() {
		System.out.println("Command > list\r\n" + 
				"[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\r\n" + 
				"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\r\n" + 
				"[O]vni: Points: 25 - Harm: 0 - Shield: 1\r\n" + 
				"^__^: Harm: 1 - Shield: 3");
	}

	@Override
	public boolean shootLaser() {
		// TODO Auto-generated method stub
		if(this.getMissileEnable()) {
			this.board.add(new UCMShipLaser(this, this.player.getX(), this.player.getY()));
			this.disableMissile();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean shockWave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		this.points += points;
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
	
	public boolean getMissileEnable() {
		return this.player.getCanShootLaser();
	}
	
	public void disableMissile() {
		this.player.setCanShootLaser(false);
	}
	
}