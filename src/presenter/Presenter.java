package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import commands.Command;
import commands.DirCommand;
import commands.DisplayCrossCommand;
import commands.DisplayMazeCommand;
import commands.DisplaySolutionCommand;
import commands.GenerateMazeCommand;
import commands.GetMazeCommand;
import commands.ListMazesCommand;
import commands.LoadMazeCommand;
import commands.PlayMazeCommand;
import commands.SaveMazeCommand;
import commands.SolveMazeCommand;
import commands.deleteAllMazesCommand;
import commands.deleteMazeCommand;
import commands.exitCommand;
import commands.getMazeSolutionCommand;
import commands.mazeReadyCommand;
import commands.solutionReadyCommand;
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
		commands.put("solve_maze", new SolveMazeCommand(this));
		commands.put("display_solution", new DisplaySolutionCommand(this));
		commands.put("list_mazes_in_map", new ListMazesCommand(this));
		commands.put("get_maze", new GetMazeCommand(this));
		commands.put("play_maze", new PlayMazeCommand(this));
		commands.put("get_maze_solution", new getMazeSolutionCommand(this));
		commands.put("exit", new exitCommand(this));
		commands.put("delete_maze", new deleteMazeCommand(this));
		commands.put("delete_all_mazes", new deleteAllMazesCommand(this));
		commands.put("maze_ready", new mazeReadyCommand(this));
		commands.put("solution_ready", new solutionReadyCommand(this));



	}

	@Override
	public void update(Observable o, Object arg) {


		String str = null;
		Command command = null;

		// Read input
		str = (String) arg;

		System.out.println("presenter:" + str);
		command = commands.get(str.split(" ")[0]);

		// Execute the command

	
		if (command != null) {
			//No args command
			if (!str.contains(" "))command.doCommand("");
			//Args in command
			else {
				command.doCommand(str.substring(str.split(" ")[0].length() + 1));
			}
		}

	}


	public void GenerateMaze(String name, int x, int y, int z) {
		model.generateMaze(name, x, y, z);
	}

	public void playMaze(String args) {
		Maze3d m = model.getMazeByName(args);
		view.playMaze(m);
		
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

	//cmd
	public void start() {
	
		view.start();
	}

	public void exit() {
		view.exit();
		model.exit();
		

	}

	public void ListMazes() {
		Set<String> mazes = model.listMazes();
		view.getMazeList(mazes);

	}

	public void getMaze(String args) {
		Maze3d maze = model.getMazeByName(args);
		if (maze != null) view.play(maze);

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

	public void getMazeSolution(String args) {
		Maze3d m = model.getMazeByName(args);
		Solution s = model.getSolution(args);
		if (s!=null) view.getSolution(s,m);
		
	}

	public void deleteMaze(String args) {
		model.deleteMaze(args);
		
	}

	public void deleteAllMazes(String args) {
		model.deleteAllMazes(args);
		
	}

	public void mazeReady(String args) {
		view.displayMessage("The Maze '" + args+"' is ready to play!");
		
	}

	public void solutionReady(String args) {
		view.displayMessage("The solution for '" + args+"' is ready.");
		
	}

}