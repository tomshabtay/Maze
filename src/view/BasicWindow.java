package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
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
		RowLayout layout = new RowLayout();
		layout.marginLeft = 50;
		layout.marginTop = 50;
		shell.setLayout(layout);

		// ***********
		// * Widgets *
		// ***********

		// Quit Button
		Button quitBtn = new Button(shell, SWT.PUSH);
		quitBtn.setText("Quit");
		quitBtn.setLayoutData(new RowData(60, 40));
		quitBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				shell.getDisplay().dispose();
				System.exit(0);
			}

		});

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
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
