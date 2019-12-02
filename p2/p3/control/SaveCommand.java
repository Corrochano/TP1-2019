package tp.p2.p3.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p2.p3.exceptions.CommandExecuteException;
import tp.p2.p3.logic.Game;
import tp.p2.p3.view.GamePrinter;

public class SaveCommand extends Command{
	
	protected final static String name = "save";
	protected final static String shortcut = "v";
	private final static String details = "sa[v]e";
	private final static String help = "This command saves the current game game in a .dat archive.";
	private String[] myCommandWords;
	private String fileName;
	private FileWriter fw;
	private BufferedWriter bw;

	public SaveCommand() {
		super(SaveCommand.name, SaveCommand.shortcut, SaveCommand.details, SaveCommand.help);
	}

//	public SaveCommand(String fileName) {
//		super(SaveCommand.name, SaveCommand.shortcut, SaveCommand.details, SaveCommand.help);
//		this.fileName = fileName + ".dat";
//	}
	
	
	@Override
	public boolean execute(Game game, GamePrinter printer) throws CommandExecuteException {
		if(myCommandWords.length == 2) {
			this.fileName = myCommandWords[1] + ".dat";
			try {
				fw = new FileWriter(this.fileName);
				bw = new BufferedWriter(fw);
				bw.write(game.stringify());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			System.out.println("Game saved");
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
