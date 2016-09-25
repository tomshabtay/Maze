package commands;

import presenter.Presenter;

public class solutionReadyCommand extends CommandClass {

	public solutionReadyCommand(Presenter presenter) {
		super(presenter);

	}

	@Override
	public void doCommand(String args) {
		p.solutionReady(args);

	}

}
