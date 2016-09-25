package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPOutputStream;

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
	
	//Properties properties;
	//private ExecutorService executor;

	Maze3d currentMaze;
	
	public MazeModel() {
		// properties = PropertiesLoader.getInstance().getProperties();
		// executor =
		// Executors.newFixedThreadPool(properties.getNumOfThreads());
		
		loadHashMaps();
		if(mazes == null) this.mazes = new HashMap<String, Maze3d>(); 
		if(solutions == null) this.solutions =  new HashMap<String, Solution>(); 
	}
	
	public void saveHashMaps(){
		try {
		FileOutputStream fosMazes = new FileOutputStream("mazes.ser");
		FileOutputStream fosSolutions = new FileOutputStream("solutions.ser");
		
        ObjectOutputStream oosMazes = new ObjectOutputStream(fosMazes);
        ObjectOutputStream oosSolutions = new ObjectOutputStream(fosSolutions);
        
        oosMazes.writeObject(mazes);
        oosMazes.close();
        fosMazes.close();
        
        oosSolutions.writeObject(solutions);
        oosSolutions.close();
        fosSolutions.close();
        
		} catch (IOException e) {
					
			e.printStackTrace();
		}
	}
	
	public void loadHashMaps(){
		 try
	      {
	         FileInputStream fisMazes = new FileInputStream("mazes.ser");
	         FileInputStream fisSolutions = new FileInputStream("solutions.ser");
	         
	         ObjectInputStream oisMazes = new ObjectInputStream(fisMazes);
	         ObjectInputStream oisSolutions = new ObjectInputStream(fisSolutions);
	         
	         mazes = (HashMap) oisMazes.readObject();
	         oisMazes.close();
	         fisMazes.close();
	         
	         solutions = (HashMap) oisSolutions.readObject();
	         oisSolutions.close();
	         fisSolutions.close();
	         
	         
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	      }
		 catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	      }
	}

	public Maze3d getMazeByName(String args) {
		//Return the maze referenced in args
		Maze3d m = mazes.get(args);
		return m;
		
	}

	public Set<String> listMazes() {
		//Returns all the mazes in the database
		return mazes.keySet();
	}

	public void generateMaze(String name, int x, int y, int z) {
		//Generating a Maze
		GrowingTreeGenerator g = new GrowingTreeGenerator();
		Maze3d maze = g.generate(x, y, z);
		mazes.put(name, maze);

		
		setChanged();
		notifyObservers("maze_ready " + name);
		

	}

	public void solveMaze(String args) {
		//Creating a solution to the maze in referenced in args
		//and saving it in database
		
		String[] argsArray = args.split(" ");
		if(solutions.containsKey(argsArray[0])) return; //check if solution is already exist
		
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
		
		setChanged();
		notifyObservers("solution_ready " + argsArray[0]);
	
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




	@Override
	public void run() {
	
	}

	public void test() {
		

		
		//generateMaze("bat7", 13, 13, 4);

		//generateMaze("big", 35, 35, 100);
		//solveMaze("big DFS");
		
		
	}

	public void exit() {
		//executor.shutdownNow();
		saveHashMaps();
	
	}

	public void displayMaze(String args) {
		String[] argsArray = args.split(" ");
		mazes.get(argsArray[0]).printMaze();
	
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

	public void displaySolution(String args) {
		String[] argsArray = args.split(" ");
		solutions.get(argsArray[0]).printSolution();
	}

	public Solution getSolution(String args) {
		Solution s = solutions.get(args);
		return s;
		
	}

	public void deleteMaze(String args) {
		mazes.remove(args);
		solutions.remove(args);
		
	}
	
	public void deleteAllMazes(String args) {
		mazes.clear();
		solutions.clear();
		
	}
	
	
}
