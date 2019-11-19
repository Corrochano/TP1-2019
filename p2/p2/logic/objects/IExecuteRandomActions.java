package tp.p2.p2.logic.objects;

import java.util.Random;

import tp.p2.p2.logic.Game;
import tp.p2.p2.logic.Level;

public interface IExecuteRandomActions {
	static boolean canGenerateRandomOvni(Game game){
		return ((Random) game.getRandom()).nextDouble() < ((Level) game.getLevel()).getOvniFrequency();
	}
	static boolean canGenerateRandomBomb(Game game){
		return ((Random) game.getRandom()).nextDouble() < ((Level) game.getLevel()).getOvniFrequency();
	}
}