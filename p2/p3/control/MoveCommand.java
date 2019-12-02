package tp.p2.p3.control;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;

public class MoveCommand extends Command{
	protected final static String name = "move";
	protected final static String shortcut = "m";
	private final static String details = "[m]ove <[l]eft|[r]ight><1|2>";
	private final static String help = "Move UCM Ship";
	private String[] myCommandWords;

	public MoveCommand() {
		super(MoveCommand.name, MoveCommand.shortcut, MoveCommand.details, MoveCommand.help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		int aux = 0;
		if(this.myCommandWords.length == 3) {
			if(this.myCommandWords[1].equals("left") || this.myCommandWords[1].equals("l")) {
				aux = -1 * Integer.parseInt(this.myCommandWords[2]);
			}
			
			else if(this.myCommandWords[1].equals("right") || this.myCommandWords[1].equals("r")) {
				aux = Integer.parseInt(this.myCommandWords[2]);
			}
			else {
				throw new CommandExecuteException("Direction failed");
			}
		
			if(aux != 0) {
				game.move(aux);
					game.update();
					return true;
			}
			else {
				throw new CommandExecuteException("You can't move 0 cells.");
			}
		}
		else {
			throw new CommandExecuteException("Argument error");
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
