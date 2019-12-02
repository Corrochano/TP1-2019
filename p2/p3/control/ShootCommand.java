package tp.p2.p3.control;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;

public class ShootCommand extends Command {
	protected final static String name = "shoot";
	protected final static String shortcut = "s";
	private final static String details = "[s]hoot ([s]uper)";
	private final static String help = "UCM-Ship launches a missile. (Normal misssile 1 damage/super missile 2 damage)";
	private String[] myCommandWords;

	public ShootCommand() {
		super(ShootCommand.name, ShootCommand.shortcut, ShootCommand.details, ShootCommand.help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(this.myCommandWords.length == 1) {
			game.shootLaser();
			game.update();
			return true;
		}
		else if (this.myCommandWords[1].equals("supermissile") || this.myCommandWords[1].equals("s")){
			game.shootSuperLaser();
			game.update();
			return true;
		}
		else {
			throw new CommandExecuteException("Argument error.");
		}
	}

	@Override
	public Command parse(String[] commandWords) {
		if(matchCommandName(commandWords[0])) {
			this.myCommandWords = commandWords;
			return this;
		}
		else
			return null;
	}

}
