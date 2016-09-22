package commands;

import presenter.CommandsManager;

public class DisplaySolutionCommand extends CommandClass {

	public DisplaySolutionCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {
		c.displaySolution(args);

	}

}
