package presenter;


import java.util.HashMap;

import commands.Command;
import commands.DirCommand;
import commands.DisplayCrossCommand;
import commands.DisplayMazeCommand;
import commands.DisplaySolutionCommand;
import commands.GenerateMazeCommand;
import commands.LoadMazeCommand;
import commands.SaveMazeCommand;
import commands.SolveMazeCommand;
import model.MazeModel;
import view.MazeView;


public class CommandsManager {

	private MazeView view;
	private MazeModel model;
	private HashMap<String, Command> commands;

	public CommandsManager(MazeView view, MazeModel model) {
		//Commands initiating
		this.commands = new HashMap<String, Command>();
		commands.put("dir", new DirCommand(this));
		commands.put("generate_3d_maze", new GenerateMazeCommand(this));
		commands.put("display", new DisplayMazeCommand(this));
		commands.put("display_cross_section", new DisplayCrossCommand(this));
		commands.put("save_maze", new SaveMazeCommand(this));
		commands.put("load_maze", new LoadMazeCommand(this));
		commands.put("solve", new SolveMazeCommand(this));
		commands.put("display_solution", new DisplaySolutionCommand(this));

		this.view = view;
		this.model = model;

	}

	
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
}
