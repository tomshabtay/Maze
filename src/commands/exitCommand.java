package commands;

import presenter.Presenter;

public class exitCommand extends CommandClass {

	public exitCommand(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String args) {
		p.exit();

	}

}
