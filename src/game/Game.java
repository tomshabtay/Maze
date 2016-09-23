package game;

import algorithms.mazeGenerators.Maze3d;

public class Game {
	GameCharacter character;
	Maze3d maze;
	int level;
	

	public Game(GameCharacter character, Maze3d maze, int level) {
		this.character = character;
		this.level = level;
		this.maze = maze;
	}

}
