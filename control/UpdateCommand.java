package tp.p2.p2.control;

import tp.p2.p2.logic.Game;

public class UpdateCommand extends Command{
	protected final static String name = "none";
	protected final static String shortcut = "n";
	protected final static String shortcut2 = "";
	private final static String details = "[n]one";
	private final static String help = "Skips one cycle.";

	public UpdateCommand() {
		super(UpdateCommand.name, UpdateCommand.shortcut, UpdateCommand.details, UpdateCommand.help);
	}

	@Override
	public boolean execute(Game game) {
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0]))
			return this;
		else
			return null;
	}
	
	@Override
	public boolean matchCommandName(String inName) {
		if(inName.equalsIgnoreCase(UpdateCommand.shortcut) || inName.equalsIgnoreCase(UpdateCommand.name) ||
				inName.equalsIgnoreCase(UpdateCommand.shortcut2))
			return true;
		else
			return false;	
	}
	
}
