package tp.p2.p2.logic;

import tp.p2.p2.logic.Game;
import tp.p2.p2.logic.Level;
import tp.p2.p2.logic.lists.GameObjectBoard;
import tp.p2.p2.logic.objects.Bomb;
import tp.p2.p2.logic.objects.DestroyerShip;
import tp.p2.p2.logic.objects.Ovni;
import tp.p2.p2.logic.objects.RegularShip;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this. game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni ();
		initializeRegularAliens ();
		initializeDestroyerAliens ();
		return board;
	}
	private void initializeOvni () {
		board.add(new Ovni(this.game));
	}
	private void initializeRegularAliens () {
		int regularPerRow = this.level.getNumRegularAliensPerRow();
		int rows = this.level.getNumRowsOfRegularAliens();
		int x = 3;
		int y = 1;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < regularPerRow; j++) {
				board.add(new RegularShip(this.game, x, y));
				x++;
			}
			y++;
			x = 3;
		}
	}
	private void initializeDestroyerAliens () {
		int destroyersPerRow = this.level.getNumDestroyerAliensPerRow();
		int numDestroyers = this.level.getNumDestroyerAliens();
		int x = 0;
		int y = this.level.getNumRowsOfRegularAliens() + 1;
		
		if(destroyersPerRow == 2) {
			x = 4;
		}
		else if(destroyersPerRow == 4) {
			x = 3;
		}
		
		for(int i = 0; i < numDestroyers; i++) {
			DestroyerShip destroy = new DestroyerShip(this.game, x, y);
			board.add(destroy);
			board.add(new Bomb(this.game, destroy.getX() + 1, destroy.getY(), destroy));
		}
		
	}
}