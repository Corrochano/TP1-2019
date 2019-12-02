package tp.p2.p3.control;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;

public class ShockwaveCommand extends Command {
	protected final static String name = "shockwave";
	protected final static String shortcut = "w";
	private final static String details = "shock[w]ave";
	private final static String help = "UCM-Ship releases a shock wave.";

	public ShockwaveCommand() {
		super(ShockwaveCommand.name, ShockwaveCommand.shortcut, ShockwaveCommand.details, ShockwaveCommand.help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.shockWave();
		game.update();
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
