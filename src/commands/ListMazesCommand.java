package commands;

import presenter.Presenter;

public class ListMazesCommand extends CommandClass {

	public ListMazesCommand(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String args) {
		p.ListMazes();

	}

}
