package commands;

import presenter.CommandsManager;

public class SolveMazeCommand extends CommandClass {

	public SolveMazeCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		c.solveMaze(args);

	}

}
