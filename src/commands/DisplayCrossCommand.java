package commands;

import presenter.CommandsManager;

public class DisplayCrossCommand extends CommandClass {

	public DisplayCrossCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		c.displayCross(args);

	}

}
