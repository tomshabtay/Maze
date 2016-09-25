package boot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import algorithms.mazeGenerators.Maze3d;

public class Test {

	public static void main(String[] args) {
		
		HashMap<String,Maze3d> hm = new HashMap<String,Maze3d>();
		hm.put("maze1", new Maze3d());
		hm.put("maze2", new Maze3d());
		hm.put("maze3", new Maze3d());
		hm.put("mazetom", new Maze3d());
		hm.put("gal", new Maze3d());

		Set<String> str = hm.keySet();
		
		for (String string : str) {
			System.out.println(string);
		}		
		
		//System.out.println(str);
		
		//hm.keySet()
	}

}
