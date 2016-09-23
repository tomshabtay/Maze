package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class Maze3d {

	private int[][][] maze3d;
	private Position startPosition;
	private Position exitPosition;

	// size
	private int x;
	private int y;
	private int z;

	public Maze3d() {

	}

	public Maze3d(byte[] b) {
		// setting the size
		this.x = b[0];
		this.y = b[1];
		this.z = b[2];

		// setting the positions
		startPosition = new Position(b[3], b[4], b[5]);
		exitPosition = new Position(b[6], b[7], b[8]);

		// setting the maze
		int count = 9;
		maze3d = new int[x][y][z];
		for (int i = 0; i < this.z; i++) {
			for (int j = 0; j < this.y; j++) {
				for (int j2 = 0; j2 < this.x; j2++) {
					this.maze3d[j2][j][i] = b[count];
					count++;
				}
			}
		}

	}

	public void paintMaze(int x, int y, int z, int color) {
		this.maze3d[x][y][z] = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public String[] getPossibleMoves(Position p) {
		String s = "";
		if (p.getX() - 1 > 0 && this.maze3d[p.getX() - 1][p.getY()][p.getZ()] == 0) {
			s = s + "left,";
		}
		if (p.getX() + 1 < this.x && this.maze3d[p.getX() + 1][p.getY()][p.getZ()] == 0) {
			s = s + "right,";
		}
		if (p.getY() + 1 < this.y && this.maze3d[p.getX()][p.getY() + 1][p.getZ()] == 0) {
			s = s + "back,";
		}
		if (p.getY() - 1 > 0 && this.maze3d[p.getX()][p.getY() - 1][p.getZ()] == 0) {
			s = s + "forward,";
		}
		if (p.getZ() + 1 < this.z && this.maze3d[p.getX()][p.getY()][p.getZ() + 1] == 0) {
			s = s + "up,";
		}
		if (p.getZ() - 1 > 0 && this.maze3d[p.getX()][p.getY()][p.getZ() - 1] == 0) {
			s = s + "down,";
		}

		return s.split(",");
	}

	// For Game Class
	public String getPossibleMovesString(Position p) {
		String s = "";
		if (p.getX() - 1 > 0 && this.maze3d[p.getX() - 1][p.getY()][p.getZ()] != 1) {
			s = s + "left,";
		}
		if (p.getX() + 1 < this.x && this.maze3d[p.getX() + 1][p.getY()][p.getZ()] != 1) {
			s = s + "right,";
		}
		if (p.getY() + 1 < this.y && this.maze3d[p.getX()][p.getY() + 1][p.getZ()] != 1) {
			s = s + "down,";
		}
		if (p.getY() - 1 > 0 && this.maze3d[p.getX()][p.getY() - 1][p.getZ()] != 1) {
			s = s + "up,";
		}
		if (p.getZ() + 1 < this.z && this.maze3d[p.getX()][p.getY()][p.getZ() + 1] != 1) {
			s = s + "celling,";
		}
		if (p.getZ() - 1 > 0 && this.maze3d[p.getX()][p.getY()][p.getZ() - 1] != 1) {
			s = s + "floor,";
		}

		return s;
	}

	public int[][][] getMaze3d() {
		return maze3d;
	}

	public void setMaze3d(int[][][] maze3d) {
		this.maze3d = maze3d;
	}

	public Position getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Position startPosition) {

		this.startPosition = new Position(startPosition);
	}

	public Position getGoalPosition() {
		return exitPosition;
	}

	public void setExitPosition(Position exitPosition) {
		this.exitPosition = new Position(exitPosition);
	}

	public void printMaze() {
		System.out.print("Start position: ");
		if (this.startPosition != null)
			this.startPosition.printPosition();

		System.out.println();
		System.out.print("End position: ");
		if (this.exitPosition != null)
			this.exitPosition.printPosition();

		System.out.println();
		System.out.println("Maze:");

		for (int i = 0; i < this.z; i++) {
			System.out.println();

			for (int j = 0; j < this.y; j++) {

				for (int j2 = 0; j2 < this.x; j2++) {
					System.out.print(this.maze3d[j2][j][i] + ", ");
				}
				System.out.println();
			}

		}

	}

	public int[][] getCrossSectionByX(int x) {
		int[][] maze2d = new int[this.y][this.z];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < z; j++) {
				maze2d[i][j] = this.maze3d[x][i][j];
			}
		}
		return maze2d;
	}

	public void printCrossSectionByX(int[][] maze2d) {
		System.out.println("Cross section by x:");
		for (int i = 0; i < y; i++) {
			System.out.println();
			for (int j = 0; j < z; j++) {
				System.out.print(maze2d[i][j] + ", ");
			}
		}
		System.out.println();
	}

	public int[][] getCrossSectionByY(int y) {
		int[][] maze2d = new int[this.x][this.z];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < z; j++) {
				maze2d[i][j] = this.maze3d[i][y][j];
			}
		}
		return maze2d;
	}

	public void printCrossSectionByY(int[][] maze2d) {
		System.out.println("Cross section by y:");
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < z; j++) {
				System.out.print(maze2d[i][j] + ", ");
			}
		}
		System.out.println();
	}

	public int[][] getCrossSectionByZ(int z) {
		int[][] maze2d = new int[this.x][this.y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				maze2d[i][j] = this.maze3d[i][j][z];
			}
		}
		return maze2d;
	}

	public void printCrossSectionByZ(int[][] maze2d) {
		System.out.println("Cross section by z:");
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < y; j++) {
				System.out.print(maze2d[i][j] + ", ");
			}
		}
		System.out.println();
	}

	public void setRandomStart() {
		Random r = new Random();
		int randx;
		int randy;
		int randz;

		do {
			randx = r.nextInt(x);
			randy = r.nextInt(y);
			randz = r.nextInt(z);
			if (this.maze3d[randx][randy][randz] == 0) {
				this.startPosition = new Position(randx, randy, randz);
			}
		} while (!(this.maze3d[randx][randy][randz] == 0));

	}

	public void setRandomExit() {
		Random r = new Random();
		int randx;
		int randy;
		int randz;

		do {
			randx = r.nextInt(x);
			randy = r.nextInt(y);
			randz = r.nextInt(z);
			if (this.maze3d[randx][randy][randz] == 0) {
				this.exitPosition = new Position(randx, randy, randz);
			}
		} while (!(this.maze3d[randx][randy][randz] == 0));

	}

	public byte[] toByteArray() {
		ArrayList<Byte> arr = new ArrayList<Byte>();

		// adding the size
		arr.add((byte) this.x);
		arr.add((byte) this.y);
		arr.add((byte) this.z);

		// adding the positions
		arr.add((byte) this.startPosition.getX());
		arr.add((byte) this.startPosition.getY());
		arr.add((byte) this.startPosition.getZ());

		arr.add((byte) this.exitPosition.getX());
		arr.add((byte) this.exitPosition.getY());
		arr.add((byte) this.exitPosition.getZ());

		// adding the maze
		for (int i = 0; i < this.z; i++) {
			for (int j = 0; j < this.y; j++) {
				for (int j2 = 0; j2 < this.x; j2++) {
					arr.add((byte) this.maze3d[j2][j][i]);
				}
			}
		}

		// converting the ArrayList to Array
		byte[] arr2 = new byte[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			arr2[i] = arr.get(i);
		}

		return arr2;
	}

	@Override
	public boolean equals(Object obj) {
		Maze3d m = (Maze3d) obj;
		// checking positions and size
		if ((this.x == m.x) && (this.y == m.y) && (this.z == m.z) && this.exitPosition.equals(m.exitPosition)
				&& this.startPosition.equals(m.startPosition)) {

			// checking the maze
			for (int i = 0; i < this.z; i++) {
				for (int j = 0; j < this.y; j++) {
					for (int j2 = 0; j2 < this.x; j2++) {
						if (this.maze3d[j2][j][i] != m.maze3d[j2][j][i])
							return false;

					}
				}
			}

			return true;

		} else
			return false;
	}

	public boolean possibleToMoveUp(int x, int y, int z) {

		return (this.maze3d[x][y][z] == 0 && this.maze3d[x][y][z + 1] == 0);
	}

	public void paintMazeIndicators() {
		paintMaze(startPosition.getX(), startPosition.getY(), startPosition.getZ(), 3);
		paintMaze(exitPosition.getX(), exitPosition.getY(), exitPosition.getZ(), 4);
		
		for (int i = 0; i < this.z; i++) {
			for (int j = 0; j < this.y; j++) {
				for (int j2 = 0; j2 < this.x; j2++) {
					if (this.maze3d[j2][j][i] == 0 && this.maze3d[j2][j][i + 1] == 0) this.maze3d[j2][j][i] = 2;
				}
			}
		}
	}

}// end of class