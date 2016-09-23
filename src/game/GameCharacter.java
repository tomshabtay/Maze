package game;


import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class GameCharacter{
	Position p;
	
	public GameCharacter(int x,int y,int z){
		p.set(x, y, z);
	}
	

	
	public void paint(PaintEvent e,int w,int h){
		   e.gc.setForeground(new Color(null,255,0,0));
		   e.gc.drawOval(x*w,y*h,w,h);
		   System.out.println(x+","+y);
		
	}



	public void decY() {
		p.decX();
		
	}



	public void incX() {
		x++;
		
	}



	public void decX() {
		x--;
		
	}



	public void incY() {
		y++;
		
	}



	public int getZ() {

		return z;
	}
	
	
}
