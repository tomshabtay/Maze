package commands;

import presenter.Presenter;

public class GenerateMazeCommand extends CommandClass {

	public GenerateMazeCommand(Presenter presenter) {
		super(presenter);
	}

	@Override
	public void doCommand(String args) {
		String [] argsArray = args.split(" ");
		p.GenerateMaze(argsArray[0],
					   Integer.valueOf(argsArray[1]),
				  	   Integer.valueOf(argsArray[2]), 
				       Integer.valueOf(argsArray[3]));
	}

}
