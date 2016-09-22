package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import commands.Command;
import model.MazeModel;
import view.MazeView;

public class Presenter implements Observer {

	private MazeView view;
	private MazeModel model;
	private CommandsManager commandsManager;
	private HashMap<String, Command> commands;

	public Presenter() {

	}

	public Presenter(MazeView view, MazeModel model) {
		this.view = view;
		this.model = model;
	
		this.commandsManager = new CommandsManager(view, model);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("Update!");
		
		String str = null;
		Command command = null;

		// Read user input
		str = (String) arg;

		command = commands.get(str.split(" ")[0]);

		// Execute the command

		if (command != null) {
			if (str.split(" ").length > 1) {

				command.doCommand(str.substring(str.split(" ")[0].length() + 1));
			} else {
				// out.println("Args needed, try again.");
			}
		} else {
			// out.println("Invalid Input.");
		}

	}
}