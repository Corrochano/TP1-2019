package tp.p2.p2.logic.lists;

import tp.p2.p2.logic.Level;
import tp.p2.p2.logic.objects.Bomb;
import tp.p2.p2.logic.objects.DestroyerShip;

public class DestroyerShipList {
	private DestroyerShip[] destroyerList;
	private int destroyerCount;
	
	public DestroyerShipList(Level levelIn){
		
		setDestroyerCount(levelIn.getNumDestroyerAliens());
		this.destroyerList = new DestroyerShip[this.destroyerCount];
		
		for(int i = 0; i < this.destroyerCount; i++) {
			this.destroyerList[i] = new DestroyerShip();
		}
	
		int i = 0;
		int j = 0;
		
		if(levelIn == Level.EASY) {
			i = 2;
			j = 4;
		}
		
		
		else if (levelIn == Level.HARD) {
			i = 3;
			j = 4;
		}
		
		else if(levelIn == Level.INSANE) {
			i = 4;
			j = 3;
		}
		
		for(int k = 0; k < this.destroyerCount; k++) {
			this.destroyerList[k].setX(i);
			this.destroyerList[k].setY(j);
			j++;
		}
				
	}


	public int getDestroyerCount() {
		return destroyerCount;
	}


	public void setDestroyerCount(int destroyerCount) {
		this.destroyerCount = destroyerCount;
	}
	
	public int getPosXDestroyer(int i) {
		return this.destroyerList[i].getX();
	}
	
	public int getPosYDestroyer(int i) {
		return this.destroyerList[i].getY();
	}
	
	public void setPosXDestroyer(int i, int xIn) {
		this.destroyerList[i].setX(xIn);
	}
	
	public void setPosYDestroyer(int i, int yIn) {
		this.destroyerList[i].setY(yIn);
	}
	
	public int getVidaDestroyer(int i) {
		return this.destroyerList[i].getVida();
	}
	
	public String toStringDestroyer(int in) {
		return this.destroyerList[in].toString();
	}
	
	public void shockWave() {
		for(int i = 0; i < this.destroyerCount; i++) {
			this.destroyerList[i].setVida(this.destroyerList[i].getVida() - 1);
			if(this.destroyerList[i].getVida() <= 0){
				for(int k = i; k < this.destroyerCount - 1; k++) {
					this.destroyerList[k] = this.destroyerList[k + 1];
				}
				this.destroyerList[this.destroyerCount - 1] = null;
				this.destroyerCount--;
				i--;
			}
		}
	}
	
	public void setDestroyerBomb(int in, BombList bombListIn) { 
		if(this.destroyerList[in].getBomb() == null) {
			this.destroyerList[in].createBomb(bombListIn);
		}
	}
	
	public void eliminaVida(int in) {
			this.destroyerList[in].setVida(this.destroyerList[in].getVida() - 1);
			//Ordenar muerte
			if(this.destroyerList[in].getVida() == 0) {
				for(int i = in; i < this.destroyerCount - 1; i++) {
					this.destroyerList[i] = this.destroyerList[i + 1];
				}
				this.destroyerList[this.destroyerCount - 1] = null;
				this.destroyerCount--;
			}
		}
	
	public int puntos() {
		return 10;
	}
	
	public void borrarDestroyerBomb(int in) {
		this.destroyerList[in].setBomb(null);
	}
	
	public int getPosXDestroyerBomb(int i) {
		return this.destroyerList[i].getBombX();
	}
	
	public int getPosYDestroyerBomb(int i) {
		return this.destroyerList[i].getBombY();
	}
	
	public Bomb getDestroyerBomb(int in) { 
		return this.destroyerList[in].getBomb();
	}


}
