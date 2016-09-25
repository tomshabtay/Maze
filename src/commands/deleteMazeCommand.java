package commands;

import presenter.Presenter;

public class deleteMazeCommand extends CommandClass {

	public deleteMazeCommand(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String args) {
		p.deleteMaze(args);

	}

}
