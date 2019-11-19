package tp.p1.logic.objects;

public class RegularShip {
	private int vida;
	private int x;
	private int y;
	
	public RegularShip() {
		this.setVida(2);
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
	
	public String toString() {
		return "C[" + this.getVida() + "]";
	}
}
