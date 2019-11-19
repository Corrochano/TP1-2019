package tp.p2.p1.logic.objects;

import tp.p2.p1.logic.lists.BombList;

public class DestroyerShip {
	private int vida;
	private int x;
	private int y;
	private Bomb bomb;
	
	public DestroyerShip() {
		this.setVida(1);
		this.setBomb(null);
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Bomb getBomb() {
		return bomb;
	}

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}
	
	public String toString() {
		return "D[" + this.getVida() + "]";
	}
	
	public void createBomb(BombList bombListIn) {
		this.bomb = new Bomb(this.x, this.y);
		bombListIn.addBomb(this.bomb);
	}
	
	public int getBombX() {
		return this.bomb.getX();
	}
	
	public int getBombY() {
		return this.bomb.getY();
	}
	
}
