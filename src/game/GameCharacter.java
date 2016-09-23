package game;


import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class GameCharacter{
	int x,y,z;
	
	public GameCharacter(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	

	
	public void paint(PaintEvent e,int w,int h){
		   e.gc.setForeground(new Color(null,255,0,0));
		   e.gc.drawOval(x*w,y*h,w,h);
		   System.out.println(x+","+y);
		
	}



	public void decY() {
		y--;
		
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
