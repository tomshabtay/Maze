package commands;

import presenter.Presenter;

public class SolveMazeCommand extends CommandClass {

	public SolveMazeCommand(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String args) {
		p.solveMaze(args);

	}

}
