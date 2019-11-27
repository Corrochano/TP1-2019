package tp.p2.p2.control;

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
		new BuySuperMissileCommand()
	};
	
	public static Command parseCommand(String[ ] commandWords) {
		Command command = null;
		int i = 0;
		
		do {
			command = availableCommands[i].parse(commandWords);
			i++;
		}while(i < availableCommands.length && command == null);
		return command;
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
