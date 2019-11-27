package tp.p2.p2.control;

import tp.p2.p2.logic.Game;

public class MoveCommand extends Command{
	protected final static String name = "move";
	protected final static String shortcut = "m";
	private final static String details = "[m]ove <[l]eft|[r]ight><1|2>";
	private final static String help = "Move UCM Ship";
	private String[] myCommandWords;

	public MoveCommand() {
		super(MoveCommand.name, MoveCommand.shortcut, MoveCommand.details, MoveCommand.help);
	}

	@SuppressWarnings("resource")
	@Override
	public boolean execute(Game game) {
		int aux = 0;
		if(this.myCommandWords[1].equals("left") || this.myCommandWords[1].equals("l")) {
			aux = -1 * Integer.parseInt(this.myCommandWords[2]);
		}
		
		else if(this.myCommandWords[1].equals("right") || this.myCommandWords[1].equals("r")) {
			aux = Integer.parseInt(this.myCommandWords[2]);
		}
	
		if(aux != 0) {
			if(game.move(aux)) {
				game.update();
				return true;
			}
			else {
				return false;
			}
		}
		else {
			System.out.println("Direction failed");
			System.out.println("Press Enter To Continue...");
			new java.util.Scanner(System.in).nextLine();
			return false;
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
