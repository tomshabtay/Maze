package commands;

import presenter.CommandsManager;

public class GenerateMazeCommand extends CommandClass {

	public GenerateMazeCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		String [] argsArray = args.split(" ");
		c.GenerateMaze(argsArray[0],
					   Integer.valueOf(argsArray[1]),
				  	   Integer.valueOf(argsArray[2]), 
				       Integer.valueOf(argsArray[3]));
	}

}
