package commands;

import presenter.Presenter;

public class DisplayMazeCommand extends CommandClass {

	public DisplayMazeCommand(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String args) {
		p.displayMaze(args);

	}

}
