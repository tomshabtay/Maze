package commands;

import java.io.File;

import presenter.CommandsManager;

public class DirCommand extends CommandClass {

	public DirCommand(CommandsManager c) {
		super(c);
	}

	@Override
	public void doCommand(String args) {

		try {
			File folder = new File(args);
			File[] listOfFiles = folder.listFiles();
			// Files
			c.printToOut("Files:\n");
			c.printToOut("------\n");

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					c.printToOut(listOfFiles[i].getName());
					c.printToOut("\n");
				}
			}

			// Directory
			c.printToOut("Directories:\n");
			c.printToOut("------------\n");
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isDirectory()) {
					c.printToOut(listOfFiles[i].getName());
					c.printToOut("\n");
				}
			}
			c.printToOut("\n");

		} catch (Exception e) {
			c.printToOut("No files, try another path.\n");
		}

	}

}
