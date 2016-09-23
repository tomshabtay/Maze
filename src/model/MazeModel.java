package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.SearchableMaze;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import presenter.Presenter;

public class MazeModel extends Observable implements Model, Runnable {

	HashMap<String, Solution> solutions;
	HashMap<String, Maze3d> mazes;
	Properties properties;
	
	private ExecutorService executor;

	Maze3d currentMaze;
	
	public MazeModel() {
		// properties = PropertiesLoader.getInstance().getProperties();
		// executor =
		// Executors.newFixedThreadPool(properties.getNumOfThreads());
		
		this.mazes = new HashMap<String, Maze3d>(); 
		this.solutions =  new HashMap<String, Solution>(); 
		loadSolutions();
	}

	private void saveSolutions() {
		// TODO Auto-generated method stub

	}

	public void loadSolutions() {
		File file = new File("solutions.dat");
		if (!file.exists())
			return;
		// TODO

	}

	@Override
	public void run() {

	}

	public void exit() {
		executor.shutdownNow();
		saveSolutions();

	}

	public void generateMaze(String name, int x, int y, int z) {

		GrowingTreeGenerator g = new GrowingTreeGenerator();
		Maze3d maze = g.generate(x, y, z);
		mazes.put(name, maze);


		//setChanged();
		//notifyObservers("maze_ready " + name);
		

	}

	public void displayCross(String args) {
		String[] argsArray = args.split(" ");
		Maze3d m = mazes.get(argsArray[2]);
		int[][] m2d;

		if (argsArray[0].equalsIgnoreCase("x")) {
			m2d = m.getCrossSectionByX(Integer.valueOf(argsArray[1]));
			m.printCrossSectionByX(m2d);

		}
		if (argsArray[0].equalsIgnoreCase("y")) {
			m2d = m.getCrossSectionByY(Integer.valueOf(argsArray[1]));
			m.printCrossSectionByY(m2d);
		}
		if (argsArray[0].equalsIgnoreCase("z")) {
			m2d = m.getCrossSectionByZ(Integer.valueOf(argsArray[1]));
			m.printCrossSectionByZ(m2d);
		}

	}

	public void loadMaze(String args) {
		try {
			String[] argsArray = args.split(" ");
			String mazename = argsArray[0];
			String filename = argsArray[1] + ".maz";
			int sizeA, sizeB, size;

			InputStream in = new MyDecompressorInputStream(new FileInputStream(filename));
			int aint = in.read();
			int bint = in.read();
			int sizeint = aint * 100 + bint;

			byte b[] = new byte[sizeint];
			in.read(b);
			in.close();
			Maze3d m = new Maze3d(b);
			mazes.put(mazename, m);
		} catch (Exception e) {
			// c.printToOut("Problem loading the maze.");
			e.printStackTrace();
		}

	}

	public void saveMaze(String args) {
		try {
			String[] argsArray = args.split(" ");
			Maze3d m = mazes.get(argsArray[0]);
			String filename = argsArray[1] + ".maz";
			int sizeInt = m.toByteArray().length;

			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(filename));

			// Saving the maze size
			((MyCompressorOutputStream) out).writeSize(sizeInt);

			// Saving the maze
			out.write(m.toByteArray());
			out.flush();
			out.close();
		} catch (Exception e) {
			// c.printToOut("Problem saving the maze.");
			e.printStackTrace();
		}

	}

	public void displaySolution(String args) {
		String[] argsArray = args.split(" ");
		solutions.get(argsArray[0]).printSolution();
	}

	public void displayMaze(String args) {
		String[] argsArray = args.split(" ");
		mazes.get(argsArray[0]).printMaze();

	}

	public void solveMaze(String args) {
		String[] argsArray = args.split(" ");
		Maze3d maze = mazes.get(argsArray[0]);
		SearchableMaze searchableMaze = new SearchableMaze(maze);
		Searcher searcher;
		Solution solution = null;

		// Creating solution
		if (argsArray[1].equalsIgnoreCase("bfs")) {
			searcher = new BFS();
			solution = searcher.search(searchableMaze);
		} else if (argsArray[1].equalsIgnoreCase("dfs")) {
			searcher = new DFS();
			solution = searcher.search(searchableMaze);
		}

		this.solutions.put(argsArray[0], solution);

	}

	public String[] listMazes() {
		
		String[] s ={"avi","tom","maze1"} ;
		
		return s;
	}

	public Maze3d getMazeByName(String args) {
		String[] argsArray = args.split(" ");
		Maze3d m = mazes.get(argsArray[0]);
		return m;
		
	}

	public void test() {
		
		System.out.println("Generating Maze 'tom'.");
		generateMaze("tom", 15, 15, 10);
		
		System.out.println("Solving Maze.");
		solveMaze("tom BFS");
		
		System.out.println("Showing Solution:");
		displaySolution("tom");
		
		System.out.println("Displaying maze");
		displayMaze("tom");
		
	}
}
