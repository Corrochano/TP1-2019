package tp.p2.p3.logic.objects;


public enum Move {
	
	LEFT, RIGHT, UP, DOWN, NONE;
	
	public Move flip() {
		if(this == LEFT) return RIGHT;
		if(this == RIGHT) return LEFT;
		return this;
	}
	
}
	
