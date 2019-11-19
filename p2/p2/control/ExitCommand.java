package tp.p2.p2.control;

import tp.p2.p2.logic.Game;

public class ExitCommand extends Command{
	protected final static String name = "exit";
	protected final static String shortcut = "e";
	private final static String details = "[e]xit";
	private final static String help = "Terminates the program.";

	public 	ExitCommand() {
		super(ExitCommand.name, ExitCommand.shortcut, ExitCommand.details, ExitCommand.help);
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0]))
			return this;
		else
			return null;
	}
}
