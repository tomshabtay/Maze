package algorithms.mazeGenerators;

import algorithms.search.State;

public class Position {
	private int x, y, z;
	private static int limitX, limitY, limitZ = 1000;

	public Position() {

	}

	public Position(Position p) {
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
	}

	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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

	public void set(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void setLimits(int x, int y, int z) {
		Position.limitX = x;
		Position.limitY = y;
		Position.limitZ = z;
	}

	public boolean isEqual(Position p2) {
		if (this.x == p2.x && this.y == p2.y)
			return true;
		else
			return false;
	}

	public boolean isEqualX(Position p2) {
		if (this.x == p2.x)
			return true;
		else
			return false;
	}

	public boolean isEqualY(Position p2) {
		if (this.y == p2.y)
			return true;
		else
			return false;
	}

	public void printPosition() {
		System.out.print("(" + this.x + "," + this.y + "," + this.z + ")");
	}

	@Override
	public String toString() {
		return "{" + this.x + "," + this.y + "," + this.z + "}";
	}

	public Position getRight() {
		return new Position(x + 1, y, z);
	}

	public Position getLeft() {
		return new Position(x - 1, y, z);
	}

	public Position getBack() {
		return new Position(x, y + 1, z);
	}

	public Position getUp() {
		return new Position(x, y, z + 1);
	}

	public Position getDown() {
		return new Position(x, y, z - 1);
	}

	public Position getForward() {
		return new Position(x, y - 1, z);
	}

	@Override
	public boolean equals(Object obj) {
		Position p = (Position) obj;
		if ((this.x == p.x) && (this.y == p.y) && (this.z == p.z)) {
			return true;
		} else
			return false;
	}

	public void incX() {
		if (this.x < Position.limitX)
			this.x++;
	}

	public void incY() {
		if (this.y < Position.limitY)
			this.y++;
	}

	public void incZ() {
		if (this.z < Position.limitZ)
			this.z++;
	}

	public void decX() {
		if (this.x > 0)
			this.x--;
	}

	public void decY() {
		if (this.y > 0)
			this.y--;
	}

	public void decZ() {
		if (this.z > 0)
			this.z--;
	}
	
	
	//Game Moves
	public void moveLeft() {
			this.x--;
	}

	public void moveDown() {
			this.y++;
	}

	public void moveFloorUp() {
			this.z++;
	}

	public void moveRight() {
			this.x++;
	}

	public void moveUp() {
			this.y--;
	}

	public void moveFloorDown() {
			this.z--;
	}



}
