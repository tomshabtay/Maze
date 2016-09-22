package commands;

import java.io.File;

import presenter.Presenter;

public class DirCommand extends CommandClass {

	public DirCommand(Presenter p) {
		super(p);
	}

	@Override
	public void doCommand(String args) {

		try {
			File folder = new File(args);
			File[] listOfFiles = folder.listFiles();
			// Files
			//p.printToOut("Files:\n");
			//p.printToOut("------\n");

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					//c.printToOut(listOfFiles[i].getName());
					//c.printToOut("\n");
				}
			}

			// Directory
			//p.printToOut("Directories:\n");
			//p.printToOut("------------\n");
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isDirectory()) {
					//c.printToOut(listOfFiles[i].getName());
					//c.printToOut("\n");
				}
			}
			//p.printToOut("\n");

		} catch (Exception e) {
			//p.printToOut("No files, try another path.\n");
		}

	}

}
