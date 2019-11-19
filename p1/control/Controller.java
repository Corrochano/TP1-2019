package tp.p1.control;

import java.util.Scanner;

import tp.p1.logic.Game;

public class Controller {
	Scanner scan;
	Game game;
	
	public Controller(Game gameIn, Scanner scanIn) { // Game game, Scanner in
		this.game = gameIn;
		this.scan = scanIn;
	}
	
	public void run(){ // Poner juego acabado
		String comando;
		System.out.println(this.game.toString());
		while(!this.game.isGameOver()) {
			System.out.print("Command > ");
			comando = this.scan.nextLine();
			if(commands(comando)) {
				this.game.computerAction();
				this.game.update();
			}
			System.out.println(this.game.toString());
			this.game.gananAliens();
			if(!this.game.isGameOver()) {
				this.game.ganaUCMShip();
			}
			
		}
		
	}
	
	
public boolean commands(String comandoIn){
		boolean nextCycle = true;
		comandoIn = comandoIn.toLowerCase();
		
			String[] comandoPart = comandoIn.split(" ");
					
			switch(comandoPart[0]) { 	
			case "move": case "m":
				if(this.game.move(comandoPart)) {
					this.game.addCycle();
				}
				else {
					System.out.println("You can't move so far away or direction failed");
					System.out.println("Press Enter To Continue...");
			        new java.util.Scanner(System.in).nextLine();
			        nextCycle = false;
				}
				break;
				
			case "shoot": case "s":
				if(this.game.shoot()) {
					this.game.addCycle();
				}
				else {
					System.out.println("You have already shooted");
					System.out.println("Press Enter To Continue...");
			        new java.util.Scanner(System.in).nextLine();
			        nextCycle = false;
				}
				break;
				
			case "shockwave": case "w":
				if(this.game.shockwave()) {
					this.game.addCycle();
				}
				else {
					System.out.println("Shock Wave is disable");
					System.out.println("Press Enter To Continue...");
			        new java.util.Scanner(System.in).nextLine();
			        nextCycle = false;
				}
				
				break;
				
			case "reset": case "r":
				this.game.reset();
				nextCycle = false;
				break;
				
			case "list": case "l":
				this.game.list();
				System.out.println("Press Enter To Continue...");
		        new java.util.Scanner(System.in).nextLine();
				nextCycle = false;
				break;
				
			case "none": case "n": case "": 
				this.game.addCycle();
				break;
			
			case "help": case "h":
				this.game.help();
				System.out.println("Press Enter To Continue...");
		        new java.util.Scanner(System.in).nextLine();
				nextCycle = false;
				break;
				
			case "exit": case "e":
				this.game.exit();
				nextCycle = false;
				break;
			
			default: 
				System.out.println("Commando doesn't exist");
				System.out.println("Press Enter To Continue...");
		        new java.util.Scanner(System.in).nextLine();
				nextCycle = false;
				
			}
		return nextCycle;
	}
	
	
}
