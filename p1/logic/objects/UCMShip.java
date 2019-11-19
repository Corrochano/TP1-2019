package tp.p1.logic.objects;

public class UCMShip {
	private int vida;
	private int x;
	private int y;
	
	public UCMShip() {
		this.setVida(3);
		this.setX(7);
		this.setY(4);
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
		if(this.getVida() > 0) {
			return "^__^";
		}
		else {
			return "!xx!";
		}
	}
}
