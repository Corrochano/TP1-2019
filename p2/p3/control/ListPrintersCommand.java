package tp.p2.p3.control;

import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;
import tp.p2.p3.view.PrinterGenerator;
import tp.p2.p3.view.PrinterTypes;

public class ListPrintersCommand extends Command{
	
	protected final static String name = "listprinters";
protected final static String shortcut = "p";
		private final static String details = "list[p]rinters";
	private final static String help = "Show all the printers options of the program.";

	public ListPrintersCommand() {
		super(ListPrintersCommand.name, ListPrintersCommand.shortcut, ListPrintersCommand.details, 
				ListPrintersCommand.help);
	}

	@Override
	public boolean execute(Game game, GamePrinter printer) {
		printer = PrinterGenerator.useBoardPrinter();
		System.out.println(PrinterTypes.printerHelp(game));
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
