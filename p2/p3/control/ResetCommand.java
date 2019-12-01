package tp.p2.p3.control;

import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;
import tp.p2.p3.view.PrinterGenerator;

public class ResetCommand extends Command{
	protected final static String name = "reset";
	protected final static String shortcut = "r";
	private final static String details = "[r]eset";
	private final static String help = "Starts a new game.";

	public ResetCommand() {
		super(ResetCommand.name, ResetCommand.shortcut, ResetCommand.details, ResetCommand.help);
	}

	@Override
	public boolean execute(Game game, GamePrinter printer) {
		printer = PrinterGenerator.useBoardPrinter();
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
