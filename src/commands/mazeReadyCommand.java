package commands;

import presenter.Presenter;

public class mazeReadyCommand extends CommandClass {

	public mazeReadyCommand(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String args) {
		p.mazeReady(args);

	}

}
