package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * The Class Solution giving as the solution for a problem genrated by the Searcher.
 */
public class Solution implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The states that giving as the solution. */
	private ArrayList<State> states;
	
	/** The evaluated nodes number. */
	private int evaluatedNodes;

	/**
	 * Gets the states for the solution.
	 *
	 * @return the states
	 */
	public ArrayList<State> getStates() {
		return states;
	}
	
	/**
	 * Sets the states for the solution.
	 *
	 * @param newstates the new states
	 */
	public void setStates(ArrayList<State> newstates) {
		this.states = newstates;	
	}
	
	/**
	 * Prints the solution.
	 */
	public void printSolution()
	{
		int count = 0;
		for (State state : states) {
			count++;
			System.out.println(state.getValue());
		}
		System.out.println("Distance:" + count);
		System.out.println("States evaluated:" + evaluatedNodes);
	}

	/**
	 * Gets the evaluated nodes.
	 *
	 * @return the evaluated nodes
	 */
	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}

	/**
	 * Sets the evaluated nodes.
	 *
	 * @param evaluatedNodes the new evaluated nodes
	 */
	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}


}
