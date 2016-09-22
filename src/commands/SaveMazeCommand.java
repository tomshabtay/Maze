package commands;

import presenter.Presenter;

public class SaveMazeCommand extends CommandClass {

	public SaveMazeCommand(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String args) {
		p.saveMaze(args);

	}

}
