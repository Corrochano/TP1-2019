package tp.p2.p3.view;

import tp.p2.p3.logic.Game;

public abstract class GamePrinter {
	Game game;
	
	public void setGame(Game gameIn) {
		this.game = gameIn;
	}

	public abstract String toString(Game game);
}
