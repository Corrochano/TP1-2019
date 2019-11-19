package tp.p2.p1.control;

import tp.p2.p1.logic.Game;

public class ListCommand extends Command{
	protected final static String name = "list";
	protected final static String shortcut = "l";
	private final static String details = "[l]ist";
	private final static String help = "Prints the list of available ships.";

	public ListCommand() {
		super(ListCommand.name, ListCommand.shortcut, ListCommand.details, ListCommand.help);
	}

	@SuppressWarnings("resource")
	@Override
	public boolean execute(Game game) {
		game.list();
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
