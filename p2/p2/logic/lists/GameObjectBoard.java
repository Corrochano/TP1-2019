package tp.p2.p2.logic.lists;
import tp.p2.p2.logic.objects.GameObject;

public class GameObjectBoard {
	private GameObject[] objects;
	private int currentObjects;
	private int width;
	private int height;
	
	public GameObjectBoard (int width, int height) {
		// TODO implement
		objects = new GameObject[width*height];
		this.width = width;
		this.height = height;
		this.currentObjects = 0;
		
	}
	
	private int getCurrentObjects() {
		return this.currentObjects;
	}
	
	public void add (GameObject object) {
		// TODO implement
		this.objects[currentObjects] = object;
		this.currentObjects++;
	}
	
	private GameObject getObjectInPosition(int x, int y) {
		// TODO implement
		for(int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i].getX() == x && this.objects[i].getY() == y) {
				return objects[i];
			}
		}
		return null;
	}
	
	private int getIndex(int x, int y) {
		for(int i = 0; i < this.currentObjects; i++) {
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
			for(int i =  aux; i < currentObjects - 1; i++) {
				objects[aux] = objects[aux + 1];
			}
			
			objects[currentObjects - 1] = null;
			
			this.currentObjects -= 1;
		}
	}
	
	public void update() {
		// TODO implement
	}
	
	private void checkAttacks(GameObject object) { // Lo llama update
		// TODO implement
	}
	
	public void computerAction() {
		for(int i = 0; i < this.currentObjects; i++)
			this.objects[i].computerAction();
	}
	
	private void removeDead() {
		for(int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i].getLive() <= 0) {
				remove(objects[i]);
			}
		}
	}
	
	public String toString(int x, int y) {
		int aux = getIndex(x, y);
		if(aux >= 0) {
			return objects[aux].toString();
		}
		else {
			System.out.println("Esto no debería pasar");
			return null;
		}
	}
}
