package commands;

import presenter.Presenter;

public abstract class CommandClass implements Command{
	Presenter p;
	
	public CommandClass(Presenter presenter)
	{
		this.p = presenter;
	}

}
