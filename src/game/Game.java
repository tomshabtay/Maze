package game;

import java.util.ArrayList;

import org.eclipse.swt.graphics.Color;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;

public class Game {
	GameCharacter character;
	Maze3d maze;
	
	Solution solution;
	ArrayList<State> arraySolutionSteps;
	int solutionSteps;
	int count = 0;
	

	public Game(GameCharacter character, Maze3d maze) {
		this.character = character;

		this.maze = maze;
	}

	public void moveUp(){
		if(maze.getPossibleMovesString(character.p).contains("up")){
		character.p.moveUp();
		}
		
	}
	
	public void moveDown(){
		if(maze.getPossibleMovesString(character.p).contains("down")){
		character.p.moveDown();
		}
	}
	
	public void moveRight(){
		if(maze.getPossibleMovesString(character.p).contains("right")){
		character.p.moveRight();
		}
		
	}
	
	public void moveLeft(){
		if(maze.getPossibleMovesString(character.p).contains("left")){
		character.p.moveLeft();
		}
		
	}
	
	public void moveFloorUp(){
		if(maze.getPossibleMovesString(character.p).contains("celling")){
		character.p.moveFloorUp();
		}
		
	}
	
	public void moveFloorDown(){
		if(maze.getPossibleMovesString(character.p).contains("floor")){
		character.p.moveFloorDown();
		}
		
	}
	
	public Color colorScale(){
		int distance = maze.getZ() - character.getZ();
		int n = 100/maze.getZ();
		int R = (255 * distance*n) / 100;
		int G = (255 * (100 - distance*n)) / 100 ;
		int B = 30;
		return new Color(null, R, B, G);
	}

	public void setSolution(Solution s) {
		this.solution = s;
		
		
		arraySolutionSteps = s.getStates();

		solutionSteps = arraySolutionSteps.size();
		count = solutionSteps;
		
	}
	
	public boolean moveCharcterToSolution(){
		
		if (count <= 0) return true;
		
		System.out.println(arraySolutionSteps.get(solutionSteps - count).getValue());
		
		Object p = arraySolutionSteps.get(solutionSteps - count).getValue();
		int x = ((Position)p).getX();
		int y = ((Position)p).getY();
		int z = ((Position)p).getZ();

		character.p.set(x, y, z);
		count--;
		return false;
	}
	
	
	
}
