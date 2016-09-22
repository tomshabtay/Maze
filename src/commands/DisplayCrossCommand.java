package commands;

import presenter.Presenter;

public class DisplayCrossCommand extends CommandClass {

	public DisplayCrossCommand(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String args) {
		p.displayCross(args);

	}

}
