package commands;

import presenter.Presenter;

public class LoadMazeCommand extends CommandClass {

	public LoadMazeCommand(Presenter p) {
		super(p);
	}

	@Override
	public void doCommand(String args) {
		p.loadMaze(args);

	}

}
