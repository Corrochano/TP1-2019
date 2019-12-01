package tp.p2.p3.control;

import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;
import tp.p2.p3.view.PrinterGenerator;

public class HelpCommand extends Command {
	
	protected final static String name = "help";
	protected final static String shortcut = "h";
	private final static String details = "[h]elp";
	private final static String help = "Show this help";

	public HelpCommand() {
		super(HelpCommand.name, HelpCommand.shortcut, HelpCommand.details, HelpCommand.help);
	}

	@SuppressWarnings("resource")
	@Override
	public boolean execute(Game game, GamePrinter printer) {
		printer = PrinterGenerator.useBoardPrinter();
		System.out.print(CommandGenerator.commandHelp());
		System.out.println("Press Enter To Continue...");
        new java.util.Scanner(System.in).nextLine();
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
