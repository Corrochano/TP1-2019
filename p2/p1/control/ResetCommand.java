package tp.p2.p1.control;

import tp.p2.p1.logic.Game;

public class ResetCommand extends Command{
	protected final static String name = "reset";
	protected final static String shortcut = "r";
	private final static String details = "[r]eset";
	private final static String help = "Starts a new game.";

	public ResetCommand() {
		super(ResetCommand.name, ResetCommand.shortcut, ResetCommand.details, ResetCommand.help);
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
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
