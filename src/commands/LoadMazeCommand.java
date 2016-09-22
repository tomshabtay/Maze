package commands;

import presenter.CommandsManager;

public class LoadMazeCommand extends CommandClass {

	public LoadMazeCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		c.loadMaze(args);

	}

}
