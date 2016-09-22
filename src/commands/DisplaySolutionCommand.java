package commands;

import presenter.Presenter;

public class DisplaySolutionCommand extends CommandClass {

	public DisplaySolutionCommand(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String args) {
		p.displaySolution(args);

	}

}
