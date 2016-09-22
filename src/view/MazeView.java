package view;

import java.util.Observable;
import java.util.Observer;

import algorithms.mazeGenerators.Maze3d;
import presenter.Presenter;

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

	public void testObs() {
		System.out.println("Num obs:"+ this.countObservers());
		setChanged();
		this.notifyObservers("generate_3d_maze testing 5 5 5");
		notifyObservers();
		
	}

}
