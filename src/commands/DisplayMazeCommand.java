package commands;

import presenter.CommandsManager;

public class DisplayMazeCommand extends CommandClass {

	public DisplayMazeCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		c.displayMaze(args);

	}

}
