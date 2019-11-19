package tp.p2.p1.logic;

public enum Level {
	EASY,
	HARD,
	INSANE;
	
	
	
	public int regularAliens() {
		int num;
		if(this == EASY)
			num = 4;
		else if(this == HARD)
			num = 8;
		else if(this == INSANE)
			num = 12;
		else
			num = 0;
		
		return num;
	}
	
	public int destroyerAliens() {
		int num;
		if(this == EASY)
			num = 2;
		else if(this == HARD)
			num = 2;
		else if(this == INSANE)
			num = 4;
		else
			num = 0;
		return num;
	}
	
	
	public double frecDisparo() {
		double num;
		if(this == EASY)
			num = 0.1;
		else if(this == HARD)
			num = 0.3;
		else if(this == INSANE)
			num = 0.5;
		else
			num = 0;
		
		return num;
	}
	
	
	public int velocidad() {
		int num;
		if(this == EASY)
			num = 3;
		else if(this == HARD)
			num = 2;
		else if(this == INSANE)
			num = 1;
		else
			num = 0;
		
		return num;
	}
	
	
	public double frecOvni() {
		double num;
		if(this == EASY)
			num = 0.5;
		else if(this == HARD)
			num = 0.2;
		else if(this == INSANE)
			num = 0.1;
		else
			num = 0;
		
		return num;
	}
	
	
}
