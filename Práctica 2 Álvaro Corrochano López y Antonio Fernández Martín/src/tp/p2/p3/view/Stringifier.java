package tp.p2.p3.view;

import tp.p2.p3.logic.Game;

public class Stringifier extends GamePrinter{
	
	
	public Stringifier() {
		
	}

	@Override // ¿?
	public String toString(Game game) {
		this.setGame(game);
		return game.stringify();
	}
	
}
