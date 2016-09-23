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
import game.Game;
import game.GameCharacter;

public class MazeDisplay extends Canvas {

	private int[][] mazeData;
	
	Game game;
	
	GameCharacter character;
	Timer timer;
	TimerTask timerTask;
	Maze3d maze;
	protected int level = 0;

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
					character.decY();
				}
				if(e.character == 's'){
					System.out.println("s");
					character.incY();

				}
				if(e.character == 'a'){
					System.out.println("a");
					character.decX();

				}
				if(e.character == 'd'){
					System.out.println("d");
					character.incX();

				}
				
				if(e.character == 'e'){
					System.out.println("e");
					level++;

				}
				if(e.character == 'q'){
					System.out.println("e");
					level--;

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

				for (int i = 0; i < mazeData.length; i++)
					for (int j = 0; j < mazeData[i].length; j++) {
						int x = j * w;
						int y = i * h;
						if (mazeData[i][j] != 0)
							e.gc.fillRectangle(x, y, w, h);
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
		this.maze = maze;
		character = new GameCharacter(maze.getStartPosition().getX(),maze.getStartPosition().getY(),maze.getStartPosition().getZ());
		level = maze.getStartPosition().getZ();
		game = new Game(character,maze,level);
	}
}
