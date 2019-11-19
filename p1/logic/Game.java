package tp.p1.logic;

import java.util.Random;

import tp.p1.logic.objects.UCMShip;
import tp.p1.logic.objects.UCMShipLaser;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.Level;
import tp.p1.logic.Move;
import tp.p1.logic.lists.BombList;
import tp.p1.logic.lists.DestroyerShipList;
import tp.p1.logic.lists.RegularShipList;
import tp.p1.logic.GamePrinter;

public class Game {
	
	private static final int ROWS = 8;
	private static final int COLS = 9;
	
	private UCMShipLaser laser;
	private UCMShip ucmShip;
	private Ovni ovni;
	private BombList bombList;
	private DestroyerShipList destroyerList;
	private RegularShipList regularList;
	private Level level;
	private Move dir;
	private boolean gameOver;
	private int cycles;
	private int points;
	private boolean shockWave; //Cuando mata ovni se recarga
	private Random rand;
	private boolean ovniPrimerTurno;
	
	
	public Game(Level levelIn, Random randIn){
		this.level = levelIn;
		this.rand = randIn;
		initGame(this.level);
	}
	
	
	
	
	public void initGame(Level level) {
		this.ucmShip = new UCMShip();	
		setLaser(null);
		setOvni(null);
		this.setDir(Move.RIGHT);
		this.bombList = new BombList(level.destroyerAliens());
		this.destroyerList = new DestroyerShipList(level);
		this.regularList = new RegularShipList(level);
		this.setGameOver(false);
		this.cycles = 1;
		this.points = 0;
		this.shockWave = false;
	}
	
