package tp.p2.p1.logic.lists;

import tp.p2.p1.logic.objects.Bomb;

public class BombList {
	private Bomb[] bombList;
	private int bombCount;
	
	
	public BombList(int bombListSizeIn){ //level
		this.bombList = new Bomb[bombListSizeIn];
		setBombCount(0);
	}


	public int getBombCount() {
		return bombCount;
	}


	public void setBombCount(int bombCount) {
		this.bombCount = bombCount;
	}
	
	public int getPosXBomb(int i) {
		return this.bombList[i].getX();
	}
	
	public int getPosYBomb(int i) {
		return this.bombList[i].getY();
	}
	
	public void setPosXBomb(int i, int xIn) {
		this.bombList[i].setX(xIn);
	}
	
	public String toStringBomb(int in) {
		return this.bombList[in].toString();
	}


	public void addBomb(Bomb bombIn) {
		this.bombList[this.getBombCount()] = bombIn;
		this.setBombCount(this.getBombCount() + 1);
	}
	
	public void borrarBomba(int in) {
		for(int i = in; i < this.bombCount - 1; i++) {
			this.bombList[i] = this.bombList[i + 1];
		}
		this.bombList[this.bombCount - 1] = null;
		this.bombCount--;
	}
	
}
