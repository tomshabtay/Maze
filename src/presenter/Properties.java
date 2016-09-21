package presenter;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Properties implements Serializable {

	private int numOfThreads;
	private String generateAlgorithm;
	private String solveAlgorithm;

	public Properties(/*int numOfThreads, String generateAlgorithm, String solveAlgorithm*/) {
	//	this.numOfThreads = numOfThreads;
	//	this.generateAlgorithm = generateAlgorithm;
	//	this.solveAlgorithm = solveAlgorithm;

	}

	public int getNumOfThreads() {
		return numOfThreads;
	}

	public void setNumOfThreads(int numOfThreads) {
		this.numOfThreads = numOfThreads;
	}

	public String getGenerateAlgorithm() {
		return generateAlgorithm;
	}

	public void setGenerateAlgorithm(String generateAlgorithm) {
		this.generateAlgorithm = generateAlgorithm;
	}

	public String getSolveMaze() {
		return solveAlgorithm;
	}

	public void setSolveMaze(String solveAlgorithm) {
		this.solveAlgorithm = solveAlgorithm;
	}

}
