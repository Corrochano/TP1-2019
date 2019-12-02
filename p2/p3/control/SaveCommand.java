package tp.p2.p3.control;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;

public class SaveCommand extends Command{
	
	protected final static String name = "save";
	protected final static String shortcut = "v";
	private final static String details = "sa[v]e";
	private final static String help = "This command saves the current game game.";

	public SaveCommand() {
		super(SaveCommand.name, SaveCommand.shortcut, SaveCommand.details, SaveCommand.help);
	}

	@Override
	public boolean execute(Game game, GamePrinter printer) throws CommandExecuteException {
		// TODO
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
