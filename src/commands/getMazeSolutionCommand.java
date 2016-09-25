package commands;

import presenter.Presenter;

public class getMazeSolutionCommand extends CommandClass {

	public getMazeSolutionCommand(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String args) {
		p.getMazeSolution(args);

	}

}
