package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import algorithms.mazeGenerators.Maze3d;

public class MazeWindow extends BasicWindow {

	private MazeDisplay mazeDisplay;

	@Override
	protected void initWidgets() {
		GridLayout gridLayout = new GridLayout(2, false);
		shell.setLayout(gridLayout);

		Composite btnGroup = new Composite(shell, SWT.BORDER);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		btnGroup.setLayout(rowLayout);

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
		
		
	}

	
	
	
	protected void showSolveMazeOptions() {
		Shell shell = new Shell();
		shell.setText("Solve Maze");
		shell.setSize(300, 200);

		GridLayout layout = new GridLayout(2, false);
		shell.setLayout(layout);

		// Text Fields
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setText("Maze Name: ");
		Text txtName = new Text(shell, SWT.BORDER);

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

				notifyObservers("solve_maze" + " " + txtName.getText() + " " + TextAlgo);
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
				notifyObservers("generate_maze" + " " + txtName.getText() + " " + txtXsize.getText() + " "
						+ txtYsize.getText() + " " + txtZsize.getText());
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
