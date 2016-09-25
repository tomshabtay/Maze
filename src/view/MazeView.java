package view;

import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;

public class MazeView extends BasicWindow implements View {

	// A maze display to show and play the current maze
	private MazeDisplay mazeDisplay;
	private String choosenMaze = "itzik";

	@Override
	protected void initWidgets() {
		// Main View of the application
		GridLayout gridLayout = new GridLayout(2, false);
		shell.setLayout(gridLayout);

		mazeDisplay = new MazeDisplay(shell, SWT.BORDER);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Buttons
		Composite btnGroup1 = new Composite(shell, SWT.BORDER);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		btnGroup1.setLayout(rowLayout);

		// Button Play
		Button btnPlay = new Button(btnGroup1, SWT.PUSH);
		btnPlay.setText("Play");

		btnPlay.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("get_maze "+choosenMaze);
				//startPlay();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		
		
		
		
		// Button Show Solution
				Button btnShowSolution = new Button(btnGroup1, SWT.PUSH);
				btnShowSolution.setText("Show Solution");

				btnShowSolution.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						setChanged();
						notifyObservers("get_maze_solution "+choosenMaze);
						//startPlay();

					}

					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub

					}

				});

		
		
		
		
		// Button Generate Maze
		Button btnGenerateMaze = new Button(btnGroup1, SWT.PUSH);
		btnGenerateMaze.setText("Generate maze");

		btnGenerateMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// Open a Pop-up window with other options
				// to enter.
				
				showGenerateMazeOptions();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		// Button Solve Maze
		Button btnSolveMaze = new Button(btnGroup1, SWT.PUSH);
		btnSolveMaze.setText("Solve maze");

		btnSolveMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				showSolveMazeOptions();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// Button Display Maze
		Button btnDisplayMaze = new Button(btnGroup1, SWT.PUSH);
		btnDisplayMaze.setText("Choose maze");

		btnDisplayMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				showDisplayMazeOptions();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		// Button Exit
				Button btnExit = new Button(btnGroup1, SWT.PUSH);
				btnExit.setText("Exit");

				btnExit.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						setChanged();
						notifyObservers("exit");

					}

					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub

					}
				});

	}

	protected void openMenuBar() {

		Menu menuBar = new Menu(shell, SWT.BAR);

		// File
		MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu.setText("&File");

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);

		// File Menu Items
		MenuItem openItem = new MenuItem(fileMenu, SWT.PUSH);
		openItem.setText("&Open properties");

		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("&Exit");

	}

	public void openButtons() {
		// Buttons
		Composite btnGroup = new Composite(shell, SWT.BORDER);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		btnGroup.setLayout(rowLayout);

		// Button Play
		Button btnPlay = new Button(btnGroup, SWT.PUSH);
		btnPlay.setText("Play");

		btnPlay.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				startPlay();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		// Button Generate Maze
		Button btnGenerateMaze = new Button(btnGroup, SWT.PUSH);
		btnGenerateMaze.setText("Generate maze");

		btnGenerateMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// Open a Pop-up window with other options
				// to enter.
				showGenerateMazeOptions();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		// Button Solve Maze
		Button btnSolveMaze = new Button(btnGroup, SWT.PUSH);
		btnSolveMaze.setText("Solve maze");
		

		btnSolveMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				showSolveMazeOptions();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// Button Display Maze
		Button btnDisplayMaze = new Button(btnGroup, SWT.PUSH);
		btnDisplayMaze.setText("Choose maze");

		btnDisplayMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("list_mazes_in_map");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	protected void showGenerateMazeOptions() {
		Shell shell = new Shell();
		shell.setText("Generate Maze");
		shell.setSize(300, 200);

		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		// Text Fields
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Maze Name: ");
		Text txtName = new Text(shell, SWT.BORDER);

		Label lblX = new Label(shell, SWT.NONE);
		lblX.setText("X size: ");
		Text txtXsize = new Text(shell, SWT.BORDER);

		Label lblY = new Label(shell, SWT.NONE);
		lblY.setText("Y size: ");
		Text txtYsize = new Text(shell, SWT.BORDER);

		Label lblZ = new Label(shell, SWT.NONE);
		lblZ.setText("Floors: ");
		Text txtZsize = new Text(shell, SWT.BORDER);

		// Button Generate
		Button btnGenerate = new Button(shell, SWT.PUSH);
		btnGenerate.setText("Generate");
		btnGenerate.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				choosenMaze = txtName.getText();
				notifyObservers("generate_3d_maze" + " " + txtName.getText() + " " + txtXsize.getText() + " "
						+ txtYsize.getText() + " " + txtZsize.getText());
				shell.close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		shell.open();
	}

	protected void showDisplayMazeOptions() {
		setChanged();
		notifyObservers("list_mazes_in_map");
	}

	protected void showSolveMazeOptions() {
		Shell shell = new Shell();
		shell.setText("Solve Maze");
		shell.setSize(300, 200);

		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		// Text Fields
		

		// Algorithm for searching
		Button[] radios = new Button[2];

		radios[0] = new Button(shell, SWT.RADIO);
		radios[0].setSelection(true);
		radios[0].setText("DFS");
		radios[0].setBounds(10, 5, 75, 30);

		radios[1] = new Button(shell, SWT.RADIO);
		radios[1].setText("BFS");
		radios[1].setBounds(10, 5, 75, 30);

		// Button Solve
		Button btnSolve = new Button(shell, SWT.PUSH);
		btnSolve.setText("Solve");

		btnSolve.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// Check Algo
				String TextAlgo = null;
				if (radios[0].getSelection())
					TextAlgo = "DFS";
				else if (radios[1].getSelection())
					TextAlgo = "BFS";

				setChanged();

				notifyObservers("solve_maze" + " " + choosenMaze + " " + TextAlgo);
				shell.close();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		shell.open();
	}

	protected void startPlay() {

		setChanged();
		notifyObservers("get_maze tom");
	}

	public void play(Maze3d maze) {
		mazeDisplay.setMaze(maze);
		mazeDisplay.start();

	}

	public void getMazeList(Set<String> str) {

		Shell miniShell = new Shell();
		miniShell.setText("");
		miniShell.setSize(150, 200);

		GridLayout layout = new GridLayout(2, false);
		miniShell.setLayout(layout);

		List l = new List(miniShell, SWT.SINGLE | SWT.BORDER);
		l.setBounds(50, 50, 75, 75);

		for (String string : str) {
			l.add(string);
		}

		// Choose
		Button btnDisplay = new Button(miniShell, SWT.PUSH);
		btnDisplay.setText("Choose");
		btnDisplay.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				choosenMaze = l.getSelection()[0];
				
				//setChanged();
				//notifyObservers("get_maze " + l.getSelection()[0]);
				miniShell.close();
				
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		// Delete Selected
				Button btnDelete = new Button(miniShell, SWT.PUSH);
				btnDelete.setText("Delete Selected");
			
				btnDelete.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						choosenMaze = l.getSelection()[0];
						
						setChanged();
						notifyObservers("delete_maze " + l.getSelection()[0]);
						miniShell.close();
						setChanged();
						notifyObservers("list_mazes_in_map");
						
						
						
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub

					}
				});
				
				// Delete All
				Button btnDeleteAll = new Button(miniShell, SWT.PUSH);
				btnDeleteAll.setText("Delete All");
				btnDeleteAll.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent arg0) {
						
						setChanged();
						notifyObservers("delete_all_mazes");
						miniShell.close();
						
						
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub

					}
				});


		miniShell.open();

	}

	public void playMaze(Maze3d m) {
		mazeDisplay.setMaze(m);
		mazeDisplay.start();

	}

	public void start() {

	}
	
	public void displayMessage(String msg){
		MessageBox messageBox = new MessageBox(shell, SWT.NONE);
        
        messageBox.setText("Maze3D");
        messageBox.setMessage(msg);
        messageBox.open();
	}

	public void getSolution(Solution s,Maze3d m) {
		mazeDisplay.showSolution(s,m);
		
	}

	public void exit() {
		shell.dispose();
		
	}

}
