package tp.p2.p1.control;

import java.util.Scanner;

import tp.p2.p1.logic.Game;

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
		while(!this.game.isGameOver()) {
			System.out.print(PROMPT);
			String[] comando = scan.nextLine().toLowerCase().trim().split ("\\s+");	
			Command command = CommandGenerator.parseCommand(comando);
			if(command != null) {
				if (command.execute(game)) {
					System.out.println(game);
				}
			}
			else {
				System.out.println(unknownCommandMsg);
			}
		}
	}
}