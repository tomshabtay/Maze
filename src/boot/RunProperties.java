package boot;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import model.Properties;

public class RunProperties {

	public static void main(String[] args) {
		Properties p = new Properties();
		p.setNumOfThreads(10);
		p.setGenerateAlgorithm("GrowingTree");
		p.setSolveMaze("BFS");
		XMLEncoder xmlEncoder = null;
		try {
			xmlEncoder = new XMLEncoder(new FileOutputStream("properties.xml"));
			xmlEncoder.writeObject(p);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			xmlEncoder.close();
		}
	}

}
