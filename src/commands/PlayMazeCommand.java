package commands;

import presenter.Presenter;

public class PlayMazeCommand extends CommandClass {

	public PlayMazeCommand(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String args) {
	p.playMaze(args);

	}

}
