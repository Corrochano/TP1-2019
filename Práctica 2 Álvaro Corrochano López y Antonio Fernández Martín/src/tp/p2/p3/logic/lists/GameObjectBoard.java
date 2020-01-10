package tp.p2.p3.logic.lists;
import tp.p2.p3.logic.objects.GameObject;
import tp.p2.p3.logic.objects.Shockwave;
import tp.p2.p3.logic.objects.UCMShipLaser;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
		objects = new GameObject[width*height];
		this.currentObjects = 0;
		
	}
	
	private int getCurrentObjects() {
		return this.currentObjects;
	}
	
	public void add (GameObject object) {
		this.objects[getCurrentObjects()] = object;
		this.currentObjects++;
	}
	
	private GameObject getObjectInPosition(int x, int y) {
		for(int i = 0; i < getCurrentObjects(); i++) {
			if(this.objects[i].getX() == x && this.objects[i].getY() == y) {
				return objects[i];
			}
		}
		return null;
	}
	
	private int getIndex(int x, int y) {
		for(int i = 0; i < getCurrentObjects(); i++) {
			if(this.objects[i].getX() == x && this.objects[i].getY() == y) {
				return i;
			}
		}
		return -1; //Error, no hay nada ah�
	}
	
	public void remove(GameObject object) {
		int aux = this.getIndex(object.getX(), object.getY());
		// Reordenar
		if(aux != - 1) {
			for(int i =  aux; i < getCurrentObjects() - 1; i++) {
				objects[i] = objects[i + 1];
			}
			
			objects[getCurrentObjects() - 1] = null;
			
			this.currentObjects -= 1;
		}
	}
	
	public void update() {
		for(int i = 0; i < getCurrentObjects(); i++) {
			objects[i].move();
			checkAttacks(this.objects[i]);
		}
		this.removeDead();
	}
	
	public void shockWave(Shockwave shockwave) {
		int aux = this.getIndex(shockwave.getX(), shockwave.getY());
		if(aux != - 1) {
			for (int i = 0; i < this.currentObjects; i++) {
				GameObject other = objects[i];
				if (objects[aux] != other)
					if(objects[aux].performAttack(other)) {
						if(other.getLive() <= 0) {
							other.onDelete();
							this.remove(other);
							i--;
							aux--;
						}
					}
			}
			objects[aux].onDelete();
		}
	}
	
	private void checkAttacks(GameObject object) { // Lo llama update
		for (int i = 0; i < this.currentObjects; i ++) {
			GameObject other = objects[i];
			if (object != other)
				if(object.performAttack(other)) {
					if(other.getLive() <= 0) {
						other.onDelete();
					}
				}
		}
	}
	
	public void computerAction() {
		for(int i = 0; i < getCurrentObjects(); i++)
			this.objects[i].computerAction();
	}
	
	private void removeDead() {
		for(int i = this.currentObjects - 1; i >= 0; i--) {
			if(this.objects[i].getLive() <= 0) {
				remove(objects[i]);
			}
		}
	}
	
	public String toString(int x, int y) {
		GameObject aux = getObjectInPosition(x, y);
		if(aux == null) {
			return "";
		}
		else {
			return aux.toString();
		}
	}
	
	public void reorderLaser(UCMShipLaser laser) {
		int aux = this.getIndex(laser.getX(), laser.getY());
		GameObject object = null;
		// Reordenar
		if(aux != - 1) {
			for(int i =  aux; i < getCurrentObjects() - 1; i++) {
				object = objects[i];
				objects[i] = objects[i + 1];
				objects[i + 1] = object;
			}
		}
	}
	
	public void doDamage(int x, int y) {
		if(-1 < x && x < 8 && -1 < y && y < 9) {
			int aux = this.getIndex(x, y);
			if(aux != -1) {
				this.objects[aux].getDamage(1);
				if(this.objects[aux].getLive() == 0) {
					this.objects[aux].onDelete();
				}
			}
		}
	}

	public String stringify() { // Llamar al Stringify de todos
		String ret = "\n";
		String aux;
		for(int i = 0; i < getCurrentObjects(); i++) {
			aux = this.objects[i].stringify();
			if(aux != null) {
				ret += aux;
			}
		}
		return ret;
	}
	
}
