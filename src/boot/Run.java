
package boot;

import model.MazeModel;
import presenter.Presenter;
import view.MazeView;

public class Run {

	public static void main(String[] args) {

		MazeView view = new MazeView();
		MazeModel model = new MazeModel();
		Presenter presenter = new Presenter(view,model);
		view.addObserver(presenter);
		model.addObserver(presenter);
		view.run();
		
		

	}

}
