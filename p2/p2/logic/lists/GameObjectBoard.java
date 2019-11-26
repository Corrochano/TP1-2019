package tp.p2.p2.logic.lists;
import tp.p2.p2.logic.objects.Bomb;
import tp.p2.p2.logic.objects.GameObject;
import tp.p2.p2.logic.objects.Shockwave;
import tp.p2.p2.logic.objects.UCMShipLaser;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	private int width;
	private int height;
	
	public GameObjectBoard (int width, int height) {
		// TODO implement
		objects = new GameObject[width*height];
//		this.width = width;
//		this.height = height;
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
		return -1; //Error, no hay nada ahí
	}
	
	private void remove(GameObject object) {
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
		// TODO implement
		for(int i = 0; i < getCurrentObjects(); i++) {
			objects[i].move();
			checkAttacks(this.objects[i]);
			if(objects[i] instanceof Shockwave) {
				objects[i].onDelete();
			}
		}
		this.removeDead();
	}
	
	private void checkAttacks(GameObject object) { // Lo llama update
//		GameObject aux = getObjectInPosition(object.getX(), object.getY());
//		aux.performAttack(object);
		for (int i = 0; i < this.currentObjects; i ++) {
			GameObject other = objects[i];
			if (object != other)
				object.performAttack(other);
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
//		for(int i = 0; i < this.currentObjects; i++) {
//			if(this.objects[i].getLive() <= 0) {
//				remove(objects[i]);
//			}
//		}
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
}
