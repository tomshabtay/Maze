package commands;

import presenter.Presenter;

public class GetMazeCommand extends CommandClass {

	public GetMazeCommand(Presenter presenter) {
		super(presenter);
	
	}

	@Override
	public void doCommand(String args) {
		p.getMaze(args);

	}

}
