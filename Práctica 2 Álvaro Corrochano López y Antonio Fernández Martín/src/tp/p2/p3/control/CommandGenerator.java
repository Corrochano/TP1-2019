package tp.p2.p3.control;

import tp.p2.p3.exceptions.CommandParseException;

public class CommandGenerator {

	private static Command[] availableCommands = {
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ListCommand(),
		new UpdateCommand(),
		new MoveCommand(),
		new ShockwaveCommand(),
		new ShootCommand(),
		new BuySuperMissileCommand(),
		new StringifyCommand(),
		new ListPrintersCommand(), 
		new SaveCommand()
	};
	
	public static Command parseCommand(String[ ] commandWords) throws CommandParseException{
		Command command = null;
		int i = 0;
		
		do {
			command = availableCommands[i].parse(commandWords);
			i++;
		}while(i < availableCommands.length && command == null);
		
		if(command != null) {
			return command;
		}
		else {
			throw new CommandParseException("Command doesn't exists");
		}
	}
	
	public static String commandHelp() {
		String help = "Avaliable commands: \n";
		
		for(Command i : availableCommands) {
			help += i.helpText();
			help += "\n";
		}
		return help;	
	}
		
	
	
}
