package commands;

import presenter.CommandsManager;

public abstract class CommandClass implements Command{
	CommandsManager c;
	
	public CommandClass(CommandsManager c)
	{
		this.c = c;
	}
}
