package view;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import game.Game;
import game.GameCharacter;

public class MazeDisplay extends Canvas {

	private int[][] mazeData;

	Game game;

	GameCharacter character;
	Timer timer;
	TimerTask timerTask;
	Maze3d maze;

	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
		this.maze = null;
		this.redraw();
	}

	public MazeDisplay(Shell parent, int style) {
		super(parent, style);

		//Key Listener
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				if(e.character == 'w'){
					System.out.println("w");
					game.moveUp();
					info();
				}
				if(e.character == 's'){
					game.moveDown();
					info();

				}
				if(e.character == 'd'){
					game.moveRight();
					info();

				}
				if(e.character == 'a'){
					game.moveLeft();
					info();

				}

				if(e.character == 'e'){
					game.moveFloorUp();
					info();


				}
				if(e.character == 'q'){
					game.moveFloorDown();
					info();


				}

			}
		});



		this.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				if (maze !=null)mazeData = maze.getCrossSectionByZ(character.getZ());

				if (mazeData == null)
					return;

				e.gc.setForeground(new Color(null, 0, 0, 0));
				e.gc.setBackground(new Color(null, 0, 0, 0));

				int width = getSize().x;
				int height = getSize().y;

				int w = width / mazeData[0].length;
				int h = height / mazeData.length;


				//making the maze
				for (int i = 0; i < mazeData.length; i++)
					for (int j = 0; j < mazeData[i].length; j++) {
						int x = j * w;
						int y = i * h;
						if (mazeData[j][i] == 1){ //draw wall
						e.gc.setForeground(new Color(null, 0, 0, 0));
						e.gc.setBackground(new Color(null, 0, 0, 0));
						e.gc.fillRectangle(x, y, w, h);
						}
						
						else if(mazeData[j][i] == 2) { //move up
						e.gc.setForeground(new Color(null, 55, 55, 0));
						e.gc.setBackground(new Color(null, 55, 55, 0));
						e.gc.fillRectangle(x, y, w/4, h/4);
						}
						
						else if(mazeData[j][i] == 3) {//starting point
							e.gc.setForeground(new Color(null, 90, 90, 0));
							e.gc.setBackground(new Color(null, 90, 90, 0));
							e.gc.fillRectangle(x, y, w, h);
							}
						
						else if(mazeData[j][i] == 4) {//exit point
							e.gc.setForeground(new Color(null, 160, 160, 0));
							e.gc.setBackground(new Color(null, 160, 160, 0));
							e.gc.fillRectangle(x, y, w, h);
							}
					}


				character.paint(e, w, h);

			}
		});
	}

	public void start() {
		timer = new Timer();
		timerTask = new TimerTask() {

			@Override
			public void run() {
				getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {

						redraw();
					}
				});

			}

		};
		timer.scheduleAtFixedRate(timerTask, 0, 100);
	}

	public void setMazeDataSample() {
		int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
				{ 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

		this.setMazeData(maze);

	}

	public void setMaze(Maze3d maze) {

		character = new GameCharacter(maze.getStartPosition().getX(),maze.getStartPosition().getY(),maze.getStartPosition().getZ());
		maze.paintMazeIndicators();
		this.maze = maze;
		game = new Game(character,maze);
	}

	public void info(){
		System.out.println(character.getP());
		System.out.println(maze.getPossibleMovesString(character.getP()));
	}
}
