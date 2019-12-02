package tp.p2.p3.control;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;
import tp.p2.p3.view.PrinterGenerator;

public class ShockwaveCommand extends Command {
	protected final static String name = "shockwave";
	protected final static String shortcut = "w";
	private final static String details = "shock[w]ave";
	private final static String help = "UCM-Ship releases a shock wave.";

	public ShockwaveCommand() {
		super(ShockwaveCommand.name, ShockwaveCommand.shortcut, ShockwaveCommand.details, ShockwaveCommand.help);
	}

	@Override
	public boolean execute(Game game, GamePrinter printer) throws CommandExecuteException {
		printer = PrinterGenerator.useBoardPrinter();
		if(game.shockWave()) {
			game.update();
			return true;
		}
		else {
			throw new CommandExecuteException("ShockWave is disable");
//			System.out.println("Shock Wave is disable");
//			System.out.println("Press Enter To Continue...");
//	        new java.util.Scanner(System.in).nextLine();
//	        return false;
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
