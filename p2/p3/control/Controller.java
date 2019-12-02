package tp.p2.p3.control;

import java.util.Scanner;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.exceptions.CommandParseException;
import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;
import tp.p2.p3.view.PrinterGenerator;

public class Controller {
	private static final String PROMPT = "Command > ";
//	private static final String unknownCommandMsg = "Unknown Command";
	
	private Scanner scan;
	private Game game;
	private GamePrinter printer;
	
	public Controller(Game gameIn, Scanner scanIn) { // Game game, Scanner in
		this.game = gameIn;
		this.scan = scanIn;
	}
	
	public void run(){
		this.printer = PrinterGenerator.useBoardPrinter();
		System.out.println(this.printer.toString(this.game));
		while(!this.game.isFinished()) {
			System.out.print(PROMPT);
			String[] comando = scan.nextLine().toLowerCase().trim().split ("\\s+");	
			try {
				Command command = CommandGenerator.parseCommand(comando);
				if(command != null) {
					if (command.execute(game, printer)) {
						System.out.println(printer.toString(game)); // Normalmente será BoardPrinter
					}
				}
//				else {
//					System.out.println(unknownCommandMsg);
//					System.out.println("Press Enter To Continue...");
//					new java.util.Scanner(System.in).nextLine();
//				}
			} catch(CommandParseException | CommandExecuteException ex){
				System.out.format(ex.getMessage() + " %n %n"); 
			}
		}
		System.out.println(game.getWinnerMessage());
	}
}