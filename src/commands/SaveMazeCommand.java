package commands;

import presenter.CommandsManager;

public class SaveMazeCommand extends CommandClass {

	public SaveMazeCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		c.saveMaze(args);

	}

}
