package algorithms.search;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class SearchableMaze implements Searchable {
	
	private Maze3d maze;
	
	/**
	 * Adapter for the maze so we can use the search algorithms
	 * to solve it.
	 * Instantiates a new searchable maze.
	 *
	 * @param maze the maze
	 */
	public SearchableMaze(Maze3d maze) {
		this.maze = maze;
	}

	@Override
	public State<Object> getStartState() {
		State<Object>  s = new State<Object>();
		s.setValue(maze.getStartPosition());
		return s;
	}

	@Override
	public State<Object> getGoalState() {
		State<Object>  s = new State<Object>();
		s.setValue(maze.getGoalPosition());
		return s;
	}

	@Override
	public ArrayList<State<Object>> getAllPossibleMoves(State<Object> s) {
		//ArrayList<State<Position>> arr = new ArrayList<State<Position>>();
		ArrayList<State<Object>> arr = new ArrayList<State<Object>>();
		State<Object> temp;
		Position p = new Position((Position)s.getValue());
		String[] moves = this.maze.getPossibleMoves((Position)s.getValue());
		
		for (String string : moves) {
			temp = new State<Object>();
			if(string.equals("left")) temp.setValue(p.getLeft());
			else if(string.equals("right")) temp.setValue(p.getRight());
			else if(string.equals("back")) temp.setValue(p.getBack());
			else if(string.equals("forward")) temp.setValue(p.getForward());
			else if(string.equals("up")) temp.setValue(p.getUp());
			else if(string.equals("down")) temp.setValue(p.getDown());
			arr.add(temp);
		}
		return arr;
	}

	public void setStartPosition(int x,int y,int z) {
		Position p = new Position(x,y,z);
		this.maze.setStartPosition(p);
		
	}

}
