package game;


import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class GameCharacter{
	Position p;
	
	public GameCharacter(int x,int y,int z){
		p = new Position(x, y, z);

	}
	

	
	public void paint(PaintEvent e,int w,int h){
		   e.gc.setForeground(new Color(null,255,140,0));
		   e.gc.setBackground(new Color(null,255,140,0));
		   e.gc.fillOval(p.getX()*w,p.getY()*h,w,h);
		
	}



	public int getZ() {
		
		return p.getZ();
	}
	
	public Position getP()
	{
		return p;
	}



	public void setPosition(int x, int y, int z) {
		p.set(x, y, z);
		
	}



	public int getY() {
		return p.getY();
	}
	
	public int getX() {
		return p.getX();
	}



	
}
