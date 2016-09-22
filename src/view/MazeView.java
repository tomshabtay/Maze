package view;

import java.util.Observable;

import algorithms.mazeGenerators.Maze3d;

public class MazeView extends Observable  implements View, Runnable{

	MazeWindow window;
	
	public MazeView(){
		this.window = new MazeWindow();
	}
	
	@Override
	public void run() {
		window.run();
		
	}

	public void printToOut(String str) {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyMazeIsReady(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMaze(Maze3d maze) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

}
