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
		RegularShip aux = new RegularShip(this.game, -1, -1);
		aux.resetRemainingAliens();
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
		int x = 1;
		int y = 3;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < regularPerRow; j++) {
				board.add(new RegularShip(this.game, x, y));
				y++;
			}
			x++;
			y = 3;
		}
	}
	private void initializeDestroyerAliens () {
		int destroyersPerRow = this.level.getNumDestroyerAliensPerRow();
		int numDestroyers = this.level.getNumDestroyerAliens();
		int y = 0;
		int x = this.level.getNumRowsOfRegularAliens() + 1;
		
		if(destroyersPerRow == 2) {
			y = 4;
		}
		else if(destroyersPerRow == 4) {
			y = 3;
		}
		
		for(int i = 0; i < numDestroyers; i++) {
			DestroyerShip destroy = new DestroyerShip(this.game, x, y + i);
			board.add(destroy);
			board.add(new Bomb(this.game, destroy));
		}
		
	}
}