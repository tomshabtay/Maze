
package boot;

import model.MazeModel;
import presenter.Presenter;
import view.MazeView;

public class Run {

	public static void main(String[] args) {
<<<<<<< HEAD
		MazeView view = new MazeView();
		MazeModel model = new MazeModel();
		Presenter presenter = new Presenter(view,model);
		view.addObserver(presenter);
		model.addObserver(presenter);
		view.run();
		
		
=======
		//master

>>>>>>> c0508932fb3fabf3515b2854e542d82bcd9513b7
	}

}
