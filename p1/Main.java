package tp.p1;

import java.util.Random;
import java.util.Scanner;

import tp.p1.control.Controller;
import tp.p1.logic.Game;
import tp.p1.logic.Level;

public class Main {
	private static Controller controller;
	private static int seed;
	private static Level level;
	private static Random rand;
	private static Scanner scan;
	private static Game game;

	public static void main(String[] args) {
		String difficult = "";
		if(args.length > 1) {
			seed = Integer.parseInt(args[1]);
			rand = new Random(seed);
		}
		else {
			rand = new Random();
		}
		scan = new Scanner(System.in);
		level = null;
		if(args.length < 1) {
			while(level != Level.EASY && level != Level.HARD && level != Level.INSANE) {
				System.out.println("Select Level: ");
				difficult = scan.nextLine();
				difficult.toLowerCase();
				
				switch(difficult) {
				case "easy": case "e": case "1":
					level = Level.EASY;
					break;
				case "hard": case "h": case "2":
					level = Level.HARD;
					break;
				case "insane": case "i": case "3":
					level = Level.INSANE;
					break;
					default:
						System.out.println("Wrong");
				}
			}
	}
		else {
			switch(args[0]) {
			case "easy": case "e": case "1":
				level = Level.EASY;
				break;
			case "hard": case "h": case "2":
				level = Level.HARD;
				break;
			case "insane": case "i": case "3":
				level = Level.INSANE;
				break;
				default:
					System.out.println("Wrong");
			}
		}
		
		
		game = new Game(level, rand);
		controller = new Controller(game, scan);
		controller.run();
		
	}

}