	public boolean move(String[] comandoPart) {
		if(comandoPart[1].equals("left") || comandoPart[1].equals("l")) { //left right					
			if(comandoPart[2].equals("1")) {
				if(this.ucmShip.getY() - 1 >= 0) {
					this.ucmShip.setY(this.ucmShip.getY() - 1);
					return true;
				}
				else {
					return false;
				}
			}
			if(comandoPart[2].equals("2")) {
				if(this.ucmShip.getY() - 2 >= 0) {
					this.ucmShip.setY(this.ucmShip.getY() - 2);
					return true;
				}
				else {
					return false;
				}
			}
			return true;
		}
		else if (comandoPart[1].equals("right") || comandoPart[1].equals("r")) { // Hacer comprobación de errores
			if(comandoPart[2].equals("1")) {
				if(this.ucmShip.getY() + 1 <= COLS -1) {
					this.ucmShip.setY(this.ucmShip.getY() + 1);
					return true;
				}
				else {
					return false;
				}
			}
			if(comandoPart[2].equals("2")) {
				if(this.ucmShip.getY() + 2 <= COLS -1) {
					this.ucmShip.setY(this.ucmShip.getY() + 2);
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	public void exit() {
		System.out.println("Game Over");
		this.setGameOver(true);
	}
	
	public void help() {
		System.out.println("move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\n"
				+ "shoot: UCM-Ship launches a missile.\n"
				+ "shockWave: UCM-Ship releases a shock wave.\n"
				+ "list: Prints the list of available ships.\n"
				+ "reset: Starts a new game.\n"
				+ "help: Prints this help message.\n"
				+ "exit: Terminates the program.\n"
				+ "[none]: Skips one cycle.");
	}
	
	public void list() {
		System.out.println("Command > list\r\n" + 
				"[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\r\n" + 
				"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1\r\n" + 
				"[O]vni: Points: 25 - Harm: 0 - Shield: 1\r\n" + 
				"^__^: Harm: 1 - Shield: 3");
	}
	
	public void reset() {
		this.initGame(this.level);
	}
	
	public boolean shoot() {
		if(this.laser == null) {
			this.setLaser(new UCMShipLaser(this.ucmShip.getX(), this.ucmShip.getY()));
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean shockwave() {
		if(this.shockWave) {
			this.destroyerList.shockWave();
			this.regularList.shockWave();
			this.shockWave = false;
			return true;
		}
		return false;
	}
	
	
	
	public void computerAction() {
		if(this.getOvni() == null) {
			if(this.rand.nextDouble() <= this.level.frecOvni()) {
				this.ovni = new Ovni();
				this.setOvniPrimerTurno(true);
			}
		}
			
		for(int i = 0; i < destroyerList.getDestroyerCount(); i++) {
			if(this.rand.nextDouble() <= this.level.frecDisparo()) {
				this.destroyerList.setDestroyerBomb(i, this.bombList);
			}
		}
	}
	
	public void update() {
		if(this.cycles % this.level.velocidad() == 0) { //Movimiento naves
			if(this.getDir() == Move.RIGHT) {
				for(int i = 0; i < this.destroyerList.getDestroyerCount(); i++) {
					this.destroyerList.setPosYDestroyer(i, this.destroyerList.getPosYDestroyer(i) + 1);
					
					if(this.destroyerList.getPosYDestroyer(i) == COLS - 1) {
						this.setDir(Move.DOWN);
					}
					
				}
				
				for(int i = 0; i < this.regularList.getRegularCount(); i++) {
					this.regularList.setPosYRegular(i, this.regularList.getPosYRegular(i) + 1);
					
					if(this.regularList.getPosYRegular(i) == COLS - 1) {
						this.setDir(Move.DOWN);
					}
				}
			}
			
			else if(this.getDir() == Move.LEFT){
				for(int i = 0; i < this.destroyerList.getDestroyerCount(); i++) {
					this.destroyerList.setPosYDestroyer(i, this.destroyerList.getPosYDestroyer(i) - 1);
					if(this.destroyerList.getPosYDestroyer(i) == 0) {
						this.setDir(Move.DOWN);
					}
				}
				
				for(int i = 0; i < this.regularList.getRegularCount(); i++) {
					this.regularList.setPosYRegular(i, this.regularList.getPosYRegular(i) - 1);
					
					if(this.regularList.getPosYRegular(0) == 0) {
						this.setDir(Move.DOWN);
					}
				}
			}
			
			else if(this.getDir() == Move.DOWN) {
				for(int i = 0; i < this.destroyerList.getDestroyerCount(); i++) {
					this.destroyerList.setPosXDestroyer(i, this.destroyerList.getPosXDestroyer(i) + 1);
					if(this.destroyerList.getPosYDestroyer(i) == 0) {
						this.setDir(Move.RIGHT);
					}
					else if (this.destroyerList.getPosYDestroyer(i) == COLS - 1){
						this.setDir(Move.LEFT);
					}
				}
				
				for(int i = 0; i < this.regularList.getRegularCount(); i++) {
					this.regularList.setPosXRegular(i, this.regularList.getPosXRegular(i) + 1);
					
					if(this.regularList.getPosYRegular(i) == 0) {
						this.setDir(Move.RIGHT);
					}
					else if (this.regularList.getPosYRegular(i) == COLS - 1){
						this.setDir(Move.LEFT);
					}
				}
			}
		}
		
		
		if(this.getOvni() != null) { //Movimiento ovni
			if(!getOvniPrimerTurno()) {
				this.ovni.setY(this.ovni.getY() - 1);
				if(this.ovni.getY() < 0) {
					this.setOvni(null);
				}
			}
			setOvniPrimerTurno(false);
		}
		
		
		for(int i = 0; i < bombList.getBombCount(); i++) { //Movimiento Bombas
			this.bombList.setPosXBomb(i, this.bombList.getPosXBomb(i) + 1);
		
			if(this.bombList.getPosXBomb(i) == this.ucmShip.getX() 
					&& this.bombList.getPosYBomb(i) == this.ucmShip.getY()) { // Muerte nave
				this.ucmShip.setVida(this.ucmShip.getVida() - 1);
				for(int j = 0; j < this.destroyerList.getDestroyerCount(); j++) {
					if(this.destroyerList.getDestroyerBomb(j) != null) {
						if(this.bombList.getPosXBomb(i) == this.destroyerList.getPosXDestroyerBomb(j) && 
								this.bombList.getPosYBomb(i) == this.destroyerList.getPosYDestroyerBomb(j)) {
							this.destroyerList.borrarDestroyerBomb(j);
						}
					}
				}
				this.bombList.borrarBomba(i);
				i--;
			}
			
			else if(this.bombList.getPosXBomb(i) == ROWS) { // Eliminación llega abajo
				for(int j = 0; j < this.destroyerList.getDestroyerCount(); j++) {
					if(this.destroyerList.getDestroyerBomb(j) != null) {
						if(this.bombList.getPosXBomb(i) == this.destroyerList.getPosXDestroyerBomb(j) && 
								this.bombList.getPosYBomb(i) == this.destroyerList.getPosYDestroyerBomb(j)) {
							this.destroyerList.borrarDestroyerBomb(j);
						}
					}
				}
				this.bombList.borrarBomba(i);
				i--;
			}	
		}
		
		if(this.getLaser() != null) { // Movimiento láser
			if(this.laser.getX() != 0) {
				this.laser.setX(this.laser.getX() - 1);
				
				//Comprobación muerte
				for(int i = 0; i < this.destroyerList.getDestroyerCount() && getLaser() != null; i++) {
					if(this.laser.getX() == this.destroyerList.getPosXDestroyer(i) 
							&& this.laser.getY() == this.destroyerList.getPosYDestroyer(i)) {
						// Restar vida
						this.destroyerList.eliminaVida(i);
						this.points += this.destroyerList.puntos();
						this.setLaser(null);
					}
				}
				
				for(int i = 0; i < this.regularList.getRegularCount() && getLaser() != null; i++) {
					if(this.laser.getX() == this.regularList.getPosXRegular(i) 
							&& this.laser.getY() == this.regularList.getPosYRegular(i)) {
						// Restar vida
						this.regularList.eliminaVida(i);
						this.setLaser(null);
						this.points += this.regularList.puntos();
					}
				}
				
				if(this.getOvni() != null && this.getLaser() != null) {
					if(this.ovni.getX() == this.laser.getX() 
							&& this.ovni.getY() == this.laser.getY()) {
						this.shockWave = true;
						this.setLaser(null);
						this.points += this.ovni.puntos();
						this.ovni = null;
					}
				}
				
			}
			else {
				this.setLaser(null);
			}
		}
		
	}
	
	public String toString() { //cabezera + crear gameprinter // \n. 
		String screen;
		GamePrinter gamePrinter = new GamePrinter(this, ROWS, COLS);
		screen = "Life: " + this.ucmShip.getVida() + "\n" 
				+ "Number of cycles: " + this.cycles + "\n"
				+ "Points: " + this.points + "\n"
				+ "Remaining Aliens: " + (this.destroyerList.getDestroyerCount() + this.regularList.getRegularCount()) +"\n"
				+ "Shock Wave: ";
		if(shockWave)
			screen += "YES\n";
		else
			screen += "NO\n";
		
		screen += gamePrinter.toString();
		
		return screen;
	}
	
	
	public String toStringObjectAt(int i, int j) {
		
		for(int k = 0; k < this.bombList.getBombCount(); k++) {
			if(this.bombList.getPosXBomb(k) == i && this.bombList.getPosYBomb(k) == j)
				return bombList.toStringBomb(k);
		}
		
		for(int k = 0; k < this.destroyerList.getDestroyerCount(); k++) {
			if(this.destroyerList.getPosXDestroyer(k) == i && this.destroyerList.getPosYDestroyer(k) == j)
				return destroyerList.toStringDestroyer(k);
		}
		
		for(int k = 0; k < this.regularList.getRegularCount(); k++) {
			if(this.regularList.getPosXRegular(k) == i && this.regularList.getPosYRegular(k) == j)
				return regularList.toStringRegular(k);
		}
		
		if(getLaser() != null)
			if(this.laser.getX() == i && this.laser.getY() == j)
				return laser.toString();
		
		if(getOvni() != null)
			if(this.ovni.getX() == i && this.ovni.getY() == j)
				return this.ovni.toString();
		
		if(this.ucmShip.getX() == i && this.ucmShip.getY() == j)
			return ucmShip.toString();
		return " ";
	}

	public UCMShipLaser getLaser() {
		return laser;
	}

	public void setLaser(UCMShipLaser laserIn) {
		this.laser = laserIn;
	}
	
	public void setOvni(Ovni ovniIn) {
		this.ovni = ovniIn;
	}
	
	public Ovni getOvni() {
		return ovni;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public void addCycle() {
		this.cycles++;
	}




	public Move getDir() {
		return dir;
	}




	public void setDir(Move dir) {
		this.dir = dir;
	}
	
	public void gananAliens() {
		for(int i = 0; i < this.destroyerList.getDestroyerCount(); i++) {
			if(this.destroyerList.getPosXDestroyer(i) == ROWS - 1) {
				this.setGameOver(true);
			}
		}
		for(int i = 0; i < this.regularList.getRegularCount(); i++) {
			if(this.regularList.getPosXRegular(i) == ROWS - 1) {
				this.setGameOver(true);
			}
		}
		
		if(this.ucmShip.getVida() <= 0) {
			this.setGameOver(true);
		}
		
		if(isGameOver()) {
			System.out.println("ALIENS WIN");
			System.out.println("Game Over");
		}
		
	}
	
	public void ganaUCMShip() {
		if((this.destroyerList.getDestroyerCount() + this.regularList.getRegularCount()) == 0) {
			this.setGameOver(true);
		}
		if(this.isGameOver()) {
			System.out.println("UCM SHIP WINS");
			System.out.println("Game Over");
		}
	}
	
	public boolean getOvniPrimerTurno() {
		return this.ovniPrimerTurno;
	}
	
	public void setOvniPrimerTurno(boolean in) {
		this.ovniPrimerTurno = in;
	}
	
}