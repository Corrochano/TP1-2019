package tp.p2.p3.control;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;

public class BuySuperMissileCommand extends Command {

	protected final static String name = "buy";
	protected final static String shortcut = "b";
	private final static String details = "[b]uy";
	private final static String help = "Buy super missile for 20 points, thats perform 2 damage.";
	
	public BuySuperMissileCommand() {
		super(BuySuperMissileCommand.name, BuySuperMissileCommand.shortcut, BuySuperMissileCommand.details,
				BuySuperMissileCommand.help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.buySuperMissile();
			return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0]))
			return this;
		else
			return null;
	}

}
