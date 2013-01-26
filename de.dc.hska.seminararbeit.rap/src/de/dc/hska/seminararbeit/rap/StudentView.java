package de.dc.hska.seminararbeit.rap;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class StudentView extends ViewPart {
	public static final String ID = "de.dc.hska.seminararbeit.rap.view1";

	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		createLabelText(parent, "Name");
		createLabelText(parent, "Firstname");
		createLabelText(parent, "Birthday");
		createLabelText(parent, "Email");
		
	}
	private void createLabelText(Composite parent, String labelName) {
		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		label.setText(labelName);
		
		Text text = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}
	public void setFocus() {
	}
}