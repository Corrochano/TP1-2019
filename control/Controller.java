package tp.p2.p2.control;

import java.util.Scanner;

import tp.p2.p2.logic.Game;

public class Controller {
	private static final String PROMPT = "Command > ";
	private static final String unknownCommandMsg = "Unknown Command";
	
	Scanner scan;
	Game game;
	
	public Controller(Game gameIn, Scanner scanIn) { // Game game, Scanner in
		this.game = gameIn;
		this.scan = scanIn;
	}
	
	public void run(){
		System.out.println(this.game);
		while(!this.game.isFinished()) {
			System.out.print(PROMPT);
			String[] comando = scan.nextLine().toLowerCase().trim().split ("\\s+");	
			Command command = CommandGenerator.parseCommand(comando);
			if(command != null) {
				if (command.execute(game)) {
					System.out.println(game/*.toString()*/);
				}
			}
			else {
				System.out.println(unknownCommandMsg);
				System.out.println("Press Enter To Continue...");
				new java.util.Scanner(System.in).nextLine();
			}
		}
		System.out.println(game.getWinnerMessage());
	}
}