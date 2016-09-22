package view;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import algorithms.mazeGenerators.Maze3d;
import presenter.Presenter;

public class MazeView extends BasicWindow  implements View{

	private MazeDisplay mazeDisplay;


	@Override
	protected void initWidgets() {
		GridLayout gridLayout = new GridLayout(2, false);
		shell.setLayout(gridLayout);

		Composite btnGroup = new Composite(shell, SWT.BORDER);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		btnGroup.setLayout(rowLayout);

		menuBar();
		
		//Button Generate Maze
		Button btnGenerateMaze = new Button(btnGroup, SWT.PUSH);
		btnGenerateMaze.setText("Generate maze");

		btnGenerateMaze.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//Open a Pop-up window with other options
				//to enter.
				showGenerateMazeOptions();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}



		});

		//Button Solve Maze
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
		
		//Button Display Maze
				Button btnDisplayMaze = new Button(btnGroup, SWT.PUSH);
				btnDisplayMaze.setText("Display maze");

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

	}

	protected void menuBar(){

		Menu menuBar = new Menu(shell, SWT.BAR);
		
		//File
		MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu.setText("&File");

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);

	

		//File Menu Items
		MenuItem openItem = new MenuItem(fileMenu, SWT.PUSH);
		openItem.setText("&Open properties");

		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("&Exit");

		
	}
	

	protected void showSolveMazeOptions() {
		Shell shell = new Shell();
		shell.setText("Solve Maze");
		shell.setSize(300, 200);

		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		//Text Fields
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Maze Name: ");
		Text txtName = new Text(shell, SWT.BORDER);

		//Algorithm for searching
		Button[] radios = new Button[2];

		radios[0] = new Button(shell,SWT.RADIO);
		radios[0].setSelection(true);
		radios[0].setText("DFS");
		radios[0].setBounds(10, 5, 75, 30);

		radios[1] = new Button(shell,SWT.RADIO);
		radios[1].setText("BFS");
		radios[1].setBounds(10, 5, 75, 30);




		//Button Solve
		Button btnSolve = new Button(shell, SWT.PUSH);
		btnSolve.setText("Solve");

		btnSolve.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//Check Algo
				String TextAlgo = null;
				if(radios[0].getSelection()) TextAlgo = "DFS";
				else if(radios[1].getSelection()) TextAlgo = "BFS";

				setChanged();

				notifyObservers("solve_maze"+  " " + txtName.getText() + " " +  TextAlgo);
				shell.close();



			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		mazeDisplay = new MazeDisplay(shell, SWT.NONE);
		shell.open();
	}

	protected void showGenerateMazeOptions() {
		Shell shell = new Shell();
		shell.setText("Generate Maze");
		shell.setSize(300, 200);

		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		//Text Fields
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


		//Button Generate
		Button btnGenerate = new Button(shell, SWT.PUSH);
		btnGenerate.setText("Generate");
		btnGenerate.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("generate_3d_maze"+  " " + txtName.getText() + " " + txtXsize.getText() + " " + txtYsize.getText() + " " + txtZsize.getText());
				shell.close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		mazeDisplay = new MazeDisplay(shell, SWT.NONE);
		shell.open();
	}

	protected void showDisplayMazeOptions(){
		setChanged();
		notifyObservers("list_mazes_in_map");
	}
	
	@Override
	public void notifyMazeIsReady(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayMaze(Maze3d maze) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayMessage(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	public void printToOut(String str) {
		// TODO Auto-generated method stub

	}

	public void getMazeList(String[] mazes) {
		Shell shell = new Shell();
		shell.setText("Choose a maze");
		shell.setSize(300, 200);

		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);
		
		List l = new List(shell, SWT.SINGLE | SWT.BORDER);
		l.setBounds(50, 50, 75, 75);
		for (String string : mazes) {
			l.add(string);
			
		}
		
		
		
		//Display
		Button btnDisplay = new Button(shell, SWT.PUSH);
		btnDisplay.setText("Display");
		btnDisplay.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
	
				
				setChanged();
				notifyObservers("display_maze");
				shell.close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
        
		
		
		
		mazeDisplay = new MazeDisplay(shell, SWT.NONE);
		shell.open();

	

	}





}
