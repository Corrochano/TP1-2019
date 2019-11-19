package tp.p2.p1.logic.lists;

import tp.p2.p1.logic.Level;
import tp.p2.p1.logic.objects.RegularShip;

public class RegularShipList {
	private RegularShip[] regularList;
	private int regularCount;
	
	public RegularShipList(Level levelIn){
		
		setRegularCount(levelIn.regularAliens());
		this.regularList = new RegularShip[this.regularCount];
		
		for(int i = 0; i < this.regularCount; i++) {
			this.regularList[i] = new RegularShip();
		}
	
		int i = 1;
		int j = 3;
		
		for(int k = 1; k <= this.regularCount; k++) {
			this.regularList[k - 1].setX(i);
			this.regularList[k - 1].setY(j);
			j++;
			
			if(k % 4 == 0) {
				i++;
				j = 3;
			}
		}
		
	}


	public int getRegularCount() {
		return regularCount;
	}


	public void setRegularCount(int regularCount) {
		this.regularCount = regularCount;
	}
	
	public int getPosXRegular(int i) {
		return this.regularList[i].getX();
	}
	
	public int getPosYRegular(int i) {
		return this.regularList[i].getY();
	}
	
	public int getVidaRegular(int i) {
		return this.regularList[i].getVida();
	}
	
	public void setPosXRegular(int i, int xIn) {
		this.regularList[i].setX(xIn);
	}
	
	public void setPosYRegular(int i, int yIn) {
		this.regularList[i].setY(yIn);
	}
	
	public String toStringRegular(int in) {
		return this.regularList[in].toString();
	}
	
	public void shockWave() {
		for(int i = 0; i < this.regularCount; i++) {
			this.regularList[i].setVida(this.regularList[i].getVida() - 1);
			if(this.regularList[i].getVida() <= 0){
				for(int k = i; k < this.regularCount - 1; k++) {
					this.regularList[k] = this.regularList[k + 1];
				}
				this.regularList[this.regularCount - 1] = null;
				this.regularCount--;
				i--;
			}
		}
	}
	
	public void eliminaVida(int in) {
		this.regularList[in].setVida(this.regularList[in].getVida() - 1);
		//Ordenar muerte
		if(this.regularList[in].getVida() == 0) {
			for(int i = in; i < this.regularCount - 1; i++) {
				this.regularList[i] = this.regularList[i + 1];
			}
			this.regularList[this.regularCount - 1] = null;
			this.regularCount--;
		}
	}

	public int puntos() {
		return 5;
	}
	
}
