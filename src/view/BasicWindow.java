package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

@SuppressWarnings("unused")
public class BasicWindow implements Runnable {

	// Size of the screen
	private int widthScreen = 500;
	private int higthScreen = widthScreen - widthScreen / 2;

	private String title;

	private Display display;
	private Shell shell;

	public BasicWindow(String title) {

		display = new Display();
		shell = new Shell(display);

		shell.setSize(widthScreen, higthScreen);
		this.title = title;
		if (title != null)
			shell.setText(title);

		centerWindow(shell);
	}

	public void initWidgets() {
		// Layout
		GridLayout layout = new GridLayout();
		layout.marginLeft = 50;
		layout.marginTop = 50;
		shell.setLayout(layout);

		// ***********
		// * Widgets *
		// ***********

		MazeButtonsWIdget mazeBtn = new MazeButtonsWIdget(shell, SWT.NONE);
		mazeBtn.setLayout(layout);
		mazeBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
	}

	private static void centerWindow(Shell shell) {

		Rectangle bds = shell.getDisplay().getBounds();
		Point p = shell.getSize();

		int nLeft = (bds.width - p.x) / 2;
		int nTop = (bds.height - p.y) / 2;

		shell.setBounds(nLeft, nTop, p.x, p.y);
	}

	@Override
	public void run() {
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
