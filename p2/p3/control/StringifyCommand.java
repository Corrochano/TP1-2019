package tp.p2.p3.control;

import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;
import tp.p2.p3.view.PrinterGenerator;

public class StringifyCommand extends Command {
	protected final static String name = "stringify";
	protected final static String shortcut = "z";
	private final static String details = "stringify[z]";
	private final static String help = "Transform the game into a string.";
	
	public StringifyCommand() {
		super(StringifyCommand.name, StringifyCommand.shortcut, StringifyCommand.details, StringifyCommand.help);
	}

	@Override
	public boolean execute(Game game, GamePrinter printer) {
		printer = PrinterGenerator.useStringifier();
		System.out.println(printer.toString(game));
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) {
			return this;
		}
		else
			return null;
	}

}
