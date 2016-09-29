package commands;

import presenter.Presenter;

public class loadPropertiesCommand extends CommandClass {

	public loadPropertiesCommand(Presenter presenter) {
		super(presenter);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String args) {
		p.loadProperties();

	}

}
