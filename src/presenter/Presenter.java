package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import commands.Command;
import commands.DirCommand;
import commands.DisplayCrossCommand;
import commands.DisplayMazeCommand;
import commands.DisplaySolutionCommand;
import commands.GenerateMazeCommand;
import commands.ListMazesCommand;
import commands.LoadMazeCommand;
import commands.SaveMazeCommand;
import commands.SolveMazeCommand;
import model.MazeModel;
import view.MazeView;

public class Presenter implements Observer {

	private MazeView view;
	private MazeModel model;

	private HashMap<String, Command> commands;

	public Presenter() {

	}

	public Presenter(MazeView view, MazeModel model) {
		this.view = view;
		this.model = model;

		// Commands initiating
		this.commands = new HashMap<String, Command>();
		commands.put("dir", new DirCommand(this));
		commands.put("generate_3d_maze", new GenerateMazeCommand(this));
		commands.put("display", new DisplayMazeCommand(this));
		commands.put("display_cross_section", new DisplayCrossCommand(this));
		commands.put("save_maze", new SaveMazeCommand(this));
		commands.put("load_maze", new LoadMazeCommand(this));
		commands.put("solve", new SolveMazeCommand(this));
		commands.put("display_solution", new DisplaySolutionCommand(this));
		commands.put("list_mazes_in_map", new ListMazesCommand(this));

	}

	@Override
	public void update(Observable o, Object arg) {

		System.out.println("Update!");
		

		String str = null;
		Command command = null;

		// Read user input
		str = (String) arg;
		System.out.println(str);

		command = commands.get(str.split(" ")[0]);

		// Execute the command

		if (command != null) {
			command.doCommand(null);
			//command.doCommand(str.substring(str.split(" ")[0].length() + 1));
			}

	}
	
	
	
	
	
	
	
	//cmd
public void start() {
		
		view.start();
	}

	public void printToOut(String str) {
		view.printToOut(str);
	}

	public void GenerateMaze(String name, int x, int y, int z) {
		model.generateMaze(name, x, y, z);
	}

	public void displayMaze(String name) {
		model.displayMaze(name);
	}

	public void displayCross(String args) {
		model.displayCross(args);
	}
	
	public void displaySolution(String args)
	{
		model.displaySolution(args);
	}
	
	public void solveMaze(String args)
	{
		model.solveMaze(args);
	}

	public void saveMaze(String args){
		model.saveMaze(args);
	}
	
	public void loadMaze(String args){
		model.loadMaze(args);
	}

	public void exit() {
		// TODO Auto-generated method stub
		
	}

	public void ListMazes() {
		String[] mazes = model.listMazes();
		view.getMazeList(mazes);
		
	}
	
}