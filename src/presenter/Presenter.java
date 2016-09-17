package presenter;

import java.util.Observable;
import java.util.Observer;

import model.MazeModel;
import view.MazeView;

public class Presenter implements Observer{
	
	private MazeView view;
	private MazeModel model;
	
	public Presenter(){
		
	}

	public Presenter(MazeView view, MazeModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void update(Observable o, Object args) {
		if(o == view){
			
		}
		else if(o == model){
			
		}
		
	}
}
