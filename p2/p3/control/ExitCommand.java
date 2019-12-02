package tp.p2.p3.control;

import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;

public class ExitCommand extends Command{
	protected final static String name = "exit";
	protected final static String shortcut = "e";
	private final static String details = "[e]xit";
	private final static String help = "Terminates the program.";

	public 	ExitCommand() {
		super(ExitCommand.name, ExitCommand.shortcut, ExitCommand.details, ExitCommand.help);
	}

	@Override
	public boolean execute(Game game, GamePrinter printer) {
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
