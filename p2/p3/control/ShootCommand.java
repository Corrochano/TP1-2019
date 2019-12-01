package tp.p2.p3.control;

import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;
import tp.p2.p3.view.PrinterGenerator;

public class ShootCommand extends Command {
	protected final static String name = "shoot";
	protected final static String shortcut = "s";
	private final static String details = "[s]hoot ([s]uper)";
	private final static String help = "UCM-Ship launches a missile. (Normal misssile 1 damage/super missile 2 damage)";
	private String[] myCommandWords;

	public ShootCommand() {
		super(ShootCommand.name, ShootCommand.shortcut, ShootCommand.details, ShootCommand.help);
	}

	@SuppressWarnings("resource")
	@Override
	public boolean execute(Game game, GamePrinter printer) {
		printer = PrinterGenerator.useBoardPrinter();
		if(this.myCommandWords.length == 1) {
			if(game.shootLaser()) {
				game.update();
				return true;
			}
			else {
				System.out.println("You have already shooted");
				System.out.println("Press Enter To Continue...");
		        new java.util.Scanner(System.in).nextLine();
				return false;
			}
		}
		else if (this.myCommandWords[1].equals("supermissile") || this.myCommandWords[1].equals("s")){
			if(game.shootSuperLaser()) {
				game.update();
				return true;
			}
			else {
				return false;
			}
		}
		else {
			System.out.println("Unknow command.");
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
