package commands;

import presenter.Presenter;

public class deleteAllMazesCommand extends CommandClass {

	public deleteAllMazesCommand(Presenter presenter) {
		super(presenter);

	}

	@Override
	public void doCommand(String args) {
		p.deleteAllMazes(args);

	}

}
