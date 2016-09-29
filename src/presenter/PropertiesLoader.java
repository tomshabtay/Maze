package presenter;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PropertiesLoader {
	private static PropertiesLoader instance;
	private Properties p;

	public Properties getProperties() {
		return p;
	}

	public static PropertiesLoader getInstance() {
		if (instance == null)
			instance = new PropertiesLoader();
		return instance;
	}

	public PropertiesLoader() {
		try {
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("resources/properties.xml"));
			p = (Properties) decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

}
