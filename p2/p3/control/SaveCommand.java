package tp.p2.p3.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;

public class SaveCommand extends Command{
	
	protected final static String name = "save";
	protected final static String shortcut = "v";
	private final static String details = "sa[v]e";
	private final static String help = "This command saves the current game game in a .dat archive.";
	private String[] myCommandWords;
	private String fileName;
	private FileWriter f;
	private BufferedWriter b;

	public SaveCommand() {
		super(SaveCommand.name, SaveCommand.shortcut, SaveCommand.details, SaveCommand.help);
	}

//	public SaveCommand(String fileName) {
//		super(SaveCommand.name, SaveCommand.shortcut, SaveCommand.details, SaveCommand.help);
//		this.fileName = fileName + ".dat";
//	}
	
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(myCommandWords.length == 2) {
			this.fileName = myCommandWords[1] + ".dat";
			try {
				f = new FileWriter(this.fileName);
				b = new BufferedWriter(f);
				b.write(game.stringify());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
					try {
						if(b != null) {
							b.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				
					try {
						if(f != null) {
							f.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			System.out.println("Game successfully saved in file "
					+ this.fileName 
					+" Use the load command to reload it");
			return false;
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
