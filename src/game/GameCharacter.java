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
		   e.gc.setForeground(new Color(null,255,0,0));
		   e.gc.drawOval(p.getX()*w,p.getY()*h,w,h);
		
	}



	public int getZ() {
		
		return p.getZ();
	}
	
	public Position getP()
	{
		return p;
	}


	
}
