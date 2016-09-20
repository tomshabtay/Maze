package view;

import java.util.Observable;

public class MazeView extends Observable  implements View, Runnable{

	BasicWindow window;
	
	public MazeView(){
		this.window = new BasicWindow("Maze3D");
	}
	
	@Override
	public void run() {
		window.run();
		
	}

}
