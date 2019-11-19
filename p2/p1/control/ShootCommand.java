package tp.p2.p1.control;

import tp.p2.p1.logic.Game;

public class ShootCommand extends Command {
	protected final static String name = "shoot";
	protected final static String shortcut = "s";
	private final static String details = "[s]hoot";
	private final static String help = "UCM-Ship launches a missile.";

	public ShootCommand() {
		super(ShootCommand.name, ShootCommand.shortcut, ShootCommand.details, ShootCommand.help);
	}

	@SuppressWarnings("resource")
	@Override
	public boolean execute(Game game) {
		if(game.shoot()) {
			game.computerAction();
			game.update();
			game.addCycle();
			return true;
		}
		else {
			System.out.println("You have already shooted");
			System.out.println("Press Enter To Continue...");
	        new java.util.Scanner(System.in).nextLine();
			return false;
		}
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0]))
			return this;
		else
			return null;
	}

}
