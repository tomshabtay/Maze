package algorithms.search;

import java.io.Serializable;

/**
 * State is used by a Searcher to describe a state that the Searcher needs
 * to evaluate.
 *  
 * @author tomshabtay
 *
 * @param <T>
 * this parameter is used to adapt the algorithm to a specific
 * problem, in case of a Maze Problem the algorithm will evaluate
 * 
 */



public class State<T> implements Comparable<State> , Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The value specific for the problem. */
	private T value;
	
	/** The description (if needed). */
	private String description;
	
	/** The cost to get to that state */
	private double cost;
	
	/** Were we came from. (parent) */
	private State cameFrom;
	
	/** The visited boolean. */
	private boolean visited;

	
	/**
	 * Checks if is visited.
	 *
	 * @return true, if is visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Sets the visited.
	 *
	 * @param visited the new visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * Instantiates a new state.
	 */

	public State()
	{
		this.visited = false;
	}
	

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Gets the came from.
	 *
	 * @return the came from
	 */
	public State getCameFrom() {
		return cameFrom;
	}
	
	/**
	 * Sets the came from.
	 *
	 * @param cameFrom the new came from
	 */
	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(State o) {
		return (int)(this.cost - o.cost);		
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		State s = (State)obj;
		return (s.getValue().equals(this.getValue()));
	}
	
	
}
