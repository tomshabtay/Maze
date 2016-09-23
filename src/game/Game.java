package game;

import algorithms.mazeGenerators.Maze3d;

public class Game {
	GameCharacter character;
	Maze3d maze;
	

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
	
	
}
