package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import commands.Command;
import model.MazeModel;
import view.MazeView;

public class Presenter implements Observer{
	
	private MazeView view;
	private MazeModel model;
	private CommandsManager commandsManager;
	private HashMap<String, Command> commands;
	
	public Presenter(){
		
	}

	public Presenter(MazeView view, MazeModel model) {
		this.view = view;
		this.model = model;
		this.commandsManager = new CommandsManager(view, model);
	}

	@Override
	public void update(Observable o, Object args) {
		if(o == view){
			
		}
		else if(o == model){
			
		}
		
	}
}
