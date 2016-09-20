package view;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MazeButtonsWIdget extends Canvas {


	public MazeButtonsWIdget(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		
		//***************Maze Options*********************
		Label lblMazeOptions = new Label(this, SWT.NONE);
		lblMazeOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblMazeOptions.setText("Maze Options");
		
		
		Button btnGenerate = new Button(this, SWT.NONE);
		btnGenerate.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnGenerate.setText("Generate");
		
		Button btnDisplay = new Button(this, SWT.NONE);
		btnDisplay.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnDisplay.setText("Display");
		
		Button btnSolve = new Button(this, SWT.NONE);
		btnSolve.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnSolve.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSolve.setText("Solve");

		
		//***************Maze Files*********************

		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnSave.setText("Save");
		
		Button btnLoad = new Button(this, SWT.NONE);
		btnLoad.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLoad.setText("Load");
		
		
		//**************Other*********************
		Label lblOther = new Label(this, SWT.NONE);
		lblOther.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblOther.setText("Other");
		
		Button btnLoadPro = new Button(this, SWT.NONE);
		btnLoadPro.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnLoadPro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLoadPro.setText("Open properties");
		
		Button btnExit = new Button(this, SWT.NONE);
		btnExit.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExit.setText("Exit");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
