package view;


import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class GameCharacter{
	int x,y;
	
	public GameCharacter(int x,int y){
		this.x = x;
		this.y = y;
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
	
	
}
